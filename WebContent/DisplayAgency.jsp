<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Afficher agence</title>
</head>
<body>
	<h1>Agence #${agency.id} "${agency.name}"</h1>
	<p>Bienvenue, ${username} !</p>
	<a href="/tp2WEB/DisplayBacklogServlet?id=${agency.backlog.id}">Afficher backlog (${agency.backlog.size})</a>
	
	<a href="index.html">Revenir à l'accueil</a>
</body>
</html>
