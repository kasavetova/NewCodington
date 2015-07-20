package com.accenture.newcodington.entity;

import java.util.Date;
/**
 * POJO class to represent EVENT domain class
 */
public class Event {

	// Encapsulated data fields for EVENT class 
	private String eventName;
	private String description;
	private int duration;
	private String eventType;
	private String schedule;
	private int ticketPrice;
	
	// GETTER and SETTER methods for EVENT class
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public int getTicketPrice() {
		return ticketPrice;
	}
	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	
}
