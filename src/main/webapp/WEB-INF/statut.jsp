<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<h1 class="text-center">Katchaka Statut ${statut.nom}</h1>
<div class="text-center">
    <p>liste des personnes ${statut.nom}</p>
    <c:forEach items="${statut.personnes}" var="personne">
        <p>${personne.pseudo}
            <c:choose>
                <c:when test="${personne.genre.nom eq 'Homme'}">&#x2642;</c:when>
                <c:when test="${personne.genre.nom eq 'Femme'}">&#x2640;</c:when>
                <c:otherwise>&#x2716;</c:otherwise>
            </c:choose>
        </p>
    </c:forEach>
</div>

<jsp:include page="footer.jsp"></jsp:include>
</body>

</html>