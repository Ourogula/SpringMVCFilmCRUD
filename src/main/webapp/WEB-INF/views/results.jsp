<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>results</title>
</head>
<body>

			<ul>
				<li>ID: ${updateFilm.getFilmId()}</li>
				<li>Title: ${updateFilm.getTitle()}</li>
				<li>Description: ${ updateFilm.description}</li>
				<li>Release Year: ${ updateFilm.releaseYear}</li>
				<li>Language: ${language}</li>
				<li>Rental Duration: ${ updateFilm.rentalDuration}</li>
				<li>Rental Rate: ${ updateFilm.rate}</li>
				<li>Length: ${ updateFilm.length}</li>
				<li>Replacement Cost: ${ updateFilm.replacementCost}</li>
				<li>Rating: ${ updateFilm.rating}</li>
				<li>Special Features: ${ updateFilm.features}</li>
				<c:if test="${updateFilm.actors != null }">
				<li> Actors: </li>
					<ul>
						<c:forEach var="actor" items="${updateFilm.actors }">
							<li>${actor.firstName } ${actor.lastName }</li>
						</c:forEach>
					</ul>
				</c:if>
				<c:if test="${Film.categories != null }">
				<li> Categories: </li>
					<ul>
						<c:forEach var="category" items="${film.categories }">
							<li>${category }</li>
						</c:forEach>
					</ul>
				</c:if>
				
			</ul>
		
	<br>
	<form action="delete.do" value="${filmId}"><button type="button" onclick="">DELETE</button>Delete Film</form>
	<form action="update.do" value="${filmId}"><button type="button" onclick="">UPDATE</button>>Update Film</form>
	<a href="home.do">Return Home</a>
</body>
</html>