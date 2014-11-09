package com.mfschool.spring.si.channel.prioritychannel;


import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mfschool.spring.si.channel.queuechannel.TicketReceiverTest;

@ContextConfiguration({"priority-channel.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class PriorityQueueTest extends TicketReceiverTest{

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

}
