package com.accenture.newcodington.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.newcodington.entity.Event;
import com.accenture.newcodington.entity.People;
import com.accenture.newcodington.entity.Visitor;
import com.accenture.newcodington.service.EventFacade;
import com.accenture.newcodington.service.EventServiceImpl;
import com.accenture.newcodington.service.VisitorFacade;
import com.accenture.newcodington.service.VisitorServiceImpl;

@Controller
public class VisitorController {

	private Visitor logedInVisitor;
	@RequestMapping("/register.htm")
	public ModelAndView registerVisitor(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		boolean success = false;
		String errorMessage = "";

		String username = request.getParameter("username");
		if (username == null || username.length() < 1) {
			mv.setViewName("visitorRegistration.jsp");
			success = false;
			mv.addObject("STATUS", success);
			errorMessage = "An empty username has been entered.";
			mv.addObject("ERRORMESSAGE", errorMessage);
			return mv;
		}
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String emailAddress = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String phoneNumber = request.getParameter("phoneNumber");

		Visitor visitor = new Visitor();
		visitor.setUserName(username);
		visitor.setFirstName(firstName);
		visitor.setLastName(lastName);
		visitor.setEmail(emailAddress);
		visitor.setPassword(confirmPassword);
		visitor.setPhoneNumber(phoneNumber);
		visitor.setAddress(address);
		VisitorFacade service = new VisitorServiceImpl();
		Boolean isRegistered = (Boolean) service.createVisitor(visitor);

		if (isRegistered != null) {
			success = true;
			mv.addObject("DATA", "Successful registration!");
			mv.setViewName("login.jsp");
		} else {
			mv.setViewName("visitorRegistration.jsp");
		}
		mv.addObject("STATUS", success);
		mv.addObject("ERRORMESSAGE", errorMessage);

		return mv;
	}

	@RequestMapping("/updatePage.htm")
	public ModelAndView loginToUpdatePageVisitor(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("DATA", logedInVisitor);
		mv.setViewName("updatepage.jsp");	
		return mv;
	}
	
	@RequestMapping("/cancelUpdatePage.htm")
	public ModelAndView cancelUpdatePageVisitor(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("DATA", logedInVisitor);
		mv.setViewName("festival-portal.jsp");	
		return mv;
	}
	
	@RequestMapping("/login.htm")
	public ModelAndView loginVisitor(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		String errorMessage = "";
		boolean success = false;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username == null || username.length() < 1 || password == null
				|| password.length() < 1) {
			mv.setViewName("login.jsp");
			success = false;
			mv.addObject("STATUS", success);
			errorMessage = "An empty username or password has been entered.";
			mv.addObject("ERRORMESSAGE", errorMessage);
			return mv;
		}

		HttpSession session = request.getSession();
		session.setAttribute("USERNAME", username);
		Visitor visitor = new Visitor();
		visitor.setUserName(username);
		visitor.setPassword(password);
		VisitorFacade service = new VisitorServiceImpl();
		Visitor returnedVisitor = (Visitor) service.searchVisitor(username,
				password);

		if (returnedVisitor != null && returnedVisitor.getUserName() != null
				&& returnedVisitor.getUserName().length() > 0) {
			success = true;
			logedInVisitor = returnedVisitor;
			mv.addObject("DATA", returnedVisitor);
			mv.setViewName("festival-portal.jsp");
		} else {
			mv.setViewName("login.jsp");
		}

		mv.addObject("STATUS", success);
		mv.addObject("ERRORMESSAGE", errorMessage);
		System.out.println(returnedVisitor.getFirstName() + ", "
				+ returnedVisitor.getLastName());
		return mv;
	}

	@RequestMapping("/updateDetails.htm")
	public ModelAndView updateVisitor(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		boolean success = false;
		String errorMessage = "";

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (username == null || username.length() < 1 || password == null
				|| password.length() < 1) {
			mv.setViewName("updatepage.jsp");
			success = false;
			mv.addObject("STATUS", success);
			errorMessage = "An empty username or password has been entered.";
			mv.addObject("ERRORMESSAGE", errorMessage);
			return mv;
		}

		String firstname = request.getParameter("firstName");
		String lastname = request.getParameter("lastName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phonenumber = request.getParameter("phoneNumber");

		VisitorFacade service = new VisitorServiceImpl();
		Visitor visitor = new Visitor();
		visitor.setAddress(address);
		visitor.setFirstName(firstname);
		visitor.setLastName(lastname);
		visitor.setEmail(email);
		visitor.setPhoneNumber(phonenumber);
		visitor.setUserName(username);
		Visitor updatedVisitor = service.updateVisitorDetails(visitor);
		if (updatedVisitor != null && updatedVisitor.getUserName() != null
				&& updatedVisitor.getUserName().length() > 0) {
			success = true;
			mv.addObject("DATA", updatedVisitor);
			mv.setViewName("festival-portal.jsp");
		} else {
			mv.setViewName("updatepage.jsp");
		}
		mv.addObject("STATUS", success);
		mv.addObject("ERRORMESSAGE", errorMessage);
		mv.setViewName("festival-portal.jsp");		
		System.out.println(updatedVisitor.getFirstName() + ", "
				+ updatedVisitor.getLastName());
		return mv;
	}

	@RequestMapping("/festival-portal.htm")
	public ModelAndView registerForEvent(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		String username = request.getParameter("userName");
		if (username==null||request.getParameter("eventId")==null ||username.length()<1 || request.getParameter("eventId").length()<1) {
			mv.addObject("ERRORMESSAGE", "invalid username or eventID");
			mv.setViewName("festival-portal.jsp");
			return mv;
		}
		int eventID = Integer.valueOf(request.getParameter("eventId"));
		
		Visitor visitor = new Visitor();
		visitor.setUserName(username);
						
		EventFacade eventService = new EventServiceImpl();
		boolean isRegistered =  eventService.checkEventsForVisitor(visitor, eventID);
		if (isRegistered) {
			mv.addObject("STATUS", false);
			mv.addObject("ERRORMESSAGE", "Already registered");
			return mv;
		} 
		VisitorFacade visitorService = new VisitorServiceImpl();
		isRegistered = (Boolean) visitorService.registerVisitorForEvent(visitor, eventID);
		mv.setViewName("festival-portal.jsp");
		mv.addObject("STATUS", isRegistered);
		System.out.println(isRegistered + ", ");
		return mv;
	}
}
