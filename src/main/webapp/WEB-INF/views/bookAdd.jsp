<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add book</title>
</head>
<body>

<form:form method="post" modelAttribute="book">
    <p>ISBN</p>
    <form:input path="isbn"/>
    <form:errors path="isbn"/><br/>
    <p>Title</p>
    <form:input path="title"/>
    <form:errors path="title"/><br/>
    <p>Author</p>
    <form:input path="author"/>
    <form:errors path="author"/><br/>
    <p>Publisher</p>
    <form:input path="publisher"/>
    <form:errors path="publisher"/><br/>
    <p>Type</p>
    <form:input path="type"/>
    <form:errors path="type"/><br/>
    <input type="submit" value="Save">
</form:form>

</body>
</html>
