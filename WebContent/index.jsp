<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<h1>Se connecter</h1>
	<form action="DisplayAgencyServlet" method="post">
		Nom : <input type="text" name="name" value="${name}" required>
		<c:if test="${empty agencies}">
			Agence (id) : <input type="number" name="id">
			<input type="submit" value="Valider">
			<input type="submit" formaction="ListAllAgenciesServlet" value="Lister les agences disponibles">
		</c:if>
		<c:if test="${not empty agencies}">
			Agence :
			<select name='id' required>
			    <c:forEach items="${agencies}" var="agency">
		            <option value="${agency.id}">${agency.name}</option>
			    </c:forEach>
			</select>
			<input type="submit" value="Valider">
		</c:if>
	</form>
	
	<h1>Créer une nouvelle agence</h1>
	<form action="CreateAgencyServlet" method="post">
		Nom : <input type="text" name ="name" required>
		<input type="submit" value="Valider">
	</form>
</body>
</html>