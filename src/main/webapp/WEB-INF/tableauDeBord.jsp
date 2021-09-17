<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp"/>
<body>

<h1 class="text-center">Katchaka</h1>
<h2 class="text-center">Bienvenue ${sessionScope.personne.pseudo} - solde ${sessionScope.personne.nbCredits}</h2>

<p class="text-center">Invitations recues</p>
<table class="table-dark table-striped text-center mt-5 mx-auto">
    <thead>
        <tr>
            <th>Pseudo</th>
            <th>Ville</th>
            <th>Envoyée le</th>
            <th>Operations</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.personne.invitationsRecues}" var="invitation">
        <tr>
            <td>
                ${invitation.expediteur.pseudo}
            </td>
            <td>
                ${invitation.expediteur.ville.nom}
            </td>
            <td>
                <fmt:formatDate type = "both" pattern="dd/MM/yyyy HH:mm:ss z" value = "${invitation.dateEnvoi}" />
            </td>
            <td>
                <c:choose>
                    <c:when test="${invitation.dateLecture ne null}">
                        aa
                        ${invitation.estAccepte?"acceptee le ":"déclinée le "}
                        <fmt:formatDate type = "both" pattern="dd/MM/yyyy HH:mm:ss z" value = "${invitation.dateLecture}" />
                    </c:when>
                    <c:otherwise>
                        <a class="btn btn-success" href="accepterInvitation?id=${invitation.id}">Accepter</a>
                        <a class="btn btn-success" href="declinerInvitation?id=${invitation.id}">Decliner</a>
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p class="text-center">Invitations envoyées</p>
<table class="table-dark table-striped text-center mt-5 mx-auto">
    <thead>
    <tr>
        <th>Pseudo</th>
        <th>Statut</th>
        <th colspan="2">Envoyée le</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${sessionScope.personne.invitationsEnvoyees}" var="invitation">
        <tr>
            <td>
                    ${invitation.destinataire.pseudo}
            </td>
            <td>
                    ${invitation.expediteur.statut.nom}
            </td>
            <td colspan="2">
                <fmt:formatDate type = "both" pattern="dd/MM/yyyy HH:mm:ss z" value = "${invitation.dateEnvoi}" />
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


<a class="btn btn-danger" href="deconnexion">Déconnexion</a><br/>
<a class="btn btn-primary" href="personnes">liste des personnes</a>
<jsp:include page="footer.jsp"/>
</body>
</html>