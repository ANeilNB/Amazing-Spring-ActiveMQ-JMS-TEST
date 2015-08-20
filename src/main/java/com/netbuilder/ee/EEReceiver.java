package com.netbuilder.ee;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.netbuilder.receiver.TestListener;

public class EEReceiver {

	void startReceiving(){
		
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		
		Connection connection;
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Destination destination = session.createQueue("test-queue2");
			
			MessageConsumer consumer = session.createConsumer(destination);
			consumer.setMessageListener(new TestListener());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
}
