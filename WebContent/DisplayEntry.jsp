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
	
	<h2>Supprimer l'entr�e</h2>
	<form action="/tp2WEB/DeleteEntryServlet" method="post">
		<input style="visibility:hidden;position:absolute;" name="idEntry" value="${entry.id}"/>
		<input type="submit" value="Supprimer l'entr�e"/>
	</form>
	
	<h2>Ajouter un commentaire</h2>
	<form action="/tp2WEB/CreateCommentServlet" method="post">
		<input style="visibility:hidden;position:absolute;" name="idEntry" value="${entry.id}"/>
		<input style="visibility:hidden;position:absolute;" name="name" value="${username}"/>
		<input type="text" name ="content" required/>
		<input type="submit" value="Valider"/>
	</form>
	
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
	
	<a href="/tp2WEB/DisplayBacklogServlet?id=${idBacklog}">Retour � la backlog</a>
	<a href="index.html">Revenir � l'accueil</a>
</body>
</html>