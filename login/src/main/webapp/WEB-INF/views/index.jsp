<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>       
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!doctype html>
<html lang="en">
<meta charset="utf-8">

<title>Log In</title>

<%@ include file="header.jsp" %>

<main>
    <section>
        <h1>Log In</h1>
        <div class="highlighted">
            <form:form id="login" method="POST" action="loginProcess" modelAttribute="loginUser">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						
				<form:label path="username">Username
                    <form:input path="username" />
                </form:label>

                <form:label path="pw">Password
                    <form:input type="password" path="pw" />
                </form:label>
                <br>
                <p class="error">${message}</p>
                <form:button type="submit">Log In</form:button>
           </form:form>
        </div>
    </section>
</main>
<%@ include file="footer.jsp" %>
</html>