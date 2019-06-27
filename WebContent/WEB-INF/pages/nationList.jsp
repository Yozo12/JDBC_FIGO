
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nazioni</title>
</head>
<body>
	<div align="center">
		<table>
			<thead>
				<tr>
					<td>NATION</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${nazioni}" var="n">
					<tr>
						<td><a href="/SpringJDBC_FIGO/${n.codNation}/citta">${n.nameNation}</a></td>
						<td>${n.population}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>