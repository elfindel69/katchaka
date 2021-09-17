<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp"/>
<body>

<h1 class="text-center">Katchaka Connexion</h1>

<form action="connexion" method="post" class="text-center">
    <label class="dark" for="email">Email</label>
    <input type="email" name="email" id="email" placeHolder="email@email.fr"><br>
    <label class="dark" for="password">Mot de Passe</label>
    <input type="password" name="password" id="password" placeHolder="password"><br>
    <button class="btn btn-primary" type="submit">GO!</button>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>