package com.mfschool.spring.si.channels.queuechannel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.mfschool.spring.si.channels.core.Ticket;

@Component
public class ProblemReporter {

  private MessageChannel channel;

  @Value("#{ticketChannel}")
  public void setChannel(MessageChannel channel) {
    this.channel = channel;
  }

  public void openTicket(Ticket ticket) {

    channel.send(MessageBuilder.withPayload( ticket).build() );
	System.out.println("Ticket Sent - " + ticket.toString());
  }
}
