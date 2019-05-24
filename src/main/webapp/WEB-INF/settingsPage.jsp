<%-- 
    Document   : settingsPage
    Created on : 15-05-2019, 10:58:25
    Author     : Mkhansen
--%>

<%@page import="data.Demand"%>
<%@page import="data.Delivery"%>
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
                <caption><b>Alle mål er i mm, og alle beløb er i kr.</b></caption>
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
                <tr><th colspan="3">Tilføj materiale</th></tr>
                <td><input name="nameChoice" type="text" value="-"></td>
                <td><input id="newMatInput" name="matNumChoice" type="number" value="0" min="0"></td>
                <td><input name="descriptionChoice" type="text" value="-"></td>
                <td><input id="newMatInput" name="lengthChoice" type="number" value="0" min="0"></td>
                <td><input id="newMatInput" name="heightChoice" type="number" value="0" min="0"></td>
                <td><input id="newMatInput" name="widthChoice" type="number"value="0" min="0"></td>
                <td><input id="newMatInput" name="priceChoice" type="number"value="0" min="0"></td>
                <td><input name="materialChoice" type="text" value="-"></td>
                <td>
                    <select name="typeChoice">
                        <% ArrayList<String> matTypes = (ArrayList<String>) session.getAttribute("allMatTypes");
                            for (int i = 0; i < matTypes.size(); i++) {
                        %>
                        <option value="<%= matTypes.get(i)%>"><%out.print(matTypes.get(i));%></option>
                        <%
                            }
                        %>
                        <option value="Ny type">Ny type</option>
                        <option><input name="newTypeChoice" type="text"></option>
                    </select>
                </td>
                <tr>
                <input type="hidden" name="command" value="CreateOrUpdateMaterial">
                <td colspan="9" ><input type="submit" onclick="alert('Materiale tilføjet')" value="Tilføj/Opdatér Materiale"></td>
            </form>
        </tr>
    </table>
    <p></p>
    <table>
        <th colspan="2">Slet materiale</th>
        <form action="Frontcontroller" method="POST">
            <tr>
                <td>Vælg varenummer
                    <select name="deleteChoice">
                        <%
                            for (int i = 0; i < allMats.size(); i++) {
                        %>
                        <option value="<%= allMats.get(i).getMatNum()%>"><%out.print(allMats.get(i).getMatNum());%></option>
                        <%
                            }
                        %>
                    </select>
                    <input type="hidden" name="command" value="DeleteMaterial">
            </tr>
            <tr>
                <td colspan="2"><input type="submit" onclick="alert('Materiale slettet')" value="Slet Materiale"></td>
        </form>
    </tr>
</table>
<p></p>
<table>
    <th colspan="2">Rediger levering</th>
    <form action="Frontcontroller" method="POST">
        <tr><th>Område</th><th>Pris</th></tr>
                <%
                    ArrayList<Delivery> deliveryList = (ArrayList<Delivery>) session.getAttribute("deliveryList");
                    for (int i = 0; i < deliveryList.size(); i++) {
                %>
        <tr>
            <td>
        <option value="<%= deliveryList.get(i).getLocation()%>"><%out.print(deliveryList.get(i).getLocation());%></option>
        </td>
        <td>
        <option value="<%= deliveryList.get(i).getPrice()%>"><%out.print(deliveryList.get(i).getPrice());%></option>
        </td>
        <%
            }
        %>
        </tr>
        <tr><th>Vælg område</th></tr>
        <tr>
            <td>
                <select name="delivery">
                    <%
                        for (int i = 0; i < deliveryList.size(); i++) {
                    %>
                    <option value="<%= deliveryList.get(i).getLocation().toString()%>"><%out.print(deliveryList.get(i).getLocation());%></option>
                    <%
                        }
                    %>
                </select>
            </td>
            <td>Ny pris
                <input type="number" name="newPrice" min="0" value="0">
                <input type="hidden" name="command" value="ChangeDelivery">
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" onclick="alert('Levering redigeret')" value="Rediger levering"></td>
    </form>
</tr>
</table>
<p></p>
<table>
    <tr><th colspan="2">Rediger lovkrav</th></tr>
    <tr><th>Lovkrav</th><th>Mål</th></tr>
    <form action="Frontcontroller" method="POST">
        <%
            ArrayList<Demand> demandsList = (ArrayList<Demand>) session.getAttribute("demandsList");
            for (int i = 0; i < demandsList.size(); i++) {
        %>
        <tr>
            <td>
        <option value="<%= demandsList.get(i).getName()%>"><%out.print(demandsList.get(i).getName());%></option>
        </td>
        <td>
        <option value="<%= demandsList.get(i).getMeasurements()%>"><%out.print(demandsList.get(i).getMeasurements());%></option>
        </td>
        <%
            }
        %>
        </tr>
        <tr><th>Vælg lovkrav</th></tr>
        <tr><td>
                <select name="demandsChoice">
                    <%
                        for (int i = 0; i < demandsList.size(); i++) {
                    %>
                    <option value="<%= demandsList.get(i).getName()%>"><%out.print(demandsList.get(i).getName());%></option>
                    <%
                        }
                    %>
                </select></td>
            <td><input type="number" name="measureChoice" value="1" min="1">
                <input type="hidden" name="command" value="ChangeDemand"></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" onclick="alert('Lovkrav ændret')" value="Rediger lovkrav">
            </td>
    </form>
</tr>
</table>
</body>
</html>
