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

	@RequestMapping(path = "home.do")
	public String homePage() {
		return "WEB-INF/views/home.jsp";
	}

	@RequestMapping(path = "keyword.do")
	public String keywordPage() {
		return "WEB-INF/views/keyword.jsp";
	}

	@RequestMapping(path = "read.do")
	public String readPage() {
		return "WEB-INF/views/read.jsp";
	}

	@RequestMapping(path = "insert.do")
	public String insertForm() {
		return "WEB-INF/views/insert.jsp";
	}

	@RequestMapping(path = "update.do", method = RequestMethod.POST)
	public ModelAndView updateFormId(String filmId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		Film updateFilm = null;
		int id = Integer.parseInt(filmId);

		try {
			updateFilm = db.findFilmById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		redir.addFlashAttribute("updateFilm", updateFilm);

		mv.setViewName("redirect:updateFormCreation.do");
		return mv;
	}

	@RequestMapping(path = "update.do", params = "keywordQuery", method = RequestMethod.POST)
	public ModelAndView updateFormKeyword(String keywordQuery, RedirectAttributes redir) {
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

	@RequestMapping(path = "updateFormCreation.do", method = RequestMethod.GET)
	public ModelAndView updateFormCreation(Film updateFilm) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("film", updateFilm);
		mv.setViewName("WEB-INF/views/update.jsp");
		return mv;
	}

	@RequestMapping(path = "updateForm.do", method = RequestMethod.POST)
	public ModelAndView updateFormReceived(String id, String title, String description, String releaseYear,
			String language, String rentDur, String rentRate, String length, String replaceCost, String rating,
			String specFeatures, RedirectAttributes redir) {
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
		String features;
		if (specFeatures.length() > 12) {
			features = (String) specFeatures.subSequence(0, specFeatures.length() - 12);
		} else {
			features = null;
		}
		List<Actor> actors = null;
		try {
			actors = db.findActorsByFilmId(filmId);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(id);

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
		try {
			redir.addFlashAttribute("updateFilm", db.findFilmById(filmId));
		} catch (SQLException o) {
			o.printStackTrace();
		}
		mv.setViewName("redirect:updateFormResult.do");
		return mv;
	}

	@RequestMapping(path = "updateFormResult.do", method = RequestMethod.GET)
	public ModelAndView updateFormResult(Film updateFilm) {
		ModelAndView mv = new ModelAndView();

		try {
			String language = ((FilmDAOImpl) db).findLanguageByID(updateFilm.getFilmId());
			mv.addObject("language", language);
			String categories = ((FilmDAOImpl) db).findCategoriesById(updateFilm.getFilmId());
			mv.addObject("categories", categories);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mv.setViewName("WEB-INF/views/updateResult.jsp");
		return mv;
	}

	@RequestMapping(path = "results.do", method = RequestMethod.POST)
	public ModelAndView queryResult(String identifier) {
		ModelAndView mv = new ModelAndView();
		Film film = null;

		try {
			int id = Integer.parseInt(identifier);
			film = db.findFilmById(id);
		} catch (Exception e) {
			try {
				List<Film> films = db.findFilmsByQuery(identifier);
				if (films.size() == 1 && films.get(0) != null) {
					film = films.get(0);
					mv.addObject("multiple", false);
				} else if (films.size() > 0){
					mv.addObject("multiple", true);
				} else {
					mv.addObject("multiple", false);
				}
			} catch (Exception o) {
				o.printStackTrace();
			}
		}
		if (film != null) {
			try {
				String language = ((FilmDAOImpl) db).findLanguageByID(film.getFilmId());
				mv.addObject("language", language);
				String categories = ((FilmDAOImpl) db).findCategoriesById(film.getFilmId());
				mv.addObject("categories", categories);
				mv.addObject("film", film);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			mv.addObject("film", null);
		}

		mv.setViewName("WEB-INF/views/results.jsp");
		return mv;
	}

	// Delete a Film from the Database
	@RequestMapping(path = "delete.do", method = RequestMethod.POST)
	public ModelAndView deleteForm(String filmId, RedirectAttributes redir) {
		ModelAndView mv = new ModelAndView();
		boolean success = false;
		int id = Integer.parseInt(filmId);
		Film deletedFilm = null;
		String language = "";
		String categories = "";
		try {
			deletedFilm = db.findFilmById(id);
			success = db.deleteFilm(deletedFilm);
			language = ((FilmDAOImpl) db).findLanguageByID(id);
			categories = ((FilmDAOImpl) db).findCategoriesById(id);
			System.out.println("Delete node was called successfully");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Delete node failed");
		}

		if (success) {
			redir.addFlashAttribute("deletedFilm", deletedFilm);
			redir.addFlashAttribute("language", language);
			redir.addFlashAttribute("categories", categories);
		}
		// Redirect to the GET confirmation page instead of resubmitting the form here
		mv.setViewName("redirect:deleteConfirmation.do");
		return mv;
	}

	// Delete Form redirect to GET in order to prevent duplicate form submisisons
	@RequestMapping(path = "deleteConfirmation.do", method = RequestMethod.GET)
	public ModelAndView deleteConfirmation() {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("WEB-INF/views/deleteResult.jsp");
		return mv;
	}

}
