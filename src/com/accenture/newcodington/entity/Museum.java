package com.accenture.newcodington.entity;
/**
 * MUSEUM class inherits common behavior from BUILDING class
 * and has its own properties "type"
 */
public class Museum extends Building {

	private String museumName;
	private String type; 
	
	// GETTER and SETTER methods of encapsulated fields
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMuseumName() {
		return museumName;
	}
	public void setMuseumName(String museumName) {
		this.museumName = museumName;
	}

	@Override
	public void showEvents() {
		// TODO Auto-generated method stub
		
	}	
}
