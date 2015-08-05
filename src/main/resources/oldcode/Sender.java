package com.netbuilder.sender;

import java.util.Map;

import org.springframework.jms.core.JmsTemplate;

public class Sender {

	
private final JmsTemplate jmsTemplate;
	
	public Sender(final JmsTemplate jmsTemplate){
		this.jmsTemplate = jmsTemplate;
	}
	
	public void send(final Map map){
		jmsTemplate.convertAndSend(map);
	}
}
