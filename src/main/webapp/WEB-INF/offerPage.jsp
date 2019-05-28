<%-- 
    Document   : offerPage
    Created on : 08-05-2019, 14:11:31
    Author     : Mkhansen
--%>

<%@page import="data.Roof"%>
<%@page import="data.Shed"%>
<%@page import="data.Carport"%>
<%@page import="data.Material"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tilbud</title>
        <link href="${pageContext.request.contextPath}/StyleSheet.css" rel="stylesheet" type="text/css"/>
        <script src="https://unpkg.com/jspdf@latest/dist/jspdf.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/canvg/1.5/canvg.min.js"></script>
    </head>
    <body>
        <div id="pdfprint">
            <h1>Tilbud</h1>
            <h2 id="fog">FOG</h2>
            <p>Johannes Fog A/S</p>
            <p>Firskovvej 20 - 2800 Lyngby</p>
            <p>CVR-nr. 16314439</p>
            <h2>Alle mål er i mm</h2>
            
            <p><%= session.getAttribute("carportPrice")%></p>
            <p><%= session.getAttribute("calTest")%></p>
            <%--
            <table id="offerTable">
                <tr>
                    <th>Del af carport</th><th>Materiale valg</th><th>Materiale type</th><th>Meter pris</th><th>Antal</th>
                </tr>
                <tr>
                    <td>Spær</td>
                    <td><%= session.getAttribute("rafterName")%></td>
                    <td><%= session.getAttribute("rafterMat")%></td>
                    <td><%= session.getAttribute("rafterMPrice")%></td>
                    <td><%= session.getAttribute("rafterAmount")%></td>
                </tr>
                <tr>
                    <td>Rem</td>
                    <td><%= session.getAttribute("beam")%></td>
                    <td><%= session.getAttribute("beamMat")%></td>
                    <td><%= session.getAttribute("beamMPrice")%></td>
                    <td><%= session.getAttribute("beamAmount")%></td>
                </tr>
                <%--
                <tr>
                    <td>Stolper</td>
                    <td><%= session.getAttribute("woodpost")%></td>
                    <td><%= session.getAttribute("woodpostMat")%></td>
                    <td><%= session.getAttribute("woodpostMPrice")%></td>
                    <td></td>
                </tr>
            </table>
            
            <p> Test yO <%= session.getAttribute("test")%></p>
            <p> Test yO <%= session.getAttribute("test2")%></p>
            <p> RafterTest yO mPrice <% out.print(session.getAttribute("rafterTest")); %></p>
            <p> RafterTest yO totalprice <% out.print(session.getAttribute("rafterTest2")); %></p>
            <p> RafterTest yO amount <% out.print(session.getAttribute("rafterTest3")); %></p>
            
            <p> ShedTest -- getFloor <% out.print(session.getAttribute("shedTest1")); %></p>
            <p> ShedTest -- getFloor.getMaterial <% out.print(session.getAttribute("shedTest2")); %></p>
            <p> ShedTest -- getFloor.getPrice <% out.print(session.getAttribute("shedTest3")); %></p>
            <p> ShedTest -- getFloor.getAmount <% out.print(session.getAttribute("shedTest4")); %></p>
                --%>
            
            <%--
            <% Carport carp = (Carport) session.getAttribute("carport"); %>
            <% Shed shed = (Shed) session.getAttribute("shed"); %>
            <% Roof roof = (Roof) session.getAttribute("roof");%>
            <p>1 Carport højde YOOOOOOO = <%= carp.getHeight()%></p>
            <p>2 Carport Med/Uden rejsning YOOOOOOO = <%= carp.getRoof().getType()%></p>
            <p>4 skur bredde YOOOOOOO = <%= shed.getWidth()%></p>
            <p>5 Skur dybde YOOOOOOO = <%= shed.getDepth()%> </p>
            <p>5 Skur dybde YOOOOOOO = <%= carp.getShed().getDepth()%> </p>
            <p>6 Skur pris YOOOOOOO = ${shed.getFloor().getprice()}</p>
            <p>7 Skur beklædning pris YOOOOOOO =  <%= carp.getShed().getWallCovering().getPrice()%> </p>
            <p>8 Skur  pris YOOOOOOO =  <%= carp.getShed().getWallCovering().getAmount()%> </p>
            <p>9 Skur totalpris YOOOOOOO =  <%= carp.getShed().getWallCovering().getTotalPrice()%> </p>
             --%>
             <%--
            <p>Højde = <%= request.getParameter("height")%> </p>
            <p>Længde = <%= request.getParameter("length")%> </p>
            <p>Bredde = <%= request.getParameter("width")%> </p>
            <p>Med/Uden rejsning = <%= request.getParameter("flatOrNot")%> </p>
            <p>Tag materiale = <%= request.getParameter("rooftileChoice")%> </p>
            <p>Stolpe materiale = <%= request.getParameter("woodpostChoice")%> </p>
            <p>Valg af grader = <%= request.getParameter("angleChoice")%> </p>
            <p>Rem materiale = <%= request.getParameter("beamChoice")%> </p>
            <p>Spær materiale = <%= request.getParameter("rafterChoice")%> </p>
            <p>Spær afstand = <%= request.getParameter("rafterDistChoice")%> </p>
            <% Material mat = (Material) session.getAttribute("rafter");%>
            <p>Spær ID = <%= mat.getMatNum()%> </p>
            <p>*spærID = <%= mat.getName()%></p>

            <p>** ${rafter.matNum}</p>
            <p>** ${rafter.name}</p>
            <p>Skur materiale = <%= request.getParameter("shedChoice")%> </p>
            <p>Skur dybde = <%= request.getParameter("shedDepth")%> </p>
            <p>Skur bredde = <%= request.getParameter("shedWidth")%> </p>
            <p>Valg af gulv = <%= request.getParameter("floorChoice")%> </p>
            <p>Levering = <%= request.getParameter("delivery")%> </p>
            <p>Kunde navn = <%= request.getParameter("customerName")%> </p>
            <p>Kunde email = <%= request.getParameter("customerEmail")%> </p>
            --%>
        </div>

        <input type="button" id="printbutton" value="Gem tilbud">   

        <script>
            //alert("running script");
            //SAVE DOCUMENT
            document.getElementById("printbutton").addEventListener("click", function () {
                doc.save('pdffile.pdf');
            });
            //CREATE PDF DOCUMENT
            var doc = new jsPDF('p', 'pt', 'a4');

            //ADD HTML CONTENT
            doc.fromHTML(document.getElementById('pdfprint').innerHTML, 15, 15, {'width': 500});

            //ADD NEW PAGE
            doc.addPage();

            //ADD SVG / IMAGE CONTENT
            <%--        var svg = document.getElementById('svgdrawing').outerHTML;
            var canvas = document.createElement('canvas');
            canvas.width = 100;
            canvas.height = 100;
            var ctx = canvas.getContext('2d');
            ctx.drawSvg(svg, 0, 0, 100, 100);
            var imageData = canvas.toDataURL('image/png');
            doc.addImage(imageData, 'PNG', 15, 100, 500, 500); --%>

            //ADD TEXT
            //doc.text(20, 20, 'Hello world AGAIN!!!');

            //ADD IMAGE AGAIN
            //doc.addImage(imageData, 'PNG', 15, 100, 500, 500);

        </script>
    </body>
</html>

