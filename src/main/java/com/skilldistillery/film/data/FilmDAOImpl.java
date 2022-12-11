package com.skilldistillery.film.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.skilldistillery.film.entities.Actor;
import com.skilldistillery.film.entities.Film;

@Component
public class FilmDAOImpl implements FilmDAO {


	// Connect to the local sdvid database
	private static final String URL = "jdbc:mysql://localhost:3306/sdvid?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=US/Mountain";
	private static String user = "student";
	private static String pass = "student";
	
	// Add the driver to the class path
	public FilmDAOImpl() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}

	// Return a Film given a Film's ID
	@Override
	public Film findFilmById(int filmId) throws SQLException {
		Film film = null;

		Connection conn = DriverManager.getConnection(URL, user, pass);

		String sql = "SELECT * FROM film WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			filmId = rs.getInt("id");
			String title = rs.getString("title");
			String description = rs.getString("description");
			short releaseYear = rs.getShort("release_year");
			int languageId = rs.getInt("language_id");
			int rentalDuration = rs.getInt("rental_duration");
			double rate = rs.getDouble("rental_rate");
			int length = rs.getInt("length");
			double replacementCost = rs.getDouble("replacement_cost");
			String rating = rs.getString("rating");
			String features = rs.getString("special_features");
			film = new Film(filmId, title, description, releaseYear, languageId, rentalDuration, rate, length,
					replacementCost, rating, features, findActorsByFilmId(filmId), findCategoriesById(filmId));
		}

		rs.close();
		stmt.close();
		conn.close();
		return film;
	}

	// Returns a List of Films that match the given String query
	public List<Film> findFilmsByQuery(String filmQuery) throws SQLException {
		List<Film> films = new ArrayList<>();
		Film film = null;
		String query = "%" + filmQuery + "%";

		Connection conn = DriverManager.getConnection(URL, user, pass);

		String sql = "SELECT * FROM film WHERE title LIKE ? OR description LIKE ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, query);
		stmt.setString(2, query);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			int filmId = rs.getInt("id");
			String title = rs.getString("title");
			String description = rs.getString("description");
			short releaseYear = rs.getShort("release_year");
			int languageId = rs.getInt("language_id");
			int rentalDuration = rs.getInt("rental_duration");
			double rate = rs.getDouble("rental_rate");
			int length = rs.getInt("length");
			double replacementCost = rs.getDouble("replacement_cost");
			String rating = rs.getString("rating");
			String features = rs.getString("special_features");
			film = new Film(filmId, title, description, releaseYear, languageId, rentalDuration, rate, length,
					replacementCost, rating, features, findActorsByFilmId(filmId), findCategoriesById(filmId));
			films.add(film);
		}

		rs.close();
		stmt.close();
		conn.close();
		return films;
	}

	// Return a List of Films when given an Actor's ID, only used internally currently
	public List<Film> findFilmsByActorId(int actorId) {
		List<Film> films = new ArrayList<>();

		try {
			Connection conn = DriverManager.getConnection(URL, user, pass);
			String sql = "SELECT * FROM film JOIN film_actor ON film.id = film_actor.film_id WHERE actor_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, actorId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int filmId = rs.getInt("id");
				String title = rs.getString("title");
				String description = rs.getString("description");
				short releaseYear = rs.getShort("release_year");
				int languageId = rs.getInt("language_id");
				int rentalDuration = rs.getInt("rental_duration");
				double rate = rs.getDouble("rental_rate");
				int length = rs.getInt("length");
				double reparationCost = rs.getDouble("replacement_cost");
				String rating = rs.getString("rating");
				String features = rs.getString("special_features");
				Film film = new Film(filmId, title, description, releaseYear, languageId, rentalDuration, rate, length,
						reparationCost, rating, features, findActorsByFilmId(filmId), findCategoriesById(filmId));
				films.add(film);
			}

			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return films;
	}

	// Return an Actor when given their ID
	@Override
	public Actor findActorById(int actorId) throws SQLException {
		Actor actor = null;
		Connection conn = DriverManager.getConnection(URL, user, pass);

		String sql = "SELECT * FROM actor WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, actorId);
		ResultSet actorResult = stmt.executeQuery();
		if (actorResult.next()) {
			actor = new Actor(); // Create the object
			// Here is our mapping of query columns to our object fields:
			actor.setId(actorResult.getInt("id"));
			actor.setFirstName(actorResult.getString("first_name"));
			actor.setLastName(actorResult.getString("last_name"));
			actor.setFilms(findFilmsByActorId(actorId));
		}

		actorResult.close();
		stmt.close();
		conn.close();

		return actor;
	}

	// Return a list of all actors by a film's ID
	@Override
	public List<Actor> findActorsByFilmId(int filmId) throws SQLException {

		List<Actor> actors = new ArrayList<>();

		Connection conn = DriverManager.getConnection(URL, user, pass);

		String sql = "SELECT * FROM actor JOIN film_actor fact ON fact.actor_id = actor.id "
				+ " JOIN film ON fact.film_id = film.id WHERE film.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet actorResult = stmt.executeQuery();

		// What is the goal? Find all actors in a given film
		while (actorResult.next()) {
			Actor actor = new Actor(); // Create the object
			actor.setId(actorResult.getInt("id"));
			actor.setFirstName(actorResult.getString("first_name"));
			actor.setLastName(actorResult.getString("last_name"));
			// actor.setFilms(findFilmsByActorId(filmId));
			actors.add(actor);
		}

		actorResult.close();
		stmt.close();
		conn.close();

		return actors;
	}

	// Get Language name by Language_Id
	public String findLanguageByID(int filmId) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);

		String language = "";
		String sql = "SELECT language.name FROM language JOIN film ON language.id = film.language_id";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			language = rs.getString("language.name");
		}
		rs.close();
		stmt.close();
		conn.close();
		return language;
	}
	
	public String findCategoriesById(int filmId) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, user, pass);
		
		String categories = "";
		String sql = "SELECT category.name FROM category JOIN film_category ON category.id = film_category.category_id JOIN film ON film.id = film_category.film_id WHERE film.id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, filmId);
		ResultSet rs = stmt.executeQuery();
		
		while (rs.next()) {
			categories += rs.getString("category.name");
		}
		rs.close();
		stmt.close();
		conn.close();
		return categories;
	}
	
