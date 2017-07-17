<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile page</title>
        <style type="text/css">
            table, td{
                border: 1px solid black;
            }
        </style>
    </head>

    <body>
        <p>Hello, <c:out value="${user.name}"/></p>

        <table style="">
            <tr>
                <td>id</td>
                <td>login</td>
                <td>name</td> 
                <td>email</td>
                <td>role</td>

            </tr>

            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.role}</td>
            </tr>

        </table>

        <p><a href="userEdit?id=${user.id}">Edit profile</a></p>

        <form action="<c:url value='/logout'/>" method="get">
            <input type="submit" value="Logout">
        </form>

    </body>
</html>
