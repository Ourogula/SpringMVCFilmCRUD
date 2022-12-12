<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html style="
  background: url('https://e0.pxfuel.com/wallpapers/917/663/desktop-wallpaper-displaying-18-for-movie-theater-background-for-your-mobile-tablet-explore-theater-background-home-theater-home-theater-for-movie-theater.jpg') no-repeat; 
  background-color: black;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body  style="text-align:center; background-image: url('https://e0.pxfuel.com/wallpapers/917/663/desktop-wallpaper-displaying-18-for-movie-theater-background-for-your-mobile-tablet-explore-theater-background-home-theater-home-theater-for-movie-theater.jpg'); background-repeat:no-repeat; background-size:cover;">
<div> 

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
				<li> Categories: </li>
					<ul>
							<li>${updateFilm.categories}</li>
					</ul>
			</ul>
		</c:when>
		<c:otherwise>
Failed to update film ${updateFilm.title } in database. Please try again later.
		</c:otherwise>
	</c:choose>
	<br>
	<a href="home.do">Return Home</a>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>

</html>