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
		<c:when test="${success == true}">
Successfully updated the following film from the film database:
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
				<c:if test="${deletedFilm.categories != null }">
				<li> Categories: </li>
					<ul>
						<c:forEach var="category" items="${film.categories }">
							<li>${category }</li>
						</c:forEach>
					</ul>
				</c:if>
				
			</ul>
		</c:when>
		<c:otherwise>
Failed to update film ${updateFilm.title } in database. Please try again later.
		</c:otherwise>
	</c:choose>
	<br>
	<a href="home.do">Return Home</a>
</body>
</html>