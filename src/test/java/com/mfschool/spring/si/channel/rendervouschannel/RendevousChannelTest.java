package com.mfschool.spring.si.channel.rendervouschannel;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mfschool.spring.si.channel.queuechannel.TicketReceiverTest;
import com.mfschool.spring.si.channels.core.Ticket;
@ContextConfiguration({"rendezvous-channel.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class RendevousChannelTest extends TicketReceiverTest {

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	@Override
	public void test() {
		this.processTickets();
		this.generateTickets();
	}

}
