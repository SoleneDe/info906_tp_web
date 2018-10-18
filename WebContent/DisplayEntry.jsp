<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Afficher entrée</title>
</head>
<body>
	<h1>Entrée #${entry.id} "${entry.name}"</h1>
	<ul>
		<li>Date de création : ${entry.date}</li>
		<li>Priorité : ${entry.priority}</li>
		<li>Estimation : ${entry.estimation}</li>
		<li>Description : ${entry.description}</li>
		<li>Commentaires :</li>
		<ul>
			<c:forEach items="${entry.comments}" var="c">
				<li>
					${c.id}. <b>${c.name}</b> ${c.date}
					</br>
					${c.content}
				</li>
			</c:forEach>
		</ul>
	</ul>
	
	<a href="index.html">Revenir à l'accueil</a>
</body>
</html>