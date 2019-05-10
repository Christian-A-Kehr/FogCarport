<%-- 
    Document   : test
    Created on : 08-05-2019, 14:11:31
    Author     : Mkhansen
--%>

<%@page import="data.Material"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>The Test</title>
    </head>
    <body>
        <h1>This is a test</h1>
        
        <p>Højde = <% out.print(request.getParameter("height") ); %> </p>
        <p>Længde = <% out.print(request.getParameter("length") ); %> </p>
        <p>Bredde = <% out.print(request.getParameter("width") ); %> </p>
        <p>Med/Uden rejsning = <% out.print(request.getParameter("flatOrNotChoice") ); %> </p>
        <p>Tag materiale = <% out.print(request.getParameter("roofChoice") ); %> </p>
        <p>Stolpe materiale = <% out.print(request.getParameter("woodpostChoice") ); %> </p>
        <p>Valg af grader = <% out.print(request.getParameter("angleChoice") ); %> </p>
        <p>Rem materiale = <% out.print(request.getParameter("beamChoice") ); %> </p>
        <p>Spær materiale = <% out.print(request.getParameter("rafterChoice") ); %> </p>
        <p>Spær afstand = <% out.print(request.getParameter("rafterDistChoice") ); %> </p>
        <p>Skur materiale = <% out.print(request.getParameter("shedChoice") ); %> </p>
        <p>Skur dybde = <% out.print(request.getParameter("shedDepth") ); %> </p>
        <p>Skur bredde = <% out.print(request.getParameter("shedWidth") ); %> </p>
        <p>Valg af gulv = <% out.print(request.getParameter("floorChoice") ); %> </p>
        <p>Kunde navn = <% out.print(request.getParameter("customerName") ); %> </p>
        <p>Kunde email = <% out.print(request.getParameter("customerEmail") ); %> </p>
        <p>Kunde Addresse = <% out.print(request.getParameter("customerAddress") ); %> </p>
    </body>
</html>
