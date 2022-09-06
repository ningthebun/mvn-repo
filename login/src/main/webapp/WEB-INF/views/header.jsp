<link href="<c:url value='/css/style.css' />" rel="stylesheet"> 

<header class="clearfix">
	<!-- NOT LOGGED IN -->
	<img src="<c:url value='/images/logo.gif' />" alt="Login Portal">
	
	<!-- LOGGED IN -->
	<sec:authorize access="isAuthenticated()">
	    <nav>
			<a href="dashboard">Dashboard</a>
			
			<sec:authorize access="hasRole('Manager')">
				<a href="managerPage">Manager Page</a>
			</sec:authorize>
			
			<form class="logoutNav" action="logout" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<button class="headerBtn" type="submit">
					Log Out
				</button>
			</form>
		</nav>
	</sec:authorize>
</header>