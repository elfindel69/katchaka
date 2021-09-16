<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp"/>
<body>
<jsp:include page="nav.jsp"/>

<h1 class="text-center">Katchaka Ajout d'intérêt</h1>

<form action="interet" method="post" class="text-center">
    <label class="dark" for="interet">Filtre</label>
    <input type="text" name="INTERET" id="interet" placeHolder="intérêt"><br>
    <button class="btn btn-primary" type="submit">GO!</button>
</form>
<jsp:include page="footer.jsp"/>
</body>
</html>