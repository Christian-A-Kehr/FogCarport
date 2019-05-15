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





                <tr>
                <input type="hidden" name="command" value="CreateNewMaterial">
                <input type="submit" onclick="alert('Materiale tilføjet')" value="Tilføj Materiale">
            </form>
        </tr>
    </table>

    <table>
        <form action="Frontcontroller" method="POST">
            <th>WOHOOOOO 2</th>
            <input type="hidden" name="command" value="UpdateMaterial">
            <input type="submit" onclick="alert('Materiale opdatéret')" value="Opdatér Materiale">
        </form>
    </table>
</table>


<table>
    <form action="Frontcontroller" method="POST">
        <th>WOHOOOOO 3</th>
        <input type="hidden" name="command" value="DeleteMaterial">
        <input type="submit" onclick="alert('Materiale slettet')" value="Slet Materiale">
    </form>
</table>
</table>
</body>
</html>
