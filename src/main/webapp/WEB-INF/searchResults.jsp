<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
<style> ol { max-width: 400px; } ol li button { float: right; } </style>
</head>
<body>

	<h1>All artists</h1>
	
	<h6>Add artists to the list</h6>
	
	<form method="post">
		<input name="name" type="text" required
			placeholder="type artist name here..." autofocus /> <input type="submit"
			value="Add to list" />
	</form>
	
	<h6>Search artists from the list</h6>
	
	<form action="/searchResults" method="get">
		<input name="Name" type="text" required
			placeholder="type artist or album name here..." autofocus /> <input type="submit"
			value="Search" />
	</form>

	<ol>
		<c:forEach items = "${ artists }" var = "artist">
			<li>
			<a href="/searchResults?Name=${ artist.getName() }"><c:out value = "${ artist.getName() }" /></a>
			</li>
		</c:forEach>
	</ol>
	
</body>
</html>