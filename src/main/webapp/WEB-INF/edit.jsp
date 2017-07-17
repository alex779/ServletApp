<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit user</title>
    </head>
    <body>

        <form method="POST">
            
            <input type="hidden" name="id" value="${user.name}"/>

            <p>Name: <input type="text" value="${user.name}" name="name"/></p>
            <span style="color:red;">${nameErr}</span>
            <br>
            
        </tr>
        <tr>
            <td>role: </td>   
            <td><input type="radio" value="admin" name="role"/>admin</td>
            <td><input type="radio" value="user" name="role" checked=""/>user</td>
        </tr>
        <br>

        <input type="submit" value="edit">
    </form>

    <form action="<c:url value='/admin'/>" method="get">
        <input type="submit" value="Back">
    </form>

</body>
</html>