package com.mfschool.spring.si.channels.prioritychannel;

import java.util.Comparator;

import org.springframework.integration.Message;
import org.springframework.stereotype.Component;

import com.mfschool.spring.si.channels.core.Ticket;


@Component
public class TicketMessagePriorityComparator
    implements Comparator<Message<Ticket>> {

  @Override
  public int compare(Message<Ticket> message1, Message<Ticket> message2) {
    Integer priority1 = message1.getPayload().getPriority().ordinal();
    Integer priority2 = message2.getPayload().getPriority().ordinal();

    priority1 = priority1 != null ? priority1 : 0;
    priority2 = priority2 != null ? priority2 : 0;

    return priority2.compareTo(priority1);
  }
}
