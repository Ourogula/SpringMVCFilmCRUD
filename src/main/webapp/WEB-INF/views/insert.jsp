<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<title>Add Film</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<body>
	<div style="text-align:center; background-image: url('https://e0.pxfuel.com/wallpapers/917/663/desktop-wallpaper-displaying-18-for-movie-theater-background-for-your-mobile-tablet-explore-theater-background-home-theater-home-theater-for-movie-theater.jpg'); background-repeat:no-repeat; background-size:cover;">
		<h3 style="font-family:fantasy; color:gold;">Add New Film</h3>
		<h4 style="color:goldenrod"><i>Please provide the following details:</i></h4>
		<br /><br /><br />
		<form action="NewFilm.do" method="post"style="color:peru">
			<label for="title">Title:</label> <input type="text" name="title" /><br>
			<label for="description">Description:</label> <input type="text" name="description" /><br> 
			<label for="releaseYear">Release Year:</label> <input type="text" name="releaseYear" size="4" /><br> 
			<label for="language">Language ID:</label> 
				<select name="language">
	
				  <option value="1">1: English</option>
				  <option value="2">2: Italian</option>
				  <option value="3">3: Japanese</option>
				  <option value="4">4: Mandarin</option>
				  <option value="5">5: French</option>
				  <option value="6">6: German</option>
				</select><br>
			<label for="rentDur">Rental Duration:</label> <input type="text" name="rentDur" size="4" value="3" /><br>
			<label for="rentRate">Rental Rate:</label> <input type="text" name="rentRate" size="10" value="4.99" /><br> 
			<label for="length">Length:</label> <input type="text" name="length" size="4" /><br> 
			<label for="replaceCost">Replacement Cost:</label> <input type="text" name="replaceCost" value="19.99" /><br> 
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
		
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
	</body>
	</html>