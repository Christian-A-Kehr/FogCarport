<%-- 
    Document   : orderPage
    Created on : 01-05-2019, 09:57:21
    Author     : Mkhansen
--%>

<%@page import="data.DataAccessor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.Material"%>
<%@page import="data.Material"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%--
        DataAccessor dataAccess = new DataAccessor();
        request.setAttribute("allRoofMats", dataAccess.GetListSpecificMaterials("Tagsten"));
    --%>
    <head>
        <title>Start Page</title>
        <link href="StyleSheet.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h2>Bestilling</h2>
        <h3>Alle mål er i mm</h3>

        <table>
            <caption><b>Carport dimensioner</b></caption>
            <tr>
                <th>Højde</th>
                <th>Længde</th>
                <th>Bredde</th>
            </tr>
            <tr>
                <td><input type="number" min="2100" value="2100" ></td>
                <td><input type="number" min="0" value="0" ></td>
                <td><input type="number" min="0" value="0" ></td>
            </tr>
        </table>
        <table>
            <caption><b>Tag</b></caption>
            <tr>
                <th>Med/Uden rejsning</th>
                <th>Materiale valg</th>
                <th>Grader</th>
            </tr>
            <tbody>
                <tr>
                    <td>
                        <form action="">
                            <input type="radio" name="choice" value="Yes"> Ja
                            <input type="radio" name="choice" value="No"> Nej
                        </form>
                    </td>

                    <td>
                        <form action="">
                            <select>
                                <% ArrayList<Material> mats = (ArrayList<Material>) request.getAttribute("allRoofMats");
                                    for (int i = 0; i < mats.size(); i++) {
                                %>
                                <option value="<% mats.get(i);%>"><%mats.get(i).getName().toString();%></option>
                                <%
                                    }
                                %>
                            </select>
                        </form>
                    </td>
                    <td><input type="number" min="2.5" max="50" value="2.5" ></td>
                </tr>
            </tbody>
        </table>
        <table>
            <caption><b>Rem og Spær</b></caption>
            <tr>
                <th>Rem materiale valg</th>
                <th>Spær materiale valg</th>
                <th>Spær afstand</th>
            </tr>
            <tr>
            <tbody>

                <% for (int i = 0; i < mats.size(); i++) {
                %>
            <datalist id="deezMats">
                <option value="<%mats.get(i).getName();%>"> <% mats.get(i).getName().toString(); %></option>
            </datalist>
                <%
                    }
                %>
            <td>
                <form action="">
                    <input list="deezMats">
                </form>
            </td>
            <td><input type="text" value="HENT FRA DATABASE" ></td>
            <td><input type="number" max="1000" value="0" ></td>
        </tr>
    </tbody>
</table>
<table>
    <caption><b>Skur</b></caption>
    <tr>
        <th>Beklædning</th>
        <th>Gulv</th>
        <th>Længde</th>
        <th>Bredde</th>
    </tr>
    <tr>
        <td><input type="text" value="HENT FRA DATABASE" ></td>
        <td><input type="text" value="HENT FRA DATABASE" ></td>
        <td><input type="number" min="0" value="0" ></td>
        <td><input type="number" min="0" value="0" ></td>
    </tr>
</table>
<table>
    <caption><b>Kunde information</b></caption>
    <tr>
        <th>Navn</th>
        <th>Email</th>
        <th>Addresse</th>
    </tr>
    <tr>
        <td><input type="text"></td>
        <td><input type="text"></td>
        <td><input type="text"></td>
    </tr>
</table>
</body>
</html>
