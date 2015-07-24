package com.accenture.newcodington.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.newcodington.entity.Event;
import com.accenture.newcodington.service.EventFacade;
import com.accenture.newcodington.service.EventServiceImpl;

@Controller
public class EventController {
	
	@RequestMapping("/events.htm")
	public ModelAndView getAvailableEvents(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		List<Event> eventList=new ArrayList<Event>();
		EventFacade serviceImpl=new EventServiceImpl();
		eventList=serviceImpl.getAllEvents();			
		
		ModelAndView mv=new ModelAndView();
		mv.addObject("allEvents",eventList);
		mv.setViewName("/festival-portal.jsp");
		return mv;
	}

}
