<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body>
        <h1>Registration page</h1>

        <c:choose>
            <c:when test="${empty login}">
                <form action="<c:url value='/reg'/>" method="post" >

                    <p>Login: <input type="text" name="login"/></p>
                    <span style="color:red;">${loginErr}</span>

                    <p>Name: <input type="text" name="name"/></p>
                    <span style="color:red;">${nameErr}</span>

                    <p>Password: <input type="password" name="pass"/> </p>
                    <span style="color:red;">${passErr}</span>

                    <p>Confirm password: <input type="password" name="passConf"/></p>
                    <span style="color:red;">${passConfErr}</span>

                    <p>Email <input type="text" name="email"/></p>
                    <span style="color:red;">${mailErr}</span>

                    <input type="submit" value="Sign up"/>
                </form>
            </c:when>

            <c:otherwise>
                <form action="<c:url value='/reg'/>" method="post" >

                    <p>Login: <input type="text" value="${login}" name="login"/></p>
                    <span style="color:red;">${loginErr}</span>

                    <p>Name: <input type="text" value="${name}" name="name"/></p>
                    <span style="color:red;">${nameErr}</span>

                    <p>Password: <input type="password" name="pass"/> </p>
                    <span style="color:red;">${passErr}</span>

                    <p>Confirm password: <input type="password" name="passConf"/></p>
                    <span style="color:red;">${passConfErr}</span>

                    <p>Email <input type="text" value="${email}" name="email"/></p>
                    <span style="color:red;">${mailErr}</span>

                    <input type="submit" value="Sign up"/>
                </form>
            </c:otherwise>
        </c:choose>

        <form action="<c:url value='/hello'/>" method="get">
            <input type="submit" value="Back">
        </form>

    </body>
</html>
