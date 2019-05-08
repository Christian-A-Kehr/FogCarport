/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.FogException;


/**
 *
 * @author Mkhansen
 */
public class CreateOffer extends Command{
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        session.setAttribute("chosenMats", new ArrayList<>());
        session.getAttribute("chosenRoofMats");
        
        
        
        
        
        
        session.setAttribute("allRoofMats", logic.getListSpecificMaterials("Tagsten"));
        session.setAttribute("allRafterMats", logic.getListSpecificMaterials("Spær"));
        session.setAttribute("allShedMats", logic.getListSpecificMaterials("Beklædning"));
        session.setAttribute("allFloorMats", logic.getListSpecificMaterials("Gulv"));
        session.setAttribute("allWoodpostMats", logic.getListSpecificMaterials("Stolpe"));
        session.setAttribute("allBeamMats", logic.getListSpecificMaterials("Rem"));
        
        return "";
    }
    
}
