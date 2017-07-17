<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit profile</title>
    </head>
    <body>

        <form method="POST">

            <input type="hidden" name="id" value="${user.name}"/>

            <p>id : ${user.id}</p>
            <p>Name: ${user.name}</p>

            <p>Password: <input type="password" name="pass" value="${user.password}"/></p>
            <span style="color:red;">${passErr}</span>

            <p>Confirm password: <input type="password" name="passConf" value="${user.password}"/></p>
            <span style="color:red;">${passConfErr}</span>

            <p>Email <input type="text" name="email" value="${user.email}"/></p>
            <span style="color:red;">${mailErr}</span>

            <br>
            <input type="submit" value="edit">
        </form>

        <br>

        <a href="user?id=${user.id}">Back</a>

    </body>
</html>