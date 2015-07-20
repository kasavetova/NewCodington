package com.accenture.newcodington.entity;
/**
 * POJO class for PARK domain model
 */
public class Park extends Place {

	// Encapsulated data field in PARK class
	private String parkName;
	private String parkCategory;
	

	public String getParkCategory() {
		return parkCategory;
	}

	public void setParkCategory(String parkCategory) {
		this.parkCategory = parkCategory;
	}

	public String getParkName() {
		return parkName;
	}

	public void setParkName(String parkName) {
		this.parkName = parkName;
	}

	@Override
	public void showEvents() {
		// TODO Auto-generated method stub
		
	}
	
}
