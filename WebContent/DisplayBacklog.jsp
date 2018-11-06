<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Afficher backlog</title>
</head>
<body>
	<h1>Backlog #${backlog.id}</h1>
	
	<h2>Ajouter une entrée</h2>
	<form action="/tp2WEB/CreateEntryServlet" method="post">
		<input style="visibility:hidden;position:absolute;" name="idBacklog" value="${backlog.id}"/>
		Priorité : <input type="number" name="priority"/>
		Estimation : <input type="number" name="estimation"/>
		Description : <input type="text" name ="description">
		<input type="submit" value="Valider">
	</form>
	
	<p>Entrées (${backlog.size})</p>
	
	<ul>
		<c:forEach items="${backlog.entries}" var="e">
			<li>
				${e.id}. <b>${e.name}</b> ${e.creation}
				</br>
				Priorité : ${e.priority}, estimation : ${e.estimation}
				</br>
				${e.description}
				</br>
				<a href="/tp2WEB/DisplayEntryServlet?id=${e.id}">Afficher les commentaires (${e.comments.size()})</a>
			</li>
		</c:forEach>
	</ul>
	
	<a href="index.html">Revenir à l'accueil</a>
</body>
</html>