package com.skilldistillery.film.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.skilldistillery.film.data.FilmDAO;
import com.skilldistillery.film.data.FilmDAOImpl;
import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Controller
public class FilmController {
	
	@Autowired
	FilmDAO db;
	
	@RequestMapping(path="home.do") 
	public String homePage (){
		return "WEB-INF/views/home.jsp";
	}
	
	@RequestMapping(path="redirect.do", method = RequestMethod.POST)
	public ModelAndView redirectWebpage (String query) {
		ModelAndView mv = new ModelAndView();
		boolean isNum = false;
		List<Film> keywordQuery = new ArrayList<>();
		int queryParse = 0;
		Film film = null;
		
		try {
			queryParse = Integer.parseInt(query);
			isNum = true;
		} catch (Exception e) {
			try {
			keywordQuery = db.findFilmsByQuery(query);
			if (keywordQuery.size() == 1 && keywordQuery.get(0) != null) {
				film = keywordQuery.get(0);
			}}
			catch (Exception other) {
				other.printStackTrace();
			}
		}
		
		mv.addObject("film", film);
		mv.setViewName("WEB-INF/views/redirect.jsp");
		return mv;
	}
	
	@ RequestMapping(path="delete.do")
	public String deleteWebpage () {
		return "WEB-INF/views/delete.jsp";
	}
	
	@ RequestMapping(path="insert.do")
	public String insertForm () {
		return "WEB-INF/views/insert.jsp";
	}
	
	@ RequestMapping(path="update.do", params="idQuery", method = RequestMethod.POST)
	public ModelAndView updateFormId (String idQuery, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		Film updateFilm = null;
		int id = Integer.parseInt(idQuery);
		
		try {
		updateFilm = db.findFilmById(id);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		redir.addFlashAttribute("updateFilm", updateFilm);
		
		mv.setViewName("redirect:updateFormCreation.do");
		return mv;
		}
	
	@ RequestMapping(path="update.do", params="keywordQuery", method = RequestMethod.POST)
	public ModelAndView updateFormKeyword (String keywordQuery, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		List<Film> filmList = new ArrayList<>();
		
		try {
			filmList = db.findFilmsByQuery(keywordQuery);
			if (filmList.size() == 1 && filmList.get(0) != null) {
				redir.addFlashAttribute("updateFilm", filmList.get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		mv.setViewName("redirect:updateFormCreation.do");
		return mv;
	}
	
	@ RequestMapping(path="updateFormCreation.do", method = RequestMethod.GET)
	public ModelAndView updateFormCreation (Film updateFilm) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", updateFilm);
		mv.setViewName("WEB-INF/views/update.jsp");
		return mv;
	}
	
	@ RequestMapping(path="updateForm.do", method = RequestMethod.POST)
	public ModelAndView updateFormReceived (String id, String title, String description, String releaseYear, String language, String rentDur, String rentRate, String length, String replaceCost, String rating, String specFeatures, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		Film updateFilm = new Film();
		boolean success = false;
		
		int filmId = Integer.parseInt(id);
		short releaseYearNum = Short.parseShort(releaseYear);
		int languageIdNum = Integer.parseInt(language);
		int rentalDurationNum = Integer.parseInt(rentDur);
		double rateNum = Double.parseDouble(rentRate);
		int lengthNum = Integer.parseInt(length);
		double replacementCostNum = Double.parseDouble(replaceCost);
		String features = (String) specFeatures.subSequence(0, specFeatures.length() - 12);
		List<Actor> actors = null;
		try {
		actors = db.findActorsByFilmId(filmId);
		} catch (SQLException e){
			e.printStackTrace();
		}
		
		updateFilm.setFilmId(filmId);
		updateFilm.setTitle(title);
		updateFilm.setDescription(description);
		updateFilm.setReleaseYear(releaseYearNum);
		updateFilm.setLanguageId(languageIdNum);
		updateFilm.setRentalDuration(rentalDurationNum);
		updateFilm.setRate(rateNum);
		updateFilm.setLength(lengthNum);
		updateFilm.setReplacementCost(replacementCostNum);
		updateFilm.setRating(rating);
		updateFilm.setFeatures(features);
		updateFilm.setActors(actors);
		
		try {
			success = db.updateFilm(updateFilm);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		redir.addFlashAttribute("success", success);
		redir.addFlashAttribute("updateFilm", updateFilm);
		mv.setViewName("redirect:updateFormResult.do");
		return mv;
	}
	
	@ RequestMapping(path="updateFormResult.do", method = RequestMethod.GET)
	public ModelAndView updateFormResult (Film updateFilm) {
		ModelAndView mv = new ModelAndView();
		
		try {
			String language = ((FilmDAOImpl)db).findLanguageByID(updateFilm.getFilmId());
			mv.addObject("language", language);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		mv.setViewName("WEB-INF/views/updateResult.jsp");
		return mv;
	}
	
	@ RequestMapping(path="read.do", params="idQuery", method = RequestMethod.POST)
	public String readFormId () {
		return "WEB-INF/views/read.jsp";
	}
	
	@ RequestMapping(path="read.do", params="keywordQuery", method = RequestMethod.POST)
	public String readFormKeyword () {
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