//	 Insert a new Film
	public Film addFilm(Film film) {
		  Connection conn = null;
		  try {
		    conn = DriverManager.getConnection(URL, user, pass);
		    conn.setAutoCommit(false); // START TRANSACTION
		    String sql = "INSERT INTO film (title, description, release_year, language_id, rental_duration, rental_rate, length, replacement_cost, rating, special_features) "
		                     + " VALUES (?,?,?,?,?,?,?,?,?,?)";
		    PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		    
		    stmt.setString(1, film.getTitle());
		    stmt.setString(2, film.getDescription());
		    stmt.setInt(3, film.getReleaseYear());
		    stmt.setInt(4, film.getLanguageId());
		    stmt.setInt(5, film.getRentalDuration());
		    stmt.setDouble(6, film.getRate());
		    stmt.setInt(7, film.getLength());
		    stmt.setDouble(8, film.getReplacementCost());
		    stmt.setString(9, film.getRating());
		    if (film.getCategories() != null) {
		    stmt.setString(10, film.getCategories());
		    } else {
		    	stmt.setString(10, null);
		    }
		    
		    int updateCount = stmt.executeUpdate();
		    if (updateCount == 1) {
		      ResultSet keys = stmt.getGeneratedKeys();
		      if (keys.next()) {
		        int newFilmId = keys.getInt(1);
		        film.setFilmId(newFilmId);
		        if (film.getActors() != null && film.getActors().size() > 0) {
		          sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
		          stmt = conn.prepareStatement(sql);
		          for (Actor actor : film.getActors()) {
		            stmt.setInt(1, newFilmId);
		            stmt.setInt(2, actor.getId());
		            updateCount = stmt.executeUpdate();
		          }
		        }
		      }
		    } else {
		      film = null;
		    }
		    conn.commit(); // COMMIT TRANSACTION
		    conn.close();
		  } catch (SQLException sqle) {
		    sqle.printStackTrace();
		    if (conn != null) {
		      try { conn.rollback(); }
		      catch (SQLException sqle2) {
		        System.err.println("Error trying to rollback");
		      }
		    }
		    throw new RuntimeException("Error inserting film " + film);
		  }
		  return film;
		}
	
	// Update a Film
	public boolean updateFilm(Film film) {
		  Connection conn = null;
		  int updateCount = 0;
		  boolean success = false;
		  try {
		    conn = DriverManager.getConnection(URL, user, pass);
		    conn.setAutoCommit(false); // START TRANSACTION
		    String sql = "UPDATE film SET title=?, description=?, release_year=?, language_id=?, rental_duration=?, rental_rate=?, length=?, replacement_cost=?, rating=?, special_features=? "
		               + " WHERE id=?";
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setString(1, film.getTitle());
		    stmt.setString(2, film.getDescription());
		    stmt.setShort(3, film.getReleaseYear());
		    stmt.setInt(4, film.getLanguageId());
		    stmt.setInt(5, film.getRentalDuration());
		    stmt.setDouble(6, film.getRate());
		    stmt.setInt(7, film.getLength());
		    stmt.setDouble(8, film.getReplacementCost());
		    stmt.setString(9, film.getRating());
		    stmt.setString(10, film.getFeatures());
//		    if (findFilmById(film.getFilmId()).getCategories() != null) {
//		    	stmt.setString(12, findFilmById(film.getFilmId()).getCategories());
//		    } else {
//		    stmt.setString(12, film.getCategories());
//		    }
		    stmt.setInt(11, film.getFilmId());
		    updateCount = stmt.executeUpdate();
		    if (updateCount == 1) {
		      // Replace actor's film list
		      sql = "DELETE FROM film_actor WHERE film_id = ?";
		      stmt = conn.prepareStatement(sql);
		      stmt.setInt(1, film.getFilmId());
		      updateCount = stmt.executeUpdate();
		      sql = "INSERT INTO film_actor (film_id, actor_id) VALUES (?,?)";
		      stmt = conn.prepareStatement(sql);
		      for (Actor actor : film.getActors()) {
		        stmt.setInt(1, film.getFilmId());
		        stmt.setInt(2, actor.getId());
		        updateCount = stmt.executeUpdate();
		      }

		      conn.commit();           // COMMIT TRANSACTION
			  conn.close();
		    }
		  } catch (SQLException sqle) {
		    sqle.printStackTrace();
		    if (conn != null) {
		      try { conn.rollback(); } // ROLLBACK TRANSACTION ON ERROR
		      catch (SQLException sqle2) {
		        System.err.println("Error trying to rollback");
		      }
		    }
		    return success;
		  }
		  if (updateCount != 0) {
			  success = true;
			  System.out.println(updateCount + " rows changed.");
		  }
		  return success;
		}
	
	// Delete a film
	public boolean deleteFilm(Film film) {
		if (film == null) {
			return false;
		}
		  Connection conn = null;
		  try {
		    conn = DriverManager.getConnection(URL, user, pass);
		    conn.setAutoCommit(false); // START TRANSACTION
		    String sql = "DELETE FROM film_actor WHERE actor_id = ?";
		    PreparedStatement stmt = conn.prepareStatement(sql);
		    stmt.setInt(1, film.getFilmId());
		    int updateCount = stmt.executeUpdate();
		    sql = "DELETE FROM film WHERE id = ?";
		    stmt = conn.prepareStatement(sql);
		    stmt.setInt(1, film.getFilmId());
		    updateCount = stmt.executeUpdate();
		    conn.commit();             // COMMIT TRANSACTION
			conn.close();
		  }
		  catch (SQLException sqle) {
		    sqle.printStackTrace();
		    if (conn != null) {
		      try { conn.rollback(); }
		      catch (SQLException sqle2) {
		        System.err.println("Error trying to rollback");
		      }
		    }
		    return false;
		  }
		  return true;
		}
	
}