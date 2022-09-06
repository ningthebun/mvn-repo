<footer>

	<nav>
		<div class="col2">
	        <strong>Login Portal Pte. Ltd. &copy;</strong>
	        <p>support@login.portal<br>
	        61234567</p>
	       	<p>71 ABC Crescent<br>
	       	#01-01<br>
	       	Singapore 123456</p>
	    </div>
		<sec:authorize access="isAuthenticated()">
			<div class="col2 col2_2">
		    	<nav><ul>
		    		<li><a href="dashboard">Dashboard</a></li>
		    		
					<sec:authorize access="hasRole('Manager')">
			    		<li><a href="managerPage">Manager Page</a></li>
					</sec:authorize>
					
		    		<li><form class="logoutFooter" action="logout" method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<button type="submit">Log Out</button>
					</form></li>
		    	</ul></nav>
		    </div>
		</sec:authorize>
	</nav>
</footer>