package com.mfschool.spring.si.transform;

import org.springframework.integration.annotation.Transformer;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Mapper {

    @Transformer
    public Customer map(Map<String, String> message) {
        Customer customer = new Customer();

        customer.setFirstName(message.get("firstName"));
        customer.setLastName(message.get("lastName"));
        customer.setAddress(message.get("address"));
        customer.setCity(message.get("city"));
        customer.setState(message.get("state"));
        customer.setZip(message.get("zip"));
        return customer;
    }
}
