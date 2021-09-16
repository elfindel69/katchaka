<%--@elvariable id="filtre" type="java.lang.String"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp"/>
<body>
<jsp:include page="nav.jsp"/>
<h1 class="text-center">Katchaka Liste des villes</h1>
<div class="text-center">
    <form action="villes" method="get">
        <label  class="dark" for="filtre">Filtre</label>
        <input type="text" name="filtre" id="filtre" value="${filtre}">
        <button class="btn btn-primary" type="submit">GO!</button>
    </form>
    <form action="villes" method="get">
        <button class="btn btn-primary" type="submit">all cities!</button>
    </form>
    <c:forEach items="${villes}" var="ville">
        <p>${ville.nom}</p>
    </c:forEach>
    <a class="btn btn-primary" href="ville">Ajouter une ville</a><br>
</div>
<jsp:include page="footer.jsp"/>

</body>
</html>