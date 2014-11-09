package com.mfschool.spring.si.channel.queuechannel;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.MessageChannel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mfschool.spring.si.channels.core.Ticket;
import com.mfschool.spring.si.channels.core.TicketGenerator;
import com.mfschool.spring.si.channels.queuechannel.ProblemReporter;
import com.mfschool.spring.si.channels.queuechannel.TicketReceiver;

@ContextConfiguration({"queue-channel.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TicketReceiverTest {
	
	protected MessageChannel channel;
	
    @Autowired
    protected ProblemReporter problemReporter;
    
    @Autowired
    protected TicketGenerator ticketGenerator;
    @Autowired
    private TicketReceiver ticketReceiver;
    
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Value("#{ticketChannel}")
	public void setChannel(MessageChannel channel) {
		this.channel = channel;
	}

	@Test
	public void test() {
		this.generateTickets();
		this.processTickets();
		
	}	
	protected void generateTickets(){
        List<Ticket> tickets = ticketGenerator.createTickets();
        for (Ticket ticket : tickets) {
            problemReporter.openTicket(ticket);
        }
	}
	protected  void processTickets(){
        Thread consumerThread = new Thread(this.getTicketReceiver());
        consumerThread.start();
	};
	protected TicketReceiver getTicketReceiver(){
		return this.ticketReceiver;
	}

}
