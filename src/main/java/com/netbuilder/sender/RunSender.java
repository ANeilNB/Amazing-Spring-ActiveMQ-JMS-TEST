package com.netbuilder.sender;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.netbuilder.nodemap.Test;


public class RunSender {

	
	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("sendercontext.xml");
		MessageSender messageSender = (MessageSender) context.getBean("messageSender");
		
		Test testMaker = new Test();
		Serializable message = (LinkedList)testMaker.getPath();
		
		messageSender.send("test-queue", message);

	}
}
