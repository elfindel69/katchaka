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
<h1 class="text-center">Katchaka Liste des personnes</h1>
<form action="personnes" method="get">
    <input type="text" name="filtre" value="${filtre}">
    <button class="btn btn-primary" type="submit">GO!</button>
</form>
<form action="personnes" method="get">
    <button class="btn btn-primary" type="submit">all people!</button>
</form>
<c:forEach items="${pagePersonnes.content}" var="personne">
    <p>${personne.pseudo}
    <c:choose>
        <c:when test="${personne.genre.nom eq 'Homme'}">&#x2642;</c:when>
        <c:when test="${personne.genre.nom eq 'Femme'}">&#x2640;</c:when>
        <c:otherwise>&#x2716;</c:otherwise>
    </c:choose>
    </p>
</c:forEach>
<c:if test="${!pagePersonnes.first}">
    <a href="?page=0&sort=${pagePersonnes.sort.iterator().next().property},${pagePersonnes.sort.iterator().next().direction}">
        &#x23EE;
    </a>
    <a href="?page=${pagePersonnes.number-1}&sort=${pagePersonnes.sort.iterator().next().property},${pagePersonnes.sort.iterator().next().direction}">
        &#x23EA;
    </a>
</c:if>
Page ${pagePersonnes.number+1}

<c:if test="${!pagePersonnes.last}">
    <a href="?page=${pagePersonnes.number+1}&sort=${pagePersonnes.sort.iterator().next().property},${pagePersonnes.sort.iterator().next().direction}">
        &#x23E9;
    </a>
    <a href="?page=${pagePersonnes.totalPages-1}&sort=${pagePersonnes.sort.iterator().next().property},${pagePersonnes.sort.iterator().next().direction}">
        &#x23ED;
    </a>

</c:if>
<a href="personne">ajouter une personne</a><br>
<a href="villes">Liste des villes</a><br>
<a href="interets">Liste des intérêts</a><br>
<a href="statuts">Liste des statuts</a><br>
<a href="index">retour à l'accueil</a>
</body>
</html>