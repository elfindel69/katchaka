<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="nav.jsp"></jsp:include>

<h1 class="text-center">Katchaka Liste des intérêts</h1>
<form action="interets" method="get">
    <input type="text" name="filtre" value="${filtre}">
    <button class="btn btn-primary" type="submit">GO!</button>
</form>
<form action="interets" method="get">
    <button class="btn btn-primary" type="submit">all interests!</button>
</form>
<c:forEach items="${interets}" var="interet">
    <p>${interet.nom}</p>
</c:forEach>
<a class="btn btn-primary" href="interet">ajouter un intérêt</a><br>
</body>
</html>