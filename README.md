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
we can probably write our own validator and are done. But sometimes, in more complex cases, Hibernate won't
do the job.

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
