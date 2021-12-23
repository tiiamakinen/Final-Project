<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
<style> ol { max-width: 400px; } ol li button { float: right; } </style>
</head>
<body>

	<h1>All artists</h1>
	
	<form method="post">
		<input name="name" type="text" required
			placeholder="type artist or album name here..." autofocus /> <input type="submit"
			value="Add to list" />
	</form>

	<ol>
		<c:forEach items = "${ artists }" var = "artist">
			<li>
			<a href="/albumList?ArtistId=${ artist.getId() }"><c:out value = "${ artist.getName() }" /></a>
			</li>
		</c:forEach>
	</ol>
	
</body>
</html>