<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!doctype html>
<html lang="en">
<meta charset="utf-8">

<title>You're Logged Out</title>

<%@ include file="header.jsp" %>

<sec:authorize access="isAuthenticated()">
	Shown if log out is unsuccessful: <sec:authentication property="principal.username" /> 
</sec:authorize> 

<main>
    <section>
        <h1>You Have Logged Out</h1>
        <p>See you again soon!</p>
        <button onclick="window.location.href='login';">Log In Again</button>
    </section>
</main>
<%@ include file="footer.jsp" %>
</html>