/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.Beam;
import data.Carport;
import data.Delivery;
import data.Floor;
import data.Material;
import data.Rafter;
import data.Roof;
import data.Rooftile;
import data.Shed;
import data.WallCovering;
import data.WoodPost;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Assemble;
import logic.Calculate;
import logic.Facade;
import logic.FogException;

/**
 *
 * @author Mkhansen
 */
public class CreateOffer extends Command {

    private Facade logic = new Facade();
    private Assemble assemble = new Assemble();
    private Calculate cal = new Calculate();

    /**
     * Handles userInput from orderPage.jsp and processes it to create an offer or a list of materials needed.
     * @param request
     * @param response
     * @return jsp page depending on which button is pressed on the orderPage
     * @throws FogException 
     */
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        try {

            String roofType = request.getParameter("flatOrNot");
            int height = Integer.parseInt(request.getParameter("height"));
            int length = Integer.parseInt(request.getParameter("length"));
            int width = Integer.parseInt(request.getParameter("width"));
            int shedWidth = Integer.parseInt(request.getParameter("shedDepth"));
            int shedDepth = Integer.parseInt(request.getParameter("shedWidth"));
            int angle = Integer.parseInt(request.getParameter("angleChoice"));

            int rooftileID = Integer.parseInt(request.getParameter("rooftileChoice"));
            int rafterID = Integer.parseInt(request.getParameter("rafterChoice"));
            int beamID = Integer.parseInt(request.getParameter("beamChoice"));
            int woodPostID = Integer.parseInt(request.getParameter("woodpostChoice"));
            int floorID = Integer.parseInt(request.getParameter("floorChoice"));
            int wallCoveringID = Integer.parseInt(request.getParameter("wallcoveringChoice"));

            Material rafterMat = logic.getMaterialFromId(rafterID);
            Rafter rafter = new Rafter(rafterMat.getMaterial(), width, rafterID);

            Material beamMat = logic.getMaterialFromId(beamID);
            Beam beam = new Beam(beamMat.getMaterial(), length, beamID);

            Material woodpostMat = logic.getMaterialFromId(woodPostID);
            WoodPost woodpost = new WoodPost(woodpostMat.getMaterial(), height, woodPostID);

            Material floorMat = logic.getMaterialFromId(floorID);
            Floor floor = new Floor(floorMat.getMaterial(), shedDepth, shedWidth, floorID);

            Material wallCoveringMat = logic.getMaterialFromId(wallCoveringID);
            WallCovering wallCovering = new WallCovering(wallCoveringMat.getMaterial(), height, wallCoveringMat.getWidth(), wallCoveringID);

            Material rooftileMat = logic.getMaterialFromId(rooftileID);
            Rooftile rooftile = new Rooftile(rooftileMat.getMaterial(), rooftileMat.getLength(), rooftileMat.getWidth(), rooftileID);

            session.setAttribute("rooftile", rooftileMat);
            session.setAttribute("rafter", rafterMat);
            session.setAttribute("rafterName", rafterMat.getName());
            session.setAttribute("beam", beamMat.getName());
            session.setAttribute("woodpost", woodpostMat.getName());
            session.setAttribute("floor", floorMat.getName());
            session.setAttribute("wallCovering", wallCoveringMat.getName());

            Shed shed = new Shed(shedDepth, shedWidth, wallCovering, floor);

            Roof roof = new Roof(roofType, angle, length, width, beam, rafter, woodpost, rooftile);

            Carport carport = new Carport(height, length, width, roof, shed);

            Rafter fullRafter = (Rafter) assemble.createRafter(carport);
            Beam fullBeam = (Beam) assemble.createBeam(carport);
            WoodPost fullWoodpost = (WoodPost) assemble.createWoodpost(carport);
            Floor fullFloor = (Floor) assemble.createFloor(shed);
            WallCovering fullWallCovering = (WallCovering) assemble.createWallcover(carport);
            Shed fullShed = (Shed) assemble.createShed(carport);
            Roof fullRoof = (Roof) assemble.createRoof(carport);
            Carport fullCarport = (Carport) assemble.AssembleCarport(carport);

            session.setAttribute("carportPrice", cal.CalculateCarport(fullCarport).get("Carport"));
            session.setAttribute("shedPrice", cal.CalculateCarport(fullCarport).get("ShedPrice"));
            session.setAttribute("roofPrice", cal.CalculateCarport(fullCarport).get("RoofPrice"));

            Delivery delivery = (Delivery) logic.getDelivery(request.getParameter("delivery"));
            double totalPrice = delivery.getPrice() + cal.CalculateCarport(fullCarport).get("CarportPrice");
            session.setAttribute("deliveryPrice", delivery.getPrice());
            session.setAttribute("totalPrice", totalPrice);

            session.setAttribute("rafterMPrice", fullCarport.getRoof().getRafter().getMprice());
            session.setAttribute("rafterMat", fullRafter.getMaterial());
            session.setAttribute("rafterAmount", fullRafter.getAmount());
            session.setAttribute("rafterDesc", rafterMat.getDesc());
            session.setAttribute("rafterTotalPrice", fullCarport.getRoof().getRafter().getTotalPrice());

            session.setAttribute("beamMPrice", fullCarport.getRoof().getBeam().getPrice());
            session.setAttribute("beamMat", fullBeam.getMaterial());
            session.setAttribute("beamAmount", fullBeam.getAmount());
            session.setAttribute("beamDesc", beamMat.getDesc());
            session.setAttribute("beamTotalPrice", fullCarport.getRoof().getBeam().getTotalPrice());

            session.setAttribute("woodpostMPrice", fullCarport.getRoof().getWoodpost().getPrice());
            session.setAttribute("woodpostMat", fullWoodpost.getMaterial());
            session.setAttribute("woodpostAmount", fullWoodpost.getAmount());
            session.setAttribute("woodpostDesc", woodpostMat.getDesc());
            session.setAttribute("woodpostTotalPrice", fullCarport.getRoof().getWoodpost().getTotalPrice());

            session.setAttribute("wallcoveringMPrice", fullCarport.getShed().getWallCovering().getPrice());
            session.setAttribute("wallcoveringMat", fullWallCovering.getMaterial());
            session.setAttribute("wallcoveringAmount", fullWallCovering.getAmount());
            session.setAttribute("wallcoveringDesc", wallCoveringMat.getDesc());
            session.setAttribute("wallcoveringTotalPrice", fullCarport.getShed().getWallCovering().getTotalPrice());

            session.setAttribute("floorPrice", fullCarport.getShed().getFloor().getPrice());
            session.setAttribute("floorMat", fullFloor.getMaterial());
            session.setAttribute("floorAmount", fullFloor.getAmount());
            session.setAttribute("floorDesc", floorMat.getDesc());
            session.setAttribute("floorTotalPrice", fullCarport.getShed().getFloor().getTotalPrice());


            session.setAttribute("carport", assemble.AssembleCarport(carport));
            session.setAttribute("roof", assemble.createRoof(carport));
            session.setAttribute("shed", assemble.createShed(carport));

        } catch (Exception ex) {
            ex.getMessage();
//            return "orderPage";
        }
        if (request.getParameter("path").equals("Se stykliste")) {
            return "listOfMaterialsPage";
        }
        return "offerPage";
    }
}
