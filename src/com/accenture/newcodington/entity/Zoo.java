package com.accenture.newcodington.entity;
/**
 * Zoo class that is composed of SAFARI object
 */
public class Zoo extends Place {
	
	// Encapsulated data fields for ZOO class
	private String zooName;
	private int noOfAnimals=0;
	
	
	// GETTER and SETTER methods for ZOO Data fields
	public int getNoOfAnimals() {
		return noOfAnimals;
	}

	public void setNoOfAnimals(int noOfAnimals) {
		this.noOfAnimals = noOfAnimals;
	}

	@Override
	public void showEvents() {
		// TODO Auto-generated method stub
		
	}

	public String getZooName() {
		return zooName;
	}

	public void setZooName(String zooName) {
		this.zooName = zooName;
	}
	

}
