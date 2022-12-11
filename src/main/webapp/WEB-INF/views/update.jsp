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
		Language: <input
			type="text" name="language" value="${updateFilm.languageId }"> <br> 
			
		Rental Duration: <input type="text" name="rentDur" value="${updateFilm.rentalDuration }"> <br> 
		Rental Rate: <input type="text" name="rentRate" value="${updateFilm.rate }"> <br> 
		Length: <input
			type="text" name="length" value="${updateFilm.length }"> <br>			
		Replacement Cost: <input
			type="text" name="replaceCost" value="${updateFilm.replacementCost }"> <br> 
		Rating: <input
			type="radio" name="rating" value="G" checked>G <input type="radio"
			name="rating" value="PG">PG <input type="radio" name="rating"
			value="PG13">PG13 <input type="radio" name="rating" value="R">R
		<input type="radio" name="rating" value="NC17">NC17 <br>
		
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