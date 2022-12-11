<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:choose>
		<c:when test="${not empty deletedFilm}">
Successfully deleted the following film from the film database:
			<ul>
				<li>ID: ${deletedFilm.getFilmId()}</li>
				<li>Title: ${deletedFilm.getTitle()}</li>
				<li>Description: ${ deletedFilm.description}</li>
				<li>Release Year: ${ deletedFilm.releaseYear}</li>
				<li>Language: ${language}</li>
				<li>Rental Duration: ${ deletedFilm.rentalDuration}</li>
				<li>Rental Rate: ${ deletedFilm.rate}</li>
				<li>Length: ${ deletedFilm.length}</li>
				<li>Replacement Cost: ${ deletedFilm.replacementCost}</li>
				<li>Rating: ${ deletedFilm.rating}</li>
				<li>Special Features: ${ deletedFilm.features}</li>
			</ul>
		</c:when>
		<c:otherwise>
Failed to delete film from database. Please try again later.
		</c:otherwise>
	</c:choose>
	<br>
	<a href="home.do">Return Home</a>

</body>
</html>