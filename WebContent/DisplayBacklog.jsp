<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Afficher backlog</title>
</head>
<body>
	<h1>Backlog #${backlog.id}</h1>
	<p>Entrées (${backlog.size})</p>
	
	<ul>
		<c:forEach items="${backlog.entries}" var="e">
			<li>
				${e.id}. <b>${e.name}</b> ${e.date}
				</br>
				Priorité : ${e.priority}, estimation : ${e.estimation}
				</br>
				${e.description}
			</li>
		</c:forEach>
	</ul>
	
	<a href="index.html">Revenir à l'accueil</a>
</body>
</html>