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
            
            <table id="offerTable">
                <tr>
                    <th>Del af carport</th><th>Materiale valg</th><th>Yderligere info</th><th>Materiale type</th><th>Vare nummer</th><th>Antal</th>
                </tr>
                <tr><th id="greyth">Tag</th><td colspan="5"></td></tr>
                <tr>
                    <td>Spær</td>
                    <td><%= session.getAttribute("rafterName")%></td>
                    <td><%= session.getAttribute("rafterDesc")%></td>
                    <td><%= session.getAttribute("rafterMat")%></td>
                    <td><%= request.getParameter("rafterChoice")%></td>
                    <td><%= session.getAttribute("rafterAmount")%></td>
                </tr>
                <tr>
                    <td>Rem</td>
                    <td><%= session.getAttribute("beam")%></td>
                    <td><%= session.getAttribute("beamDesc")%></td>
                    <td><%= session.getAttribute("beamMat")%></td>
                    <td><%= request.getParameter("beamChoice")%></td>
                    <td><%= session.getAttribute("beamAmount")%></td>
                </tr>
                <tr>
                    <td>Stolper</td>
                    <td><%= session.getAttribute("woodpost")%></td>
                    <td><%= session.getAttribute("woodpostDesc")%></td>
                    <td><%= session.getAttribute("woodpostMat")%></td>
                    <td><%= request.getParameter("woodpostChoice")%></td>
                    <td><%= session.getAttribute("woodpostAmount")%></td>
                </tr>
                <tr><th id="greyth">Skur</th></tr>
                 <tr>
                    <td>Brædde beklædning</td>
                    <td><%= session.getAttribute("wallCovering")%></td>
                    <td><%= session.getAttribute("wallcoveringDesc")%></td>
                    <td><%= session.getAttribute("wallcoveringMat")%></td>
                    <td><%= request.getParameter("wallcoveringChoice")%></td>
                    <td><%= session.getAttribute("wallcoveringAmount")%></td>
                </tr>
                <tr>
                    <td>Gulv</td>
                    <td><%= session.getAttribute("floor")%></td>
                    <td><%= session.getAttribute("floorDesc")%></td>
                    <td><%= session.getAttribute("floorMat")%></td>
                    <td><%= request.getParameter("floorChoice")%></td>
                    <td><%= session.getAttribute("floorAmount")%></td>
                </tr>
            </table>
        </div>

        <input type="button" id="printbutton" value="Gem eller åben stykliste som pdf">   

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