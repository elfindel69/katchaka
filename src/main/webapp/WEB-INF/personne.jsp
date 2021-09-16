<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Katchaka</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style>
        .error{
            color:red;
        }
    </style>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>

<h1 class="text-center">Katchaka Ajout de ville</h1>

<form:form method="POST" action="personne"
           modelAttribute="personne">
    <form:label path="pseudo">Pseudo</form:label>
    <form:input path="pseudo" />
    <br>
    <form:errors path="pseudo" cssClass="error"></form:errors>
    <br>
    <form:label path="email">Email</form:label>
    <form:input type="email" path="email" />
    <br>
    <form:errors path="email" cssClass="error"></form:errors>
    <br>
    <form:label path="motDePasse">Mot de passe</form:label>
    <form:password path="motDePasse" />
    <br>
    <form:errors path="motDePasse" cssClass="error"></form:errors>
    <br>
    <form:label path="ville">Ville</form:label>
    <form:select path="ville">
        <form:options items="${villes}" itemLabel="nom" itemValue="id"/>

    </form:select>
    <br>
    <form:errors path="ville" cssClass="error"></form:errors><br>
    <br>
    <form:label path="genre">Genre</form:label>
    <form:select path="genre">
        <form:options items="${genres}" itemLabel="nom" itemValue="id"/>

    </form:select>
    <br>
    <form:errors path="genre" cssClass="error"></form:errors>
    <br>
    <form:label path="genreRecherche">Genre recherché</form:label>
    <form:select path="genreRecherche">
        <form:options items="${genres}" itemLabel="nom" itemValue="id"/>

    </form:select>
    <br>
    <form:errors path="genreRecherche" cssClass="error"></form:errors>
    <br>
    <form:label path="statut">Statut</form:label>
    <form:select path="statut">
        <form:options items="${statuts}" itemLabel="nom" itemValue="id"/>
    </form:select>
    <br>
    <form:errors path="statut" cssClass="error"></form:errors>
    <br>
    <form:label path="interets">Statut</form:label>
    <form:select path="interets">
        <form:options items="${interets}" itemLabel="nom" itemValue="id"/>
    </form:select>
    <br>
    <form:errors path="interets" cssClass="error"></form:errors>
    <br>
    <form:label path="bio">Bio</form:label>
    <form:textarea path="bio" />
    <br>
    <form:errors path="bio" cssClass="error"></form:errors>
    <br>
    <form:label path="dateDeNaissance">Date de Naissance</form:label>
    <form:input type="date" path="dateDeNaissance" />
    <br>
    <form:errors path="dateDeNaissance" cssClass="error"></form:errors>
    <br>
    <form:label path="estFumeur">Fumeur</form:label>
    <form:checkbox path="estFumeur" />
    <br>
    <button type="submit" class="btn btn-primary"> GO!</button>
</form:form>

</body>
</html>