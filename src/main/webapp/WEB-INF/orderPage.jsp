<%-- 
    Document   : orderPage
    Created on : 03-05-2019, 12:41:35
    Author     : Mkhansen
--%>

<%@page import="data.Delivery"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.Material"%>
<%@page import="data.Material"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Bestilling</title>
        <link href="${pageContext.request.contextPath}/StyleSheet.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h2>Bestilling</h2>
        <h3>Alle mål er i mm</h3>
        <form action="Frontcontroller" name="chosenMats" method="POST">
            <table>
                <caption><b>Carport dimensioner</b></caption>
                <tr>
                    <th>Højde</th>
                    <th>Længde</th>
                    <th>Bredde</th>
                </tr>
                <tr>
                    <td><input type="number" name="height" min="2100" value="2100" ></td>
                    <td><input type="number" name="length" min="0" value="0" ></td>
                    <td><input type="number" name="width" min="0" value="0" ></td>
                </tr>
            </table>
            <table id="shed">
                <caption><b>Tag</b></caption>
                <tr>
                    <th>Med rejsning?</th>
                    <th>Tag materiale valg</th>
                    <th>Stolpe materiale valg</th>
                    <th>Grader</th>
                </tr>
                <tbody>
                    <tr>
                        <td>
                            <input type="radio" name="flatOrNot" value="Med rejsning"> Ja
                            <input type="radio" name="flatOrNot" value="Uden rejsning"> Nej
                        </td>

                        <td>
                            <select name="rooftileChoice">
                                <% ArrayList<Material> roofMats = (ArrayList<Material>) session.getAttribute("allRoofMats");
                                    for (int i = 0; i < roofMats.size(); i++) {
                                %>
                                <option value="<%= roofMats.get(i).getMatNum()%>"><%out.print(roofMats.get(i).getName());%></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                        <td>
                            <select name="woodpostChoice">
                                <% ArrayList<Material> woodpostMats = (ArrayList<Material>) session.getAttribute("allWoodpostMats");
                                    for (int i = 0; i < woodpostMats.size(); i++) {
                                %>
                                <option value="<%= woodpostMats.get(i).getMatNum()%>"><%out.print(woodpostMats.get(i).getName());%></option>
                                <%
                                    }
                                %>
                            </select>
                        </td>
                        <td><input name="angleChoice" type="number" min="3" max="15" value="3" ></td>
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
                    <select name="beamChoice">
                        <% ArrayList<Material> beamMats = (ArrayList<Material>) session.getAttribute("allBeamMats");
                            for (int i = 0; i < beamMats.size(); i++) {
                        %>
                        <option value="<%= beamMats.get(i).getMatNum()%>"><%out.print(beamMats.get(i).getName());%></option>
                        <%
                            }
                        %>
                    </select>
                </td>            
                <td>
                    <select name="rafterChoice">
                        <% ArrayList<Material> rafterMats = (ArrayList<Material>) session.getAttribute("allRafterMats");
                            for (int i = 0; i < rafterMats.size(); i++) {
                        %>
                        <option value="<%= rafterMats.get(i).getMatNum()%>"><%out.print(rafterMats.get(i).getName());%></option>
                        <%
                            }
                        %>
                    </select>
                </td>
                <td><input name="rafterDistChoice" type="number" max="1000" value="0" ></td>
                </tr>
                </tbody>
            </table>
            <table id='shed'>
                <caption><b>Skur</b></caption>
                <tr>
                    <th>Beklædning</th>
                    <th>Gulv</th>
                    <th>Dybde</th>
                    <th>Bredde</th>
                </tr>
                <tr>
                    <td>                        
                        <select name="shedChoice">
                            <% ArrayList<Material> shedMats = (ArrayList<Material>) session.getAttribute("allShedMats");
                                for (int i = 0; i < shedMats.size(); i++) {
                            %>
                            <option value="<%= shedMats.get(i).getMatNum()%>"><%out.print(shedMats.get(i).getName());%></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                    <td>                   
                        <select name="floorChoice">
                            <% ArrayList<Material> floorMats = (ArrayList<Material>) session.getAttribute("allFloorMats");
                                for (int i = 0; i < floorMats.size(); i++) {
                            %>
                            <option value="<%= floorMats.get(i).getMatNum()%>"><%out.print(floorMats.get(i).getName());%></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                    <td><input name="shedDepth" type="number" min="0" value="0" ></td>
                    <td><input name="shedWidth" type="number" min="0" value="0" ></td>
                </tr>
            </table>
            <table>
                <caption><b>Kunde information</b></caption>
                <tr>
                    <th>Navn</th>
                    <th>Email</th>
                    <th>Levering til?</th>
                </tr>
                <tr>
                    <td><input name="customerName" type="text"></td>
                    <td><input name="customerEmail" type="text"></td>
                    <td>
                        <select name="delivery">
                            <% ArrayList<Delivery> deliveryList = (ArrayList<Delivery>) session.getAttribute("deliveryList");
                                for (int i = 0; i < deliveryList.size(); i++) {
                            %>
                            <option value="<%= deliveryList.get(i).getLocation() %>"><%out.print(deliveryList.get(i).getLocation());%></option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="hidden" name="command" value="CreateOffer">
            <input type="submit" name="path" value="Opret tilbud">
            <input type="submit" name="path" value="Se stykliste">
        </form>
    </body>
</html>
