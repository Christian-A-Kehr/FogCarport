/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.Beam;
import data.Carport;
import data.Floor;
import data.Rafter;
import data.Roof;
import data.Shed;
import data.WallCoverings;
import data.WoodPost;
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
//        session.setAttribute("chosenMats", ArrayList<>());
//        request.getParameter("chosenMats");

//        WallCoverings wallCoverings = new WallCoverings(request.getParameter() );
//        Floor floor = new Floor();
//        Shed shed = new Shed(request.getParameter("shedDepth"),request.getParameter("shedWidth"),wallCoverings ,floor);
//        Beam beam = new Beam(request.getParameter("beam"));
//        Rafter rafter = new Rafter();
//        WoodPost woodPost = new WoodPost();
//        Roof roof = new Roof();
//        Carport carport = new Carport();
        
        System.out.println(request.getParameter("flatOrNotChoice"));
        System.out.println(request.getParameter("chosenMats"));
        session.getAttribute("chosenMats");
        session.setAttribute("chosenMats", request.getParameter("chosenMats"));

        return "test";
    }
}
