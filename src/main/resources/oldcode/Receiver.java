package com.netbuilder.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jms.annotation.JmsListener;

public class Receiver {

	@Autowired
	ConfigurableApplicationContext context;
	
	@JmsListener(destination = "test-dest", containerFactory = "myJmsContainerFactory")
	public void receiveMessage(String message){
		System.out.println("Message Received! -- " + message + " --");
		context.close();
	}
}
