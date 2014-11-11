package com.mfschool.spring.si.transform;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ContextConfiguration({"object-to-json-transformer.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ObjectToJsonTransformerTest {
	@Autowired
	protected MessageChannel input;
	@Autowired
	protected PollableChannel output;


	@Test
	public void test() {
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Smith");
        customer.setAddress("100 State Street");
        customer.setCity("Los Angeles");
        customer.setState("CA");
        customer.setZip("90064");

        System.out.println("toString(): " + customer.toString());

        Message<Customer> message = MessageBuilder.withPayload(customer).build();
        input.send(message);

        Message<?> reply = output.receive();
        System.out.println("received: " + reply.getPayload());
	}

}
