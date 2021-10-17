package dev.morgenthum.tuple.test;

import dev.morgenthum.tuple.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

public class ComplexTest {

    private static class Order {
        Customer customer;

        Customer getCustomer() {
            return customer;
        }
    }

    private static class Customer {
        String number;
        Address address;

        String getNumber() {
            return number;
        }

        Address getAddress() {
            return address;
        }
    }

    private static class Address {
        String city;

        String getCity() {
            return city;
        }
    }

    @Test
    public void testCrossfieldValidation() {

        AtomicBoolean valid = new AtomicBoolean(false);

        Order exampleOrder = buildCrossfieldValidationOrder();

        Unit.of(exampleOrder)
            .unfold(Order::getCustomer)
            .unfoldBy((order, customer) -> customer, Customer::getNumber)
            .unfoldBy((order, customer, s) -> customer, Customer::getAddress)
            .unfoldBy((order, customer, s, address) -> address, Address::getCity)
            .ifPresent((order, customer, customerNumber, address, city) -> {
                valid.set("1337".equals(customerNumber) && "Coburg".equals(city));
            });

        Assertions.assertTrue(valid.get());
    }

    private static Order buildCrossfieldValidationOrder() {

        Address address = new Address();
        address.city = "Coburg";

        Customer customer = new Customer();
        customer.number = "1337";
        customer.address = address;

        Order order = new Order();
        order.customer = customer;

        return order;
    }
}
