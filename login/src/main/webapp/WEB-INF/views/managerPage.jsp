<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">
<meta charset="utf-8">

<title>Manager Page</title>
<link href="<c:url value='/css/style.css' />" rel="stylesheet"> 

<%@ include file="header.jsp" %>

<main>
	<c:if test="${user.role == 'Manager'}">
	    <section>
	        <h1>Manager Page
	        </h1>
	        <p>For portal manager's use only.</p>
	        <p>Please report any unauthorised access to support@login.portal.</p>
	        <p>Thank you.</p>
		</section>
	</c:if>
</main>
<%@ include file="footer.jsp" %>
</html>