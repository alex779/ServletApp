<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome!</title>
    </head>
    <body>

        <h1>Login page</h1>

        <c:choose>
            <c:when test="${empty login}">

                <form action="<c:url value='/login'/>" method="post">

                    Login: <input type="text" name="login"/>
                    Password: <input type="password" name="pass"/>

                    <input type="submit" value="Sign in"/>
                    <span style="color:red;">${errMsg}</span>

                </form>
            </c:when>
            
            <c:otherwise>
                <form action="<c:url value='/login'/>" method="post">

                    Login: <input type="text" value="${login}" name="login"/>
                    Password: <input type="password" name="pass"/>

                    <input type="submit" value="Sign in"/>
                    <span style="color:red;">${errMsg}</span>

                </form>
            </c:otherwise>
        </c:choose>

        <form action="<c:url value='/hello'/>" method="get">
            <input type="submit" value="Back">
        </form>

    </body>
</html>