<div class="container">
	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<form action="/SpringMvcStepByStepApp/login" method="POST">
		Name : <input name="name" type="text" /> Password : <input
			name="password" type="password" /> <input type="submit" />
	</form>
</div>
<%@ include file="common/footer.jspf"%>