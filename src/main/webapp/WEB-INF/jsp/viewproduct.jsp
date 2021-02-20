
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Product List</h1>
<br>
<a href="logout">Logout</a>
<table>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Rating</th>
		<c:forEach var="pro" items="${list}">
			<tr>
				<td><c:out value="${pro.id}" /></td>
				<td><c:out value="${pro.name}" /></td>
				<td><c:out value="${pro.rating}" /></td>
				<td><a href="edit/${pro.id}">Edit</a></td>
				<td><a href="delete/${pro.id}">Delete</a></td>
			</tr>
		</c:forEach>
</table>
<br />
<a href="add">Add New Product</a>
<a href="download">Download List</a>
