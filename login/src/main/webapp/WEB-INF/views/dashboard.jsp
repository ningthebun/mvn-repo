<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">
<meta charset="utf-8">

<title>Dashboard</title>
<link href="<c:url value='/css/style.css' />" rel="stylesheet"> 

<%@ include file="header.jsp" %>

<main>
    <section>
        <h1>Welcome, ${user.fName}
        </h1>
        <p>Full name: ${user.fName} ${user.lName}</p>
        <p>Username: ${user.username}</p>
        <p>Role: ${user.role}</p>
	</section>
	<c:if test="${user.role == 'Manager'}">
		<button onclick="window.location.href='managerPage';">Manager Page</button>
	</c:if>
</main>
<%@ include file="footer.jsp" %>
</html>