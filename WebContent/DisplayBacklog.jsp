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
	
	<h2>Ajouter une entr�e</h2>
	<form action="/tp2WEB/CreateEntryServlet" method="post">
		<input style="visibility:hidden;position:absolute;" name="idBacklog" value="${backlog.id}"/>
		Priorit� : <input type="number" name="priority" required/>
		Estimation : <input type="number" name="estimation" required/>
		Description : <input type="text" name ="description" required/>
		<input type="submit" value="Valider"/>
	</form>
	
	<p>Entr�es (${backlog.size})</p>
	
	<ul>
		<c:forEach items="${backlog.entries}" var="e">
			<li>
				${e.id}. <b>${e.name}</b> ${e.creation}
				</br>
				Priorit� : ${e.priority}, estimation : ${e.estimation}
				</br>
				${e.description}
				</br>
				<a href="/tp2WEB/DisplayEntryServlet?id=${e.id}">Afficher l'entr�e et ses commentaires (${e.comments.size()})</a>
				<form action="/tp2WEB/DeleteEntryServlet" method="post">
					<input style="visibility:hidden;position:absolute;" name="idBacklog" value="${backlog.id}"/>
					<input style="visibility:hidden;position:absolute;" name="idEntry" value="${e.id}"/>
					<input type="submit" value="Supprimer l'entr�e"/>
				</form>
			</li>
		</c:forEach>
	</ul>
	
	<a href="index.jsp">Revenir � l'accueil</a>
</body>
</html>