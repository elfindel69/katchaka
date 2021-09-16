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
<h1 class="text-center">Katchaka Liste des statuts</h1>


<c:forEach items="${statuts}" var="statut">
    <p>
        <a href="statut?id=${statut.id}">${statut.nom} </a>
    </p>
</c:forEach>
<a href="ville">Ajouter une ville</a><br>
<a href="personnes">Liste des personnes</a><br>
<a href="interets">Liste des intérêts</a><br>
<a href="statuts">Liste des statuts</a><br>
<a href="index">retour à l'accueil</a>
</body>
</html>