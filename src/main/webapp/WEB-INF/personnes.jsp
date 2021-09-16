<%--@elvariable id="filtre" type="java.lang.String"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp"/>
<body>
<jsp:include page="nav.jsp"/>
<h1 class="text-center">Katchaka Liste des personnes</h1>
<div class="text-center">
    <form action="personnes" method="get">
        <label class="dark" for="filtre">Filtre</label>
            <input type="text" name="filtre" id="filtre" value="${filtre}">

        <button class="btn btn-primary" type="submit">GO!</button>
    </form>
    <form action="personnes" method="get">
        <button class="btn btn-primary" type="submit">all people!</button>
    </form>

</div>

<table class="table-dark table-striped text-center mt-5 mx-auto">
    <thead>
        <tr>
            <th>
                pseudo
                <a href="personnes?sort=pseudo">&#x2B07;</a>
                <a href="personnes?sort=pseudo,DESC">&#x2B06;</a>
            </th>
            <th>
                genre
                <a href="personnes?sort=genre.nom">&#x2B07;</a>
                <a href="personnes?sort=genre.nom,DESC">&#x2B06;</a>
            </th>
            <th>
                date de naissance
                <a href="personnes?sort=dateDeNaissance">&#x2B07;</a>
                <a href="personnes?sort=dateDeNaissance,DESC">&#x2B06;</a>
            </th>
            <th>
                statut
                <a href="personnes?sort=statut.nom">&#x2B07;</a>
                <a href="personnes?sort=statut.nom,DESC">&#x2B06;</a>
            </th>
            <th>
                ville
                <a href="personnes?sort=ville.nom">&#x2B07;</a>
                <a href="personnes?sort=ville.nom,DESC">&#x2B06;</a>
            </th>
            <th>
                intérêts
            </th>
            <th>
                Actions
            </th>
        </tr>
    </thead>
    <tbody>
    <%--@elvariable id="pagePersonnes" type="org.springframework.web.servlet.mvc.condition.ProducesRequestCondition"--%>
    <c:forEach items="${pagePersonnes.content}" var="personne">
        <tr>
            <td>
                    ${personne.pseudo}
            </td>
            <td>
                <c:choose>
                    <c:when test="${personne.genre.nom eq 'Homme'}">&#x2642;</c:when>
                    <c:when test="${personne.genre.nom eq 'Femme'}">&#x2640;</c:when>
                    <c:otherwise>&#x2716;</c:otherwise>
                </c:choose>
            </td>
            <td>
                <fmt:formatDate type = "both" pattern="dd/MM/yyyy HH:mm:ss z" value = "${personne.dateDeNaissance}" />
            </td>
            <td>
                    ${personne.statut.nom}
            </td>
            <td>
                    ${personne.ville.nom}
            </td>
            <td>
                <c:forEach items="${personne.interets}" var="interet">
                    ${interet.nom}<br>
                </c:forEach>
            </td>
            <td>
                <a class="btn btn-primary" href="personne?id=${personne.id}">Editer</a>
                <a class="btn btn-danger" href="#">Supprimer</a>
            </td>
        </tr>

    </c:forEach>
    </tbody>
</table>
<div class="text-center">
    <c:if test="${!pagePersonnes.first}">
        <a href="?page=0&sort=${pagePersonnes.sort.iterator().next().property},${pagePersonnes.sort.iterator().next().direction}">
            &#x23EE;
        </a>
        <a href="?page=${pagePersonnes.number-1}&sort=${pagePersonnes.sort.iterator().next().property},${pagePersonnes.sort.iterator().next().direction}">
            &#x23EA;
        </a>
    </c:if>
    <span class="dark">Page ${pagePersonnes.number+1}</span>

    <c:if test="${!pagePersonnes.last}">
        <a href="?page=${pagePersonnes.number+1}&sort=${pagePersonnes.sort.iterator().next().property},${pagePersonnes.sort.iterator().next().direction}">
            &#x23E9;
        </a>
        <a href="?page=${pagePersonnes.totalPages-1}&sort=${pagePersonnes.sort.iterator().next().property},${pagePersonnes.sort.iterator().next().direction}">
            &#x23ED;
        </a>

    </c:if>
    <br>
    <a class="btn btn-primary mt-1" href="personne">ajouter une personne</a><br>
</div>

<jsp:include page="footer.jsp"/>

</body>
</html>