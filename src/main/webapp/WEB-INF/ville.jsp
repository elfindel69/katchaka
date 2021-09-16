<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp"/>
<body>
<jsp:include page="nav.jsp"/>

<h1 class="text-center">Katchaka Ajout de ville</h1>

<form action="ville" method="post" class="text-center">
    <label  class="dark" for="ville">Ville</label>
    <input type="text" name="VILLE" id="ville" placeHolder="Ville"><br>
    <button class="btn btn-primary" type="submit">GO!</button>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>