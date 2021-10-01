<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>

<table border="1">
    <thead>
    <th>isbn</th>
    <th>title</th>
    <th>author</th>
    <th>delete</th>
    <th>edit</th>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><a href="/admin/books/delete/${book.id}">proceed</a></td>
            <td><a href="/admin/books/edit/${book.id}">proceed</a></td>
        </tr>
    </c:forEach>
    </tbody>

</table>
<h3><a href="/admin/books/add">Add Book</a> </h3>
</body>
</html>