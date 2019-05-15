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
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Facade;
import logic.FogException;

/**
 *
 * @author Mkhansen
 */
public class CreateOffer extends Command {

    private Facade logic = new Facade();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
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

        Material beamMat = logic.getMaterialFromId(beamID);
        Beam beam = new Beam(beamMat.getMaterial(), length, beamID);

        Material woodPostMat = logic.getMaterialFromId(woodPostID);
        WoodPost woodpost = new WoodPost(woodPostMat.getMaterial(), height, woodPostID);

        Material floorMat = logic.getMaterialFromId(floorID);
        Floor floor = new Floor(floorMat.getMaterial(), shedDepth, shedWidth, floorID);

        Material wallCoveringMat = logic.getMaterialFromId(wallCoveringID);
        WallCovering wallCovering = new WallCovering(wallCoveringMat.getMaterial(), height, shedDepth, shedWidth);
        
        Material rooftileMat = logic.getMaterialFromId(rooftileID);
        Rooftile rooftile = new Rooftile(rooftileMat.getMaterial(), rooftileMat.getLength(), rooftileMat.getWidth(), rooftileID);
        
        session.setAttribute("rooftile", rooftileMat);
        session.setAttribute("rafter", rafterMat);
        session.setAttribute("beam", beamMat);
        session.setAttribute("woodPost", woodPostMat);
        session.setAttribute("floor", floorMat);
        session.setAttribute("wallCovering", wallCoveringMat);

        Shed shed = new Shed(shedDepth, shedWidth, wallCovering, floor);

        Roof roof = new Roof(request.getParameter("flatOrNot"), angle, length, width, beam, rafter, woodpost, rooftile);

        Carport carport = new Carport(height, length, width, roof, shed);
        
        return "offerPage";
    }
}
