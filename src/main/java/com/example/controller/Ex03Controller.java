package com.example.controller;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Ex03Controller {
	
	@Autowired
	private ServletContext application;
	
	@RequestMapping("")
	public String index() {
		return "exam03";
	}
	
	@RequestMapping("/buy-item")
	public String buyItem(Integer item1,Integer item2,Integer item3) {
		application.setAttribute("taxex", item1+item2+item3);
		application.setAttribute("taxin", (item1+item2+item3)*110/100);
		System.out.println(item1);
		return"exam03-result";
	}
	
	
	

}
