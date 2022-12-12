<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html
	style="background: url('https://e0.pxfuel.com/wallpapers/917/663/desktop-wallpaper-displaying-18-for-movie-theater-background-for-your-mobile-tablet-explore-theater-background-home-theater-home-theater-for-movie-theater.jpg') no-repeat; background-color: black; -webkit-background-size: cover; -moz-background-size: cover; -o-background-size: cover; background-size: cover;">
<head>
<meta charset="UTF-8">
<title>Deletion Result</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">
</head>
<body style="text-align: center; color: gold">
	<div
		style="background-image: url('https://e0.pxfuel.com/wallpapers/917/663/desktop-wallpaper-displaying-18-for-movie-theater-background-for-your-mobile-tablet-explore-theater-background-home-theater-home-theater-for-movie-theater.jpg'); background-repeat: no-repeat; background-size: cover;">
		<br /> <br /> <br /> <br />

		<c:choose>
			<c:when test="${not empty deletedFilm}">
Successfully deleted the following film from the film database:<br />
			
				ID: ${deletedFilm.getFilmId()}<br />
				Title: ${deletedFilm.getTitle()}<br />
				Description: ${ deletedFilm.description}<br />
				Release Year: ${ deletedFilm.releaseYear}<br />
				Language: ${language}<br />
				Rental Duration: ${ deletedFilm.rentalDuration}<br />
				Rental Rate: ${ deletedFilm.rate}<br />
				Length: ${ deletedFilm.length}<br />
				Replacement Cost: ${ deletedFilm.replacementCost}<br />
				Rating: ${ deletedFilm.rating}<br />
				Special Features: ${ deletedFilm.features}<br />
				<c:if test="${deletedFilm.actors != null }">
				 Actors: <br />
					
						<c:forEach var="actor" items="${film.actors }">
							${actor.firstName } ${actor.lastName }<br />
						</c:forEach>

				</c:if>
				<c:if test="${deletedFilm.categories != null }">
				 Categories: <br />
					
						${film.categories }<br />
							
					
				</c:if>


			</c:when>
			<c:otherwise>
Failed to delete film from database. Please try again later.<br />
		</c:otherwise>
		</c:choose>
		<br> <a href="home.do">Return Home</a>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>

</body>
</html>