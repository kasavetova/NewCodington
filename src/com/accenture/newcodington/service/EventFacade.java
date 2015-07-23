package com.accenture.newcodington.service;

import java.util.ArrayList;

import com.accenture.newcodington.entity.Event;
import com.accenture.newcodington.entity.Visitor;

/**
 * EVENTFACADE CLASS for defining abstract for EVENTIMPLEMENTATION
 */
public interface EventFacade {
	
	public ArrayList<Event> getAllMuseumEvents();
	public ArrayList<Event> getAllZooEvents();
	public ArrayList<Event> getAllParkEvents();
	public ArrayList<Event> getAllTheaterEvents();
	public ArrayList<Event> getAllStadiumEvents();
	public boolean checkEventsForVisitor(Visitor visitor, int eventid);
}
