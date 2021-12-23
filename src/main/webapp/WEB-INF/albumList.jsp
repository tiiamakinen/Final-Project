<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/sakura.css/css/sakura.css" type="text/css">
<style> ol { max-width: 400px; } ol li button { float: right; } </style>
</head>
<body>
	<h1>All albums</h1>
	
	<ol>
		<c:forEach items = "${ albums }" var = "album">
			<li>
			<c:out value = "${ album.getName() }" />
			</li>
		</c:forEach>
	</ol>
	
</body>
</html>