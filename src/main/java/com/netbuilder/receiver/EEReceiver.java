package com.netbuilder.receiver;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;

public class EEReceiver {

	void startReceiving(){
		
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		
		Connection connection;
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Destination destination = session.createQueue("test-queue");
			
			MessageConsumer consumer = session.createConsumer(destination);
			consumer.setMessageListener(new TestListener());
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}
}
