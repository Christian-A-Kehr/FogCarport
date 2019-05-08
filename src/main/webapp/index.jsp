<%-- 
    Document   : index
    Created on : 01-05-2019, 10:39:20
    Author     : Mkhansen
--%>

<%@page import="data.DataAccessor"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.Material"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <link href="${pageContext.request.contextPath}/StyleSheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h2>Velkommen</h2>
        <form action="Frontcontroller" method="POST">
            <input type="hidden" name="command" value="GoToOrderPage">
            <input type="submit" value="Start ny bestilling">
        </form>
    </body>
</html>