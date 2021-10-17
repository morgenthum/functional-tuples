# functional-tuples
Introducing functional tuples in Java

## Use cases
### Validation

Let's take a look at the following code:

```java
Order order = ...
if (order != null) {
    Customer customer = order.getCustomer();
    if (customer != null) {
        Address address = customer.getAddress();
        if (address != null) {
            String customerNo = customer.getNumber();
            String city = address.getCity();
            
            if (customerNo != null && city != null) {
                // Do something (like validation)
            }
        }
    }
}
```

Ok, to be honest - this code doesn't match the way we write code in 2021. So what are the opportunities 
to come up with?

We could use a bean validation framework like Hibernate. In most cases it would do the job by annotating
fields with some validation annotations, and we are done. In some other cases, such as cross field validation,
we can probably write our own validator and are done. But sometimes, in more complex cases, like cross object
validation, Hibernate won't do the job, or is awful to use.

In these cases, we end up writing code like in the snippet above, which is incomprehensible and hard to
follow.

There is functional-tuples to help us out:

```java
Unit.of(order) // Unit<Order>
    .map1(Order::getCustomer) // Unit<Customer>
    .unfold(Customer::getAddress) // Tuple<Customer, Address>
    .map1(Customer::getNumber) // Tuple<String, Address>
    .map2(Address::getCity) // Tuple<String, String>
    .ifPresent((customerNo, city) -> {
        // Do something (like validation)
    });
```

So what's going on here? Let's go through each line step by step:

* Wrap the `Order`-object into `Unit`, which is a tuple with one component.
* Map the first component (which is the only one in `Unit`) to `Customer` using `map1`.
* Turn the `Unit` into `Tuple` (two elements) by using `unfold`, which maps the
    rightmost component of `Unit` over a given function, and appends its result.
* We use `map1` over the `Tuple` to map the `Customer` to the `number`-Field
    in the first component.
* Apply `map2` over the `Tuple` to map the `Address` to the `city`-Field
    in the second component.
* Use `ifPresent` to check if each component is not null and apply a function.

What's the deal with it? The big advantages are:

* It's null-safe, because the higher-order functions (`mapX`, `unfold`, `ifX`, etc.),
    do all the null-checks needed, just as you know from `Optional`.
* It's expressive, comprehensible and modern.

## Features

### Lightweight tuples with 1 to 6 components

* `Unit<T>`
* `Tuple<T1, T2>`
* `Tuple3<T1, T2, T3` to `Tuple6<T1, T2, T3, T4, T5, T6>`

### Supports Exceptions

functional-tuples defines its own functional interfaces as extension to `Function` 
and `Consumer` from `java.util.function` - mainly to support multiple parameters
and exceptions.

You are able to write code like this, and throw checked exceptions:

```java
Order order = ...
try {
    Tuple.of(order.getId(), order.getInvoicePath())
        .ifPresent((orderId, path) -> {
            new FileInputStream(path);
        });
} catch (FileNotFoundException e) {
    // ...
}
```





