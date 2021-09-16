<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="nav.jsp"></jsp:include>

<h1 class="text-center">Katchaka Ajout de ville</h1>

<form action="ville" method="post">
    <input type="text" name="VILLE"  placeHolder="Ville"><br>
    <button class="btn btn-primary" type="submit">GO!</button>
</form>

</body>
</html>