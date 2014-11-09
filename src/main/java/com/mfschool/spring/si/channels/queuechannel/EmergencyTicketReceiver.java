package com.mfschool.spring.si.channels.queuechannel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.core.MessageSelector;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.mfschool.spring.si.channels.core.Ticket;

@Component
public class EmergencyTicketReceiver extends TicketReceiver {

  private MessageSelector emergencyTicketSelector;

  @Autowired
  public void setEmergencyTicketSelector(MessageSelector emergencyTicketSelector) {
    this.emergencyTicketSelector = emergencyTicketSelector;
  }

  @Override
  public void handleTicketMessage() {
    Message<?> ticketMessage = null;

    while (true) {
      List<Message<?>> emergencyTicketMessages = channel.purge(emergencyTicketSelector);
      handleEmergencyTickets(emergencyTicketMessages);

      ticketMessage = channel.receive(RECEIVE_TIMEOUT);
      if (ticketMessage != null) {
        handleTicket((Ticket) ticketMessage.getPayload());
      } else {
        try {
          /** Handle some other tasks **/
          Thread.sleep(1000);
        } catch (InterruptedException ex) {
          ex.printStackTrace();
        }
      }
     }
  }

  void handleEmergencyTickets(List<Message<?>> highPriorityTicketMessages) {
    Assert.notNull(highPriorityTicketMessages);
    for (Message<?> ticketMessage : highPriorityTicketMessages) {
      handleTicket((Ticket) ticketMessage.getPayload());
     }
  }
}
