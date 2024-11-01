package com.lucaszamboni.challenges.coding.interview.greedy.find_first_duplicate_item;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Principal {

    public static class Customer {
        private Long id;
        private String name;

        public Customer(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        List<Customer> customers = List.of(
                new Customer("Alisson"), new Customer("Jaime"), new Customer("Ariel")
                , new Customer("Michele"),  new Customer("Alissonn"), new Customer("Jaime"));

        System.out.println(
                "First Duplication Customer name is: " + Principal.findFirstDuplicatedCustomerNameV2(customers));
    }

    public static String findFirstDuplicatedCustomerName(List<Customer> customers) {
        HashMap<String, Integer> duplicatedValues = new HashMap<>();

        for (Customer customer : customers) {
            duplicatedValues.put(customer.name,
                    duplicatedValues.get(customer.name) == null ? 1 : duplicatedValues.get(customer.name) + 1);

            if (duplicatedValues.get(customer.name) > 1) {
                return customer.name;
            }
        }

        return null;
    }

    public static String findFirstDuplicatedCustomerNameV2(List<Customer> customers) {
        HashSet<String> duplicatedValues = new HashSet<>();

        for (Customer customer : customers) {
            if (!duplicatedValues.add(customer.name))
                return customer.name;
        }
        return null;
    }
}
