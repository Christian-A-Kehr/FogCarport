<%-- 
    Document   : listOfMaterialsPage
    Created on : 16-05-2019, 11:10:07
    Author     : Mkhansen
--%>
<%@page import="data.Material"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Stykliste</title>
        <link href="${pageContext.request.contextPath}/StyleSheet.css" rel="stylesheet" type="text/css"/>
        <script src="https://unpkg.com/jspdf@latest/dist/jspdf.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/canvg/1.5/canvg.min.js"></script>
    </head>
    <body>
        <div id="pdfprint">
            <h1>Stykliste</h1>
            <h2 id="fog">FOG</h2>
            <p>Johannes Fog A/S</p>
            <p>Firskovvej 20 - 2800 Lyngby</p>
            <p>CVR-nr. 16314439</p>
            <h2>Alle mål er i mm</h2>

            <p>Højde = <%= request.getParameter("height")%> </p>
            <p>Længde = <%= request.getParameter("length")%> </p>
            <p>Bredde = <%= request.getParameter("width")%> </p>
            <p>Med/Uden rejsning = <%= request.getParameter("flatOrNotChoice")%> </p>
            <p>Tag materiale = <%= request.getParameter("roofChoice")%> </p>
            <p>Stolpe materiale = <%= request.getParameter("woodpostChoice")%> </p>
            <p>Valg af grader = <%= request.getParameter("angleChoice")%> </p>
            <p>Rem materiale = <%= request.getParameter("beamChoice")%> </p>
            <p>Spær materiale = <%= request.getParameter("raft")%> </p>
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