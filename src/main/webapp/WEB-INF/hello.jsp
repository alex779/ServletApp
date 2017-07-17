<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome</title>
    </head>
    <body>
        <h1>Welcome back, again!</h1>

        <form action="<c:url value='/login'/>" method="get">
            <input type="submit" value="Sign in">
        </form>

        <form action="<c:url value='/reg'/>" method="get">
            <input type="submit" value="Sign up">
        </form>

    </body>
</html>
