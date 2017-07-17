
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add user</title>
    </head>
    <body>

        <c:choose>
            <c:when test="${empty login}">
                 <form method="POST">

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

                    <p>role  
                        <input type="radio" value="admin" name="role"/>admin
                        <input type="radio" value="user" name="role" checked=""/>user
                    </p>

                    <input type="submit" value="add"/>
                </form>
            </c:when>

            <c:otherwise>
                <form action="<c:url value='/admin/add'/>" method="post" >

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

                    <input type="submit" value="add"/>
                </form>
            </c:otherwise>
        </c:choose>

        <form action="<c:url value='/admin'/>" method="get">
            <input type="submit" value="Back">
        </form>

    </body>
</html>