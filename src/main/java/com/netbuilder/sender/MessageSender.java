package com.netbuilder.sender;

import org.springframework.jms.core.JmsTemplate;

public class MessageSender {

	private JmsTemplate jmsTemplate;
	
	public void setJmsTemplate(JmsTemplate jmsTemplate){
		this.jmsTemplate = jmsTemplate;
	}
	
	public void send(String destination, final Object object){
		jmsTemplate.convertAndSend(destination, object);
	}
}
