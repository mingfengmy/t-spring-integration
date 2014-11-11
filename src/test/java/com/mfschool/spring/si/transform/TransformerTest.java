package com.mfschool.spring.si.transform;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
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
@ContextConfiguration({"transformer.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TransformerTest {
	private Logger logger=Logger.getLogger(TransformerTest.class);
	@Autowired
	protected MessageChannel input;
	@Autowired
	protected PollableChannel output;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
        Map<String, String> customerMap = new HashMap<String, String>();
        customerMap.put("firstName", "John");
        customerMap.put("lastName", "Smith");
        customerMap.put("address", "100 State Street");
        customerMap.put("city", "Los Angeles");
        customerMap.put("state", "CA");
        customerMap.put("zip", "90064");

        Message<Map<String, String>> message =
                MessageBuilder.withPayload(customerMap).build();
        input.send(message);

        Message<?> reply = output.receive();
        System.out.println("received: " + reply.getPayload());
	}
}
