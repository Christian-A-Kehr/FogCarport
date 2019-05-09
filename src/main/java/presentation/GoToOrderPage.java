/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.Material;
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
public class GoToOrderPage extends Command {
    private Facade logic = new Facade();
    private ArrayList<Material> chosenMats = new ArrayList<>();
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        
        session.setAttribute("allRoofMats", logic.getListSpecificMaterials("Tagsten"));
        session.setAttribute("allRafterMats", logic.getListSpecificMaterials("Spær"));
        session.setAttribute("allShedMats", logic.getListSpecificMaterials("Beklædning"));
        session.setAttribute("allFloorMats", logic.getListSpecificMaterials("Gulv"));
        session.setAttribute("allWoodpostMats", logic.getListSpecificMaterials("Stolpe"));
        session.setAttribute("allBeamMats", logic.getListSpecificMaterials("Rem"));
        session.setAttribute("chosenMats", chosenMats);
        return "orderPage";
    }
}
