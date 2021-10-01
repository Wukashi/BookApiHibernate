<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<h1>Give book details</h1>
<form:form method="post" modelAttribute="book">
    <form:hidden path="id"/>
    ISBN: <form:input path="isbn"/><br/>
    <form:errors path="isbn"/><br/>
    Title: <form:input path="title"/><br/>
    <form:errors path="title"/><br/>
    Author: <form:input path="author"/><br/>
    <form:errors path="author"/><br/>
    Publisher <form:input path="publisher"/><br/>
    <form:errors path="publisher"/><br/>
    Type: <form:input path="type"/><br/>
    <form:errors path="type"/><br/>
    <input type="submit" value="Save book">

</form:form>

</body>
</html>
