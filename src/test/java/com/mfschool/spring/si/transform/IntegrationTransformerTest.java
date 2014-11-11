package com.mfschool.spring.si.transform;

import static org.junit.Assert.*;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Session;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.core.PollableChannel;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@ContextConfiguration({"integration-transformer.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class IntegrationTransformerTest {
	@Autowired
	private JmsTemplate jmsTemplate;
	@Autowired
	private PollableChannel output;
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {

        jmsTemplate.send(new MessageCreator() {

            @Override
            public javax.jms.Message createMessage(Session session) throws JMSException {
                MapMessage message = session.createMapMessage();
                message.setString("firstName", "John");
                message.setString("lastName", "Smith");
                message.setString("address", "100 State Street");
                message.setString("city", "Los Angeles");
                message.setString("state", "CA");
                message.setString("zip", "90064");
                System.out.println("Sending message: " + message);
                return message;
            }
        });


        Message<?> reply = output.receive();
        System.out.println("received: " + reply.getPayload());
	}

}
