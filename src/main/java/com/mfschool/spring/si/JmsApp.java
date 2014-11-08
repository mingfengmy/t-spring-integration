package com.mfschool.spring.si;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;

public class JmsApp {

    public static void main(String[] args) {
	    ClassPathXmlApplicationContext context =
	            new ClassPathXmlApplicationContext("classpath:jms-spring-context.xml");
	    context.start();
	
	    MessageChannel input = (MessageChannel) context.getBean("input");
	    //PollableChannel output = (PollableChannel) context.getBean("output");
	    input.send(MessageBuilder.withPayload("Pro Spring Integration Example").build());
	    //Message<?> reply = output.receive();
	    //System.out.println("received: " + reply);
    }

}
