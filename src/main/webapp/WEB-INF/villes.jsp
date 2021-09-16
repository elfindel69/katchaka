<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="nav.jsp"></jsp:include>
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
<a class="btn btn-primary" href="ville">Ajouter une ville</a><br>

</body>
</html>