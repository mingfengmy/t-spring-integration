package com.mfschool.spring.si.channels.queuechannel;

import org.springframework.integration.Message;
import org.springframework.integration.core.MessageSelector;
import org.springframework.stereotype.Component;

import com.mfschool.spring.si.channels.core.Ticket;
import com.mfschool.spring.si.channels.core.Ticket.Priority;
@Component
public class EmergencyTicketSelector implements MessageSelector {

	  @Override
	  public boolean accept(Message<?> message) {
	    return ((Ticket) message.getPayload()).getPriority() != Priority.emergency;
	  }

}
