<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Todos Page</title>
    <link href="webjars\bootstrap\5.1.0\css\bootstrap.min.css" rel="stylesheet">
</head>
<body>

<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
<div> Welcome ${name} </div>
<hr>
<h1> Your todos are</h1>
<table class="table">
    <thead>
<tr>
    <th>id</th>
    <th>Description</th>
    <th>Target Date</th>
    <th>Is Done?</th>
    <th>Delete</th>
    <th>Update</th>
</tr>
</thead>

<tbody>
<c:forEach items="${todos}" var="todo">
    <tr>
        <td>${todo.id}</td>
        <td>${todo.description}</td>
        <td>${todo.targetDate}</td>
        <td>${todo.done}</td>
        <td> <a href="delete-todo?id=${todo.id}" class="btn btn-warning"> DELETE </a> </td>
        <td> <a href="update-todo?id=${todo.id}" class="btn btn-success"> UPDATE </a> </td>
    </tr>
</c:forEach>
</tbody>
</table>
    <a href="add-todo" class="btn btn-success">Add todo</a>
</div>
<%@ include file="common/footer.jspf"%>
</body>
</html>