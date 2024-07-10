<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<a href="<c:url value="/admin/books/add"/>">Dodaj</a>
<table >
    <thead>
    <th>isbn</th>
    <th>title</th>
    <th>author</th>
    <th>action</th>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td>
                <a href="<c:out value="/admin/books/edit/${book.id}"/>">Edytuj</a>
                <a href="<c:out value="/admin/books/delete/${book.id}"/>">Usuń</a>
                <a href="<c:out value="/admin/books/show/${book.id}"/>">Pokaż</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

