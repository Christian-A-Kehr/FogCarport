/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.Beam;
import data.Carport;
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
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        try {

            String roofType = request.getParameter("flatOrNot");
            int height = Integer.parseInt(request.getParameter("height"));
            int length = Integer.parseInt(request.getParameter("height"));
            int width = Integer.parseInt(request.getParameter("height"));
            int shedWidth = Integer.parseInt(request.getParameter("shedDepth"));
            int shedDepth = Integer.parseInt(request.getParameter("shedWidth"));
            int angle = Integer.parseInt(request.getParameter("angleChoice"));

            int rooftileID = Integer.parseInt(request.getParameter("rooftileChoice"));
            int rafterID = Integer.parseInt(request.getParameter("rafterChoice"));
            int beamID = Integer.parseInt(request.getParameter("beamChoice"));
            int woodPostID = Integer.parseInt(request.getParameter("woodpostChoice"));
            int floorID = Integer.parseInt(request.getParameter("floorChoice"));
            int wallCoveringID = Integer.parseInt(request.getParameter("shedChoice"));

            Material rafterMat = logic.getMaterialFromId(rafterID);
            Rafter rafter = new Rafter(rafterMat.getMaterial(), width, rafterID);
//            Rafter rafter = new Rafter(rafterMat.getMaterial(), width, rafterMat.getHeight(), rafterMat.getWidth(), rafterID, amount, price, totalprice);
//            String material, int lenght, int height, int thickness, int id, int amount, double price, double totalPrice

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
            session.setAttribute("wallCovering", wallCoveringMat);

            Shed shed = new Shed(shedDepth, shedWidth, wallCovering, floor);

            Roof roof = new Roof(roofType, angle, length, width, beam, rafter, woodpost, rooftile);
            
            Carport carport = new Carport(height, length, width, roof, shed);
            
            Rafter rafterOff = (Rafter) assemble.createRafter(carport);
            Beam beamOff = (Beam) assemble.createBeam(carport);
            WoodPost woodpostOff = (WoodPost) assemble.createWoodpost(carport);
            Floor floorOff = (Floor) assemble.createFloor(shed);
            Carport carp = (Carport) assemble.AssembleCarport(carport);
            Shed shedTest = (Shed) assemble.createShed(carport);
            
//            session.setAttribute("carportPrice", logic.CalCarport(carport).get("Carport "));
//            session.setAttribute("shedPrice", logic.CalCarport(carport).get("ShedPrice "));
//            session.setAttribute("roofPrice", logic.CalCarport(carport).get("RoofPrice "));

            session.setAttribute("rafterMPrice", carp.getRoof().getRafter().getMprice());
            session.setAttribute("rafterMat", rafterOff.getMaterial());
            session.setAttribute("rafterAmount", rafterOff.getAmount());
            session.setAttribute("rafterDesc", rafterMat.getDesc());

            session.setAttribute("beamMPrice", carp.getRoof().getBeam().getPrice());
            session.setAttribute("beamMat", beamOff.getMaterial());
            session.setAttribute("beamAmount", beamOff.getAmount());
            session.setAttribute("beamDesc", beamMat.getDesc());

            session.setAttribute("woodpostMPrice", carp.getRoof().getWoodpost().getPrice());
            session.setAttribute("woodpostMat", woodpostOff.getMaterial());
            session.setAttribute("woodpostAmount", woodpostOff.getAmount());
            session.setAttribute("woodpostDesc", woodpostMat.getDesc());

            session.setAttribute("floorPrice", carp.getShed().getFloor().getPrice());
            session.setAttribute("floorMat", floorOff.getMaterial());
            session.setAttribute("floorAmount", floorOff.getAmount());
            session.setAttribute("floorDesc", floorMat.getDesc());

            
            
            session.setAttribute("rafterTest2", rafterOff.getTotalPrice());
            session.setAttribute("test", carp.getHeight());
            session.setAttribute("test2", carp.getRoof().getBeam().getMaterial());
            session.setAttribute("shedTest1", carp.getShed().getFloor());
            session.setAttribute("shedTest2", shedTest.getFloor().getMaterial());
            session.setAttribute("shedTest3", shedTest.getFloor().getprice());
            session.setAttribute("shedTest4", shedTest.getFloor().getAmount());

            session.setAttribute("carport", assemble.AssembleCarport(carport));
            session.setAttribute("roof", assemble.createRoof(carport));
            session.setAttribute("shed", assemble.createShed(carport));
            
            session.setAttribute("calTest", cal.WooPostTotalPrice(carport));

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
