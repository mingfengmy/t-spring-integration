package com.mfschool.spring.si.channels.directchannel;

import org.springframework.integration.Message;
import org.springframework.integration.MessageRejectedException;
import org.springframework.integration.MessagingException;
import org.springframework.integration.core.MessageHandler;
import org.springframework.stereotype.Component;

import com.mfschool.spring.si.channels.core.Ticket;

@Component
public class TicketMessageHandler implements MessageHandler {

  @Override
  public void handleMessage(Message<?> message)
      throws MessagingException {
    Object payload = message.getPayload();

    if (payload instanceof Ticket) {
      handleTicket((Ticket) payload);
    } else {
      throw new MessageRejectedException(message, "Unknown data type has been received.");
    }
  }

  void handleTicket(Ticket ticket) {
    System.out.println("Received ticket - " + ticket.toString());
  }
}
