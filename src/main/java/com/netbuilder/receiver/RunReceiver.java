package com.netbuilder.receiver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 
 * @author Alexander Neil
 *
 */
public class RunReceiver {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		
		MessageReceiver messageReceiver = (MessageReceiver) context.getBean("messageReceiver");
		
		messageReceiver.start("test-queue");
	
		
	}

}
