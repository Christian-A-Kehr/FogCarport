<%-- 
    Document   : index
    Created on : 01-05-2019, 10:39:20
    Author     : Mkhansen
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.Material"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <link href="StyleSheet.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h2>Bestilling</h2>
        <h4>Alle mål er i mm</h4>

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
            <% ArrayList<Material> mats = (ArrayList<Material>) request.getSession().getAttribute("allRoofMats");
                for (int i = 0; i < mats.size(); i++) {
            %>
            <tr>
                <td><form action="">
                        <input type="radio" name="choice" value="Yes"> Ja
                        <input type="radio" name="choice" value="No"> Nej<br>
                    </form>
                </td>
               <td><%= mats.get(i).getName() %></td>
                    <%
                        }
                    %>
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
                <td><input type="text" value="HENT FRA DATABASE" ></td>
                <td><input type="text" value="HENT FRA DATABASE" ></td>
                <td><input type="number" max="1000" value="0" ></td>
            </tr>
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