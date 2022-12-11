<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Film in Database</title>
</head>
<body>
	Update ${updateFilm.filmId} in Database
	<form action="updateForm.do" method="POST">
		<input type="hidden" value="${updateFilm.filmId }" name="id">
		Title: <input type="text" name="title" value="${updateFilm.title }"> <br> 
		Description:
		<input type="text" name="description" value="${updateFilm.description }"> <br> 
		Release Year:
		<input type="text" name="releaseYear" value="${updateFilm.releaseYear }"> <br> 
		<label for="language">Language ID:</label> 
				<select name="language">
				  <option value="1">1: English</option>
				  <option value="2">2: Italian</option>
				  <option value="3">3: Japanese</option>
				  <option value="4">4: Mandarin</option>
				  <option value="5">5: French</option>
				  <option value="6">6: German</option>
				</select><br>
			
		Rental Duration: <input type="text" name="rentDur" value="${updateFilm.rentalDuration }"> <br> 
		Rental Rate: <input type="text" name="rentRate" value="${updateFilm.rate }"> <br> 
		Length: <input
			type="text" name="length" value="${updateFilm.length }"> <br>			
		Replacement Cost: <input
			type="text" name="replaceCost" value="${updateFilm.replacementCost }"> <br> 
		<label for="rating">Rating:</label> 
				<select name="rating">
				  <option value="G" selected>G</option>
				  <option value="PG">PG</option>
				  <option value="PG13">PG-13</option>
				  <option value="R">R</option>
				  <option value="NC17">NC-17</option>
				</select><br>
		Special Features: <input type="checkbox" name="specFeatures"
			value="Trailers">Trailers <input type="checkbox"
			name="specFeatures" value="Commentaries">Commentaries <input
			type="checkbox" name="specFeatures" value="Deleted Scenes">Deleted
		Scenes <input type="checkbox" name="specFeatures"
			value="Behind the Scenes">Behind the Scenes
			<input type="hidden" name="specFeatures" value="placeholder" checked> <br>
			
			<input type="submit" value="Submit Update">
	</form>
</body>
</html>