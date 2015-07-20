package com.accenture.newcodington.entity;
/**
 * Place POJO class for domain model 
 */
public abstract class Place {

	// Encapsulated data fields of PLACE object
	private Event events;
	private String placeName;
	private int capacity;
	private String placeDescription;
	private String workingHours;
	
	// GETTER and SETTER methods for Place class
	
	public Event getEvents() {
		return events;
	}
	public void setEvents(Event events) {
		this.events = events;
	}
	
	
	public String getPlaceDescription() {
		return placeDescription;
	}
	public void setPlaceDescription(String placeDescription) {
		this.placeDescription = placeDescription;
	}
	
	
	// Abstract method to be overrided in Subclasses like Stadium, Zoo etc.
	public abstract void showEvents();
	
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getWorkingHours() {
		return workingHours;
	}
	public void setWorkingHours(String workingHours) {
		this.workingHours = workingHours;
	}
		
}
