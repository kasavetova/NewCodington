package com.accenture.newcodington.dao;

import org.apache.log4j.Logger;

@SuppressWarnings("serial")
public class Exceptions extends Exception {

	//LOGGER to handle custom exceptions
	private static Logger log = Logger.getLogger(Exceptions.class);
	
	public Exceptions(String message, Throwable object)
	{
		super(message,object);
		log.info("Exception Message is :"+message);
	}
	
}
