<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu aggiungi</title>
</head>
<body>
	<form action="/SpringJDBC_FIGO/modifica-aggiungi">
		NOME CITTA<input name="newCity" type="text" value="${citta.cityName}"
			size="40" maxlength="200" /><br> POPOLAZIONE<input
			name="newPopulation" type="text" value="${citta.population}"
			size="40" maxlength="200" /><br> <select name="newCodNation">
			<c:forEach items="${nazioni}" var="n">
				<c:choose>
					<c:when test="${citta.codNation== n.codNation}">
						<option value="${n.codNation}" selected="selected">
							<c:out value="${n.nameNation}" />
						</option>
					</c:when>
					<c:otherwise>
						<option value="${n.codNation}">
							<c:out value="${n.nameNation}" />
						</option>
					</c:otherwise>
				</c:choose>
			</c:forEach>
		</select> <input name="id" type="hidden" value="${citta.id}"> <input
			value="Aggiungi" type="submit">
	</form>
</body>
</html>