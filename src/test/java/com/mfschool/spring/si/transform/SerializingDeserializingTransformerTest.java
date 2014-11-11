package com.mfschool.spring.si.transform;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

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
@ContextConfiguration({"payload-serializing-deserializing-transformer.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class SerializingDeserializingTransformerTest {
	@Autowired
	protected MessageChannel input;
	@Autowired
	protected PollableChannel output;

	@Test
	public void test() {
        Map<String, String> customerMap = new HashMap<String, String>();
        customerMap.put("firstName", "John");
        customerMap.put("lastName", "Smith");
        customerMap.put("address", "100 State Street");
        customerMap.put("city", "Los Angeles");
        customerMap.put("state", "CA");
        customerMap.put("zip", "90064");

        System.out.println("toString(): " + customerMap.toString());

        Message<Map<String, String>> message =
                MessageBuilder.withPayload(customerMap).build();
        input.send(message);

        Message<?> reply = output.receive();
        System.out.println("received: " + reply.getPayload());
	}
}
