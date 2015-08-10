package com.netbuilder.receiver;

import java.util.LinkedList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.TextMessage;

import com.netbuilder.nodemap.*;

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
				
				if(payload instanceof List<?>){
					List<GladosNode> path = (List<GladosNode>) payload;
					for(GladosNode gN: path){
						System.out.println(gN.toString());
					}
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
