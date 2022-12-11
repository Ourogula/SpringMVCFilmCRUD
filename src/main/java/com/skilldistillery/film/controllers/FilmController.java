package com.skilldistillery.film.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;

@Controller
public class FilmController {
	
	@Autowired
	FilmDAO db;
	
	@RequestMapping(path="home.do") 
	public String homePage (){
		return "WEB-INF/views/home.jsp";
	}
	
	@ RequestMapping(path="delete.do")
	public String deleteWebpage () {
		return "WEB-INF/views/delete.jsp";
	}
	
	@ RequestMapping(path="insert.do")
	public String insertForm () {
		return "WEB-INF/views/insert.jsp";
	}
	
	@ RequestMapping(path="update.do")
	public String updateForm () {
		return "WEB-INF/views/update.jsp";
	}
	
	@ RequestMapping(path="read.do")
	public String readForm () {
		return "WEB-INF/views/read.jsp";
	}
	
	
	//Delete a Film from the Database
	@RequestMapping(path="deleteform.do", method = RequestMethod.POST)
	public ModelAndView deleteForm () {
		ModelAndView mv = new ModelAndView();
		
		
		//Redirect to the GET confirmation page instead of resubmitting the form here
		mv.setViewName("WEB-INF/views/home.jsp");
		System.out.println("Delete node was called successfully");
		return mv;
	}
	
	//Delete Form redirect to GET in order to prevent duplicate form submisisons
	@RequestMapping(path="deleteConfirmation.do", method = RequestMethod.GET)
	public String deleteConfirmation () {
		
		return "WEB-INF/views/home.jsp";
	}

}
