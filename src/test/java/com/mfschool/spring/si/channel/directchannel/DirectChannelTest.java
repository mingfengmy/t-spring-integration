package com.mfschool.spring.si.channel.directchannel;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mfschool.spring.si.channel.queuechannel.TicketReceiverTest;
import com.mfschool.spring.si.channels.directchannel.TicketMessageHandler;
@ContextConfiguration({"rendezvous-channel.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class DirectChannelTest extends TicketReceiverTest{
	@Autowired
	private TicketMessageHandler ticketMessageHandler;
	@Before
	public void setUp() throws Exception {
		DirectChannel directChannel=(DirectChannel)this.channel;
		directChannel.subscribe(this.ticketMessageHandler);
	}

	@After
	public void tearDown() throws Exception {
		DirectChannel directChannel=(DirectChannel)this.channel;
		directChannel.unsubscribe(this.ticketMessageHandler);
	}

	@Test
	public void test() {
		this.generateTickets();
		this.processTickets();
	}

	@Override
	protected void processTickets() {

	}
	

}
