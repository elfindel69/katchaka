<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="nav.jsp"></jsp:include>

<h1 class="text-center">Katchaka Liste des statuts</h1>


<c:forEach items="${statuts}" var="statut">
    <p>
        <a href="statut?id=${statut.id}">${statut.nom} </a>
    </p>
</c:forEach>


</body>
</html>