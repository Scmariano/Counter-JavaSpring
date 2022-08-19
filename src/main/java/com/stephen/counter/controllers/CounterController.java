package com.stephen.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_server")
public class CounterController {
	@RequestMapping("")
	public String index(HttpSession session) {  
		if (session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}else {
			Integer count = (Integer) session.getAttribute("count") + 1;
			session.setAttribute("count", count);
		}
		return "index.jsp";
	}
	
	
	
	@RequestMapping("/counter")
	public String showCount(HttpSession session, Model model) {
		Integer count;
		if(session.getAttribute("count") == null) {
			count = 0;
		}else {
			count = (Integer) session.getAttribute("count");
		}
		model.addAttribute("count", count);
	return	"showCount.jsp";
	}
	
}
