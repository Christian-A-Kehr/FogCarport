<%-- 
    Document   : orderPage
    Created on : 03-05-2019, 12:41:35
    Author     : Mkhansen
--%>

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
        <link href="${pageContext.request.contextPath}/StyleSheet.css" rel="stylesheet" type="text/css"/>
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
                                <% ArrayList<Material> roofMats = (ArrayList<Material>) session.getAttribute("allRoofMats");
                                    for (int i = 0; i < roofMats.size(); i++) {
                                %>
                                <option value="<% roofMats.get(i);%>"><%out.print(roofMats.get(i).getName());%></option>
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
            <td>
                <form action="">
                    <select>
                        <% ArrayList<Material> beamMats = (ArrayList<Material>) session.getAttribute("allBeamMats");
                            for (int i = 0; i < beamMats.size(); i++) {
                        %>
                        <option value="<% beamMats.get(i);%>"><%out.print(beamMats.get(i).getName());%></option>
                        <%
                            }
                        %>
                    </select>
                </form>
            </td>            
            <td>
                <form action="">
                    <select>
                        <% ArrayList<Material> rafterMats = (ArrayList<Material>) session.getAttribute("allRafterMats");
                            for (int i = 0; i < rafterMats.size(); i++) {
                        %>
                        <option value="<% rafterMats.get(i);%>"><%out.print(rafterMats.get(i).getName());%></option>
                        <%
                            }
                        %>
                    </select>
                </form>
            </td>
            <td><input type="number" max="1000" value="0" ></td>
        </tr>
    </tbody>
</table>
<table id='shed'>
    <caption><b>Skur</b></caption>
    <tr>
        <th>Beklædning</th>
        <th>Gulv</th>
        <th>Længde</th>
        <th>Bredde</th>
    </tr>
    <tr>
        <td>                        
            <form action="">
                <select>
                    <% ArrayList<Material> shedMats = (ArrayList<Material>) session.getAttribute("allShedMats");
                        for (int i = 0; i < shedMats.size(); i++) {
                    %>
                    <option value="<% shedMats.get(i);%>"><%out.print(shedMats.get(i).getName());%></option>
                    <%
                        }
                    %>
                </select>
            </form></td>
        <td>                   
            <form action="">
                <select>
                    <% ArrayList<Material> floorMats = (ArrayList<Material>) session.getAttribute("allFloorMats");
                        for (int i = 0; i < floorMats.size(); i++) {
                            String name = floorMats.get(i).getName();
                    %>
                    <option value="<% floorMats.get(i);%>"><%out.print(floorMats.get(i).getName());%></option>
                    <%
                        }
                    %>
                </select>
            </form>
        </td>
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
<form action="Frontcontroller" method="POST">
    <input type="hidden" name="command" value="------------------">
    <input type="submit" value="BUM">
</form>
</body>
</html>
