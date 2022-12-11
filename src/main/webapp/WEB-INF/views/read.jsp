<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search by Film ID</title>
</head>
<body style="text-align:center;">



	<!-- Story one search by ID -->
	<div style="background-image: url('https://e0.pxfuel.com/wallpapers/917/663/desktop-wallpaper-displaying-18-for-movie-theater-background-for-your-mobile-tablet-explore-theater-background-home-theater-home-theater-for-movie-theater.jpg'); background-size: center, center; height:500px; width:auto "> 
		<h3>Search by Film ID</h3>
		<form action="results.do" method="post">
			<label for="identifier">ID: </label> 
			<input type="text" name="identifier" size="5" /><br> 
			<input type="submit" value="Search" />
		</form>
	</div>

</body>
</html>