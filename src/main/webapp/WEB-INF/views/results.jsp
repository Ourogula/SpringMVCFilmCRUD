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
<title>results</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div style="text-align:center; background-image: url('https://e0.pxfuel.com/wallpapers/917/663/desktop-wallpaper-displaying-18-for-movie-theater-background-for-your-mobile-tablet-explore-theater-background-home-theater-home-theater-for-movie-theater.jpg'); background-repeat:no-repeat; background-size:cover;">
	<c:choose>
		<c:when test="${film != null}">
			<ul style="text-align:center;">
				<li style="color:cornsilk;">ID: ${film.getFilmId()}</li>
				<li style="color:cadetblue">Title: ${film.getTitle()}</li>
				<li style="color:skyblue">Description: ${ film.description}</li>
				<li style="color:cadetblue">Release Year: ${ film.releaseYear}</li>
				<li style="color:cadetblue">Language: ${language}</li>
				<li style="color:cadetblue">Rental Duration: ${ film.rentalDuration}</li>
				<li style="color:cadetblue">Rental Rate: ${ film.rate}</li>
				<li style="color:cadetblue">Length: ${ film.length}</li>
				<li style="color:cadetblue">Replacement Cost: ${ film.replacementCost}</li>
				<li style="color:cadetblue">Rating: ${ film.rating}</li>
				<li style="color:cadetblue">Special Features: ${ film.features}</li>
				<c:if test="${film.actors != null }">
				<li style="color:cadetblue"> Actors: </li>
					<ul>
						<c:forEach var="actor" items="${film.actors }">
							<li style="color:cadetblue">${actor.firstName } ${actor.lastName }</li>
						</c:forEach>
					</ul>
				</c:if>
				<c:if test="${film.categories != null }">
				<li> Categories: </li>
				<ul>
							<li style="color:cadetblue">${categories }</li>
							</ul>
				</c:if>
				
			</ul>
		</c:when>
		<c:when test="${film == null && multiple == true && addFilm == false}">
			<h1>Your query found multiple matches. Please narrow the search to one Film. </h1>
			
		</c:when>
		
		<c:when test="${film == null && multiple == false && addFilm == false}">
			<h1>Your query did not find any matches </h1>
		</c:when>
		</c:choose>
	<br>

	<form action="delete.do" method="POST"style="color:gold">Delete Film:
	<input type="text" name="filmId" value="${film.filmId}">
	<input type="submit" value="DELETE FROM DATABASE">
	</form>
	<form action="update.do" method="POST" style="color:gold">Update Film: 
	<input type="text" name="filmId" value="${film.filmId}">
	<input type="submit" value="UPDATE FILM IN DATABASE">
	</form>

	<a href="home.do">Return Home</a>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</body>
</html>