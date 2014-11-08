package com.mfschool.spring.si;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"jms-spring-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class ExampleConfigurationTests {
    @Autowired
    private MessageChannel input;

    @Test 
	public void testSendingMessage() throws Exception {
	    input.send(MessageBuilder.withPayload("Pro Spring Integration Example")
	                    .build());
	
	    Thread.sleep(5000);
	}
}
