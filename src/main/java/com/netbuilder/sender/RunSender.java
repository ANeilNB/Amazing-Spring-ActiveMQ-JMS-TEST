package com.netbuilder.sender;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class RunSender {

	
	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("sendercontext.xml");
		MessageSender messageSender = (MessageSender) context.getBean("messageSender");
		
		String message1 = "One for the test!";
		
		messageSender.send("test-queue", message1);

	}
}
