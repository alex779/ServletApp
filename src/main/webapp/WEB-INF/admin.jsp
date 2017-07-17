<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Control page</title>
        <style type="text/css">
            table, td{
                border: 1px solid black;
            }
        </style>
    </head>
    <body>
        <table style="">

            <tr>
                <td>id</td>
                <td>login</td>
                <td>name</td> 
                <td>email</td>
                <td>role</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>

            <c:forEach var="user" items="${users}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.login}</td>
                    <td>${user.name}</td>
                    <td>${user.email}</td>
                    <td>${user.role}</td>
                    <td><a href="admin/edit?id=${user.id}">edit</a></td>
                    <td><a href="admin/delete?id=${user.id}">delete</a></td>
                </tr>
            </c:forEach>

            <form action="<c:url value='/logout'/>" method="get">
                <input type="submit" value="Logout">
            </form>

        </table>

        <a href="admin/add">Add new user</a>
    </body>
</html>