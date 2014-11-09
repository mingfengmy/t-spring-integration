package com.mfschool.spring.si.channel.queuechannel;


import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mfschool.spring.si.channels.core.Ticket;
import com.mfschool.spring.si.channels.core.TicketGenerator;
import com.mfschool.spring.si.channels.queuechannel.EmergencyTicketReceiver;
import com.mfschool.spring.si.channels.queuechannel.ProblemReporter;
import com.mfschool.spring.si.channels.queuechannel.TicketReceiver;

@ContextConfiguration({"queue-channel.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EmergencyReceiverTest extends TicketReceiverTest{

    @Autowired
    private EmergencyTicketReceiver ticketReceiver;

	@Override
	protected TicketReceiver getTicketReceiver() {
		return this.ticketReceiver;
	}



}
