package com.accenture.newcodington.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.accenture.newcodington.entity.Event;
import com.accenture.newcodington.service.EventFacade;
import com.accenture.newcodington.service.EventServiceImpl;

/**
 * Servlet implementation class StadiumServlet
 */
public class StadiumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StadiumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		EventFacade facade=new EventServiceImpl();
		HttpSession session=request.getSession();
		ArrayList<Event> stadiumEvents=facade.getAllStadiumEvents();
		session.setAttribute("EVENTLIST", stadiumEvents);
		session.setAttribute("PLACENAME", "STADIUM");
		RequestDispatcher dispatcher=request.getRequestDispatcher("/showEvents.jsp");
		dispatcher.forward(request, response);	
	}

}
