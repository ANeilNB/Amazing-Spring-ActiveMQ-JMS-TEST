package com.netbuilder.sender;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

import com.netbuilder.nodemap.GladosNode;
import com.netbuilder.nodemap.Test;

public class RunEESender {

	public static void main(String[] args) {
		
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
		
		Connection connection;
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			Destination destination = session.createQueue("test-queue2");
			
			MessageProducer producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);

			//TextMessage message = session.createTextMessage("Hello!");
			Test test = new Test();
			LinkedList<GladosNode> linked = (LinkedList<GladosNode>)test.getPath();
			ArrayList<GladosNode> payload = new ArrayList<GladosNode>();
			payload.addAll(linked);
			ObjectMessage message = session.createObjectMessage(payload);
			
			producer.send(message);
			
			session.close();
			connection.close();
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
		
	}

}
