<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp"/>
<body>
<jsp:include page="nav.jsp"/>

<h1 class="text-center">Katchaka Liste des statuts</h1>

<div class="text-center">
    <%--@elvariable id="statuts" type="java.util.List"--%>
    <c:forEach items="${statuts}" var="statut">
        <p>
            <a href="statut?id=${statut.id}">${statut.nom} </a>
        </p>
    </c:forEach>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>