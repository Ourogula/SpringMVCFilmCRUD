package com.skilldistillery.film.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.data.FilmDAOImpl;
import com.skilldistillery.film.entities.Film;

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
	@RequestMapping(path="deleteForm.do", method = RequestMethod.GET)
	public ModelAndView deleteForm () {
		ModelAndView mv = new ModelAndView();
		boolean success = false;
		int filmId = 1005;
		Film deletedFilm = null;
		String language = "";
		try {
			deletedFilm = db.findFilmById(filmId);
			success = db.deleteFilm(deletedFilm);
			language = ((FilmDAOImpl)db).findLanguageByID(filmId);
			System.out.println("Delete node was called successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (success) {
			mv.addObject("deletedFilm", deletedFilm);
			mv.addObject("language", language);
		}
		//Redirect to the GET confirmation page instead of resubmitting the form here
		mv.setViewName("WEB-INF/views/deleteResult.jsp");
		return mv;
	}
	
	//Delete Form redirect to GET in order to prevent duplicate form submisisons
	@RequestMapping(path="deleteConfirmation.do", method = RequestMethod.GET)
	public String deleteConfirmation () {
		
		return "WEB-INF/views/home.jsp";
	}

}
