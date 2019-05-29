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
            <div id="fogInfo">
                <p>Johannes Fog A/S</p>
                <p>Firskovvej 20 - 2800 Lyngby</p>
                <p>CVR-nr. 16314439</p>
            </div>
            <h2></h2>

            <p> Kunde information <%= request.getParameter("customerName")%> -- <%= request.getParameter("customerEmail")%></p>
            <table id="offerTable">
                <tr>
                    <th>Del af carport</th><th>Materiale valg</th><th>Materiale type</th><th>Total pris</th>
                </tr>
                <tr><th id="greyth">Tag</th><td colspan="5"></td></tr>
                <tr>
                    <td>Spær</td>
                    <td><%= session.getAttribute("rafterName")%></td>
                    <td><%= session.getAttribute("rafterMat")%></td>
                    <td><%= session.getAttribute("rafterTotalPrice")%></td>
                </tr>
                <tr>
                    <td>Rem</td>
                    <td><%= session.getAttribute("beam")%></td>
                    <td><%= session.getAttribute("beamMat")%></td>
                    <td><%= session.getAttribute("beamTotalPrice")%></td>
                </tr>
                <tr>
                    <td>Stolper</td>
                    <td><%= session.getAttribute("woodpost")%></td>
                    <td><%= session.getAttribute("woodpostMat")%></td>
                    <td><%= session.getAttribute("woodpostTotalPrice")%></td>
                </tr>
                <tr><th id="greyth">Skur</th></tr>
                <tr>
                    <td>Brædde beklædning</td>
                    <td><%= session.getAttribute("wallCovering")%></td>
                    <td><%= session.getAttribute("wallcoveringMat")%></td>
                    <td><%= session.getAttribute("wallcoveringTotalPrice")%></td>
                </tr>
                <tr>
                    <td>Gulv</td>
                    <td><%= session.getAttribute("floor")%></td>
                    <td><%= session.getAttribute("floorMat")%></td>
                    <td><%= session.getAttribute("floorTotalPrice")%></td>
                </tr>
                <tr>
                    <td colspan="2" rowspan="3"></td><td>Total pris for carport</td><td><%= session.getAttribute("carportPrice")%></td>
                </tr>
                <tr>
                    <td>Leverings omkostninger til <%= request.getParameter("delivery")%></td><td><%= session.getAttribute("deliveryPrice")%></td>
                </tr>
                <tr>
                    <td>I alt</td><td><%= session.getAttribute("totalPrice")%></td>
                </tr>
            </table>
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

