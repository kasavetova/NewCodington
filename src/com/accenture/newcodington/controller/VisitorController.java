package com.accenture.newcodington.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VisitorController {
	
	@RequestMapping("/register.htm")
	public ModelAndView registerVisitor(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		String username = request.getParameter("username");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		String emailAddress = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		String phoneNumber = request.getParameter("phoneNumber");		
		
		boolean success = false;
		String errorMessage = "";
		
		mv.addObject("STATUS", success);
		mv.addObject("ERRORMESSAGE", errorMessage);
		mv.setViewName("login.jsp");
		
		return mv;
	}
	
	@RequestMapping("/login.htm")
	public ModelAndView loginVisitor(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		
		HttpSession session=request.getSession();
		session.setAttribute("USERNAME", username);
				
		boolean success = false;
		String errorMessage = "";
		
		mv.addObject("STATUS", success);
		mv.addObject("ERRORMESSAGE", errorMessage);
		mv.setViewName("festival-portal.jsp");		
		return mv;
	}

}
