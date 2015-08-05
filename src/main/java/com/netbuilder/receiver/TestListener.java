package com.netbuilder.receiver;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.listener.SessionAwareMessageListener;

@SuppressWarnings("rawtypes")
public class TestListener implements SessionAwareMessageListener {

	@Override
	public void onMessage(Message message, Session session) {
		
		System.out.println("MESSAGE!");
		
		if(message instanceof TextMessage){
			try{
				System.out.println(((TextMessage) message).getText());
			}
			catch(JMSException e){
				e.printStackTrace();
			}
		}
		else{
			System.out.println("lolno");
		}
	}

}
