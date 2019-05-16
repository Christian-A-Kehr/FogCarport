<%-- 
    Document   : settingsPage
    Created on : 15-05-2019, 10:58:25
    Author     : Mkhansen
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="data.Material"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/StyleSheet.css" rel="stylesheet" type="text/css"/>
        <title>Indstillinger</title>
    </head>
    <body>
        <h1>Velkommen til instillinger, her kan du tilføje, opdatére og slette materialer mm.</h1>
        <table>
            <form action="Frontcontroller" method="POST">
                <caption>Tilføj materiale</caption>
                <tr><th>Navn</th><th>Vare nummer</th><th>Beskrivelse</th><th>Længde</th><th>Højde</th><th>Bredde</th><th>Pris</th><th>Materiale</th><th>Type</th></tr>
                        <% ArrayList<Material> allMats = (ArrayList<Material>) session.getAttribute("allMats");
                            for (int i = 0; i < allMats.size(); i++) {
                        %>
                <tr>
                    <td>
                <option value="<%= allMats.get(i).getName()%>"><%out.print(allMats.get(i).getName());%></option>
                </td>
                <td>
                <option value="<%= allMats.get(i).getMatNum()%>"><%out.print(allMats.get(i).getMatNum());%></option>
                </td>
                <td>
                <option value="<%= allMats.get(i).getDesc()%>"><%out.print(allMats.get(i).getDesc());%></option>
                </td>
                <td>
                <option value="<%= allMats.get(i).getHeight()%>"><%out.print(allMats.get(i).getHeight());%></option>
                </td>
                <td>
                <option value="<%= allMats.get(i).getLength()%>"><%out.print(allMats.get(i).getLength());%></option>
                </td>
                <td>
                <option value="<%= allMats.get(i).getWidth()%>"><%out.print(allMats.get(i).getWidth());%></option>
                </td>
                <td>
                <option value="<%= allMats.get(i).getPrice()%>"><%out.print(allMats.get(i).getPrice());%></option>
                </td>
                <td>
                <option value="<%= allMats.get(i).getMaterial()%>"><%out.print(allMats.get(i).getMaterial());%></option>
                </td>
                <td>
                <option value="<%= allMats.get(i).getType()%>"><%out.print(allMats.get(i).getType());%></option>
                </td>
                <%
                    }
                %>
                </tr>
                <td><input name="nameChoice" type="text"></td>
                <td><input id="newMatInput" name="matNumChoice" type="number" value="0"></td>
                <td><input name="descriptionChoice" type="text"></td>
                <td><input id="newMatInput" name="lengthChoice" type="number"></td>
                <td><input id="newMatInput" name="heightChoice" type="number"></td>
                <td><input id="newMatInput" name="widthChoice" type="number"></td>
                <td><input id="newMatInput" name="priceChoice" type="number"></td>
                <td><input name="materialChoice" type="text"></td>
                <td>
                    <select name="typeChoice">
                        <% ArrayList<String> matTypes = (ArrayList<String>) session.getAttribute("allMatTypes");
                            for (int i = 0; i < matTypes.size(); i++) {
                        %>
                        <option value="<%= matTypes.get(i)%>"><%out.print(matTypes.get(i));%></option>
                        <%
                            }
                        %>
                    </select>
                </td>
                <tr>
                <input type="hidden" name="command" value="CreateOrUpdateMaterial">
                <td colspan="9" ><input type="submit" onclick="alert('Materiale tilføjet')" value="Tilføj Materiale/Opdatér Materiale"></td>
            </form>
        </tr>
    </table>
<table>
    <caption>Slet materiale</caption>
    <th colspan="2">Slet materiale</th>
    <form action="Frontcontroller" method="POST">
    <tr>
        <td>Indtast varenummer
            <input name="deleteChoice" type="number" value="0" min="0"></td>
        <input type="hidden" name="command" value="DeleteMaterial">
        </tr>
        <tr>
            <td colspan="2"><input type="submit" onclick="alert('Materiale slettet')" value="Slet Materiale"></td>
    </form>
</tr>
</table>
</body>
</html>
