<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Afficher entr�e</title>
</head>
<body>
	<h1>Entr�e #${entry.id}</h1>
	<ul>
		<li>Auteur : ${entry.name}</li>
		<li>Date de cr�ation : ${entry.creation}</li>
		<li>Priorit� : ${entry.priority}</li>
		<li>Estimation : ${entry.estimation}</li>
		<li>Description : ${entry.description}</li>
		<li>Commentaires :</li>
		<ul>
			<c:forEach items="${entry.comments}" var="c">
				<li>
					${c.id}. <b>${c.name}</b> ${c.creation}
					</br>
					${c.content}
				</li>
			</c:forEach>
		</ul>
	</ul>
	
	<a href="index.html">Revenir � l'accueil</a>
</body>
</html>