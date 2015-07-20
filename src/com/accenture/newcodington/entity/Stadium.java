package com.accenture.newcodington.entity;


/**
 * class STADIUM takes properties BUILDING
 */
public class Stadium extends Building {

	// Encapsulated data field for Stadium
	private String stadiumName;

	public String getStadiumName() {
		return stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}	
	
	@Override
	public void showEvents() {
		// TODO Auto-generated method stub
		
	}
	
}
