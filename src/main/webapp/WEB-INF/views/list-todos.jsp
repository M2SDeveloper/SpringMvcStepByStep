<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<table class="table table-striped" border="1">
		<caption>Your Todos are</caption>

		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Completed</th>
				<th>Action</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.desc}</td>
					<td><fmt:formatDate pattern="dd/MM/yyyy"
							value="${todo.targetDate}" /></td>
					<td>${todo.done}</td>
					<td><a type="button" class="btn btn-primary"
						href="/SpringMvcStepByStepApp/update-todo?id=${todo.id}">Edit</a>
						<a type="button" class="btn btn-warning"
						href="/SpringMvcStepByStepApp/delete-todo?id=${todo.id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a class="button" href="/SpringMvcStepByStepApp/add-todo">Add</a>
	</div>
</div>

<%@ include file="common/footer.jspf"%>