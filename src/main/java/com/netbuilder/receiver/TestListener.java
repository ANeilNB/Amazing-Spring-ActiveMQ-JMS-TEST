package com.netbuilder.receiver;

import java.util.LinkedList;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.listener.SessionAwareMessageListener;

import com.netbuilder.nodemap.GladosNode;

@SuppressWarnings("rawtypes")
public class TestListener implements MessageListener {

	@Override
	public void onMessage(Message message) {
		
		System.out.println("MESSAGE!");
		
		if(message instanceof TextMessage){
			try{
				System.out.println(((TextMessage) message).getText());
			}
			catch(JMSException e){
				e.printStackTrace();
			}
		}
		else if(message instanceof ObjectMessage){
			Object payload;
			try {
				payload = ((ObjectMessage) message).getObject();
				
				if(payload instanceof LinkedList<?>){
					LinkedList<GladosNode> path = (LinkedList<GladosNode>) payload;
					System.out.println(path.getFirst().toString());
				}
				
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
		else{
			System.out.println("lolno");
		}
	}

}
