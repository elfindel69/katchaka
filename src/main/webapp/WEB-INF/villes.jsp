<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Katchaka</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<h1 class="text-center">Katchaka Liste des villes</h1>
<form action="villes" method="get">
    <input type="text" name="filtre" value="${filtre}">
    <button class="btn btn-primary" type="submit">GO!</button>
</form>
<form action="villes" method="get">
    <button class="btn btn-primary" type="submit">all cities!</button>
</form>
<c:forEach items="${villes}" var="ville">
    <p>${ville.nom}</p>
</c:forEach>
<a href="ville">Ajouter une ville</a><br>
<a href="personnes">Liste des personnes</a><br>
<a href="interets">Liste des intérêts</a><br>
<a href="statuts">Liste des statuts</a><br>
<a href="index">retour à l'accueil</a>
</body>
</html>