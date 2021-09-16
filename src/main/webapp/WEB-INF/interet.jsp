<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"></jsp:include>
<body>
<jsp:include page="nav.jsp"></jsp:include>

<h1 class="text-center">Katchaka Ajout d'intérêt</h1>

<form action="interet" method="post" class="text-center">
    <input type="text" name="INTERET"  placeHolder="intérêt"><br>
    <button class="btn btn-primary" type="submit">GO!</button>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>