<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="text-align:center;">
<div style="background-image: url('https://e0.pxfuel.com/wallpapers/917/663/desktop-wallpaper-displaying-18-for-movie-theater-background-for-your-mobile-tablet-explore-theater-background-home-theater-home-theater-for-movie-theater.jpg'); background-size: center, center; height:500px; width:auto "> 
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
				<c:if test="${deletedFilm.actors != null }">
				<li> Actors: </li>
					<ul>
						<c:forEach var="actor" items="${film.actors }">
							<li>${actor.firstName } ${actor.lastName }</li>
						</c:forEach>
					</ul>
				</c:if>
				<c:if test="${deletedFilm.categories != null }">
				<li> Categories: </li>
					<ul>
						<li>${film.categories }"
							</li>
					</ul>
				</c:if>
				
			</ul>
		</c:when>
		<c:otherwise>
Failed to delete film from database. Please try again later.
		</c:otherwise>
	</c:choose>
	<br>
	<a href="home.do">Return Home</a>
</div>
</body>
</html>