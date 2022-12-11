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

	<c:choose>
		<c:when test="${film != null}">
			<ul>
				<li>ID: ${film.getFilmId()}</li>
				<li>Title: ${film.getTitle()}</li>
				<li>Description: ${ film.description}</li>
				<li>Release Year: ${ film.releaseYear}</li>
				<li>Language: ${language}</li>
				<li>Rental Duration: ${ film.rentalDuration}</li>
				<li>Rental Rate: ${ film.rate}</li>
				<li>Length: ${ film.length}</li>
				<li>Replacement Cost: ${ film.replacementCost}</li>
				<li>Rating: ${ film.rating}</li>
				<li>Special Features: ${ film.features}</li>
				<c:if test="${film.actors != null }">
				<li> Actors: </li>
					<ul>
						<c:forEach var="actor" items="${film.actors }">
							<li>${actor.firstName } ${actor.lastName }</li>
						</c:forEach>
					</ul>
				</c:if>
				<c:if test="${film.categories != null }">
				<li> Categories: </li>
				<ul>
							<li>${categories }</li>
							</ul>
				</c:if>
				
			</ul>
		</c:when>
		<c:when test="${film == null && multiple == true}">
			<h1>Your query found multiple matches. Please narrow the search to one Film. </h1>
		</c:when>
		<c:when test="${film == null && multiple == false}">
			<h1>Your query did not find any matches </h1>
		</c:when>
		</c:choose>
	<br>

	<form action="delete.do" method="POST">Delete Film:
	<input type="text" name="filmId" value="${film.filmId}">
	<input type="submit" value="DELETE FROM DATABASE">
	</form>
	<form action="update.do" method="POST">Update Film: 
	<input type="text" name="filmId" value="${film.filmId}">
	<input type="submit" value="UPDATE FILM IN DATABASE">
	</form>

	<a href="home.do">Return Home</a>
</body>
</html>