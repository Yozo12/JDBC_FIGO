<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu modifica</title>
</head>
<body>
	<form action="/SpringJDBC_FIGO/modifica-aggiungi">
		NOME CITTA <input name="newCity" type="text" value="${citta.cityName}"
			size="40" maxlength="200" /> <br> POPOLAZIONE <input
			name="newPopulation" type="text" value="${citta.population}"
			size="40" maxlength="200" /> <br> <input name="newCodNation"
			type="hidden" value="${citta.codNation} " size="40" maxlength="200" />
		<input name="id" type="hidden" value="${citta.id}"> <input
			value="update" type="submit">
	</form>
</body>
</html>