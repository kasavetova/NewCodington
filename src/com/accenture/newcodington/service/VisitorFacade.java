package com.accenture.newcodington.service;

import java.util.ArrayList;

import com.accenture.newcodington.entity.Event;
import com.accenture.newcodington.entity.Visitor;

/**
 * EVENTFACADE CLASS for defining abstract for EVENTIMPLEMENTATION
 */
public interface VisitorFacade {
	
	public Boolean createVisitor(Visitor v);
	public Visitor searchVisitor(String username, String password);
	public Object registerVisitorForEvent(Visitor v, int eventID);
	public ArrayList<Event> showRegisteredEvents(Visitor v);
	public Visitor updateVisitorDetails(Visitor v);
}
