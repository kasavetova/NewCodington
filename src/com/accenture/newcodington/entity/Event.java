package com.accenture.newcodington.entity;

import java.util.Date;

public class Event {

	private String eventName;
	private String description;
	private int duration;
	private String eventType;
	private String schedule;
	private int ticketPrice;
	private String name;
	private int eventId;
	private String place;
	private int signupId;
	
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
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int geteventId() {
		return eventId;
	}
	public void seteventId(int eventId) {
		this.eventId = eventId;
	}
	public String getPlace(){
		return place;
	}
	public void setPlace(String place){
		this.place = place;
	}
	public int getsignupId() {
		return signupId;
	}
	public void setsignupId(int signupId) {
		this.signupId = signupId;
	}
}
