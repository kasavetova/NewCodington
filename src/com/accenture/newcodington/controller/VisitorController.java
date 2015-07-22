package com.accenture.newcodington.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.accenture.newcodington.entity.People;
import com.accenture.newcodington.entity.Visitor;
import com.accenture.newcodington.service.VisitorFacade;
import com.accenture.newcodington.service.VisitorServiceImpl;

@Controller
public class VisitorController {

	@RequestMapping("/register.htm")
	public ModelAndView registerVisitor(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		String username = request.getParameter("username");
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
		VisitorFacade service = new VisitorServiceImpl();
		Boolean isRegistered = (Boolean) service.createVisitor(visitor);

		String errorMessage = "";
		boolean success = false;
		if (isRegistered!=null) {
			success = true;
			mv.addObject("DATA", "Successful registration!");
		}
		mv.addObject("STATUS", success);
		mv.addObject("ERRORMESSAGE", errorMessage);
		mv.setViewName("login.jsp");

		return mv;
	}

	@RequestMapping("/login.htm")
	public ModelAndView loginVisitor(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();
		session.setAttribute("USERNAME", username);
		Visitor visitor = new Visitor();
		visitor.setUserName(username);
		visitor.setPassword(password);
		VisitorFacade service = new VisitorServiceImpl();
		Visitor returnedVisitor = (Visitor) service.searchVisitor(username, password);
		String errorMessage = "";
		boolean success = false;
		if (returnedVisitor!=null) {
			success = true;
			mv.addObject("DATA", returnedVisitor);
		}
		mv.addObject("STATUS", visitor);
		mv.addObject("ERRORMESSAGE", errorMessage);
		mv.setViewName("festival-portal.jsp");
		return mv;
	}
	@RequestMapping("/updateDetails.htm")
	public ModelAndView updateVisitor(HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();

		String username = request.getParameter("username");
		VisitorFacade service = new VisitorServiceImpl();
		Visitor updatedVisitor = (Visitor) service.updateVisitorDetails(username);
		boolean success = false;
		String errorMessage = "";
		if (updatedVisitor!=null) {
			success = true;
			mv.addObject("DATA", updatedVisitor);
		}
		mv.addObject("STATUS", success);
		mv.addObject("ERRORMESSAGE", errorMessage);
		mv.setViewName("festival-portal.jsp");
		return mv;
	}
}
