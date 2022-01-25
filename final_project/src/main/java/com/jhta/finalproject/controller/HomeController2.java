package com.jhta.finalproject.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController2 {
	@Autowired ServletContext sc;
	
	@RequestMapping(value = "/home/home", method = RequestMethod.GET)
	public String home(Model model) {
		sc.setAttribute("cp",sc.getContextPath());
		return "home/home";
	}
	
}