/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.DataAccessor;
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
    private DataAccessor dataAccess = new DataAccessor();
    private Facade logic = new Facade();
    
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        session.setAttribute("allRoofMats", dataAccess.GetListSpecificMaterials("Tagsten"));
        session.setAttribute("allRafterMats", dataAccess.GetListSpecificMaterials("Spær"));
        session.setAttribute("allShedMats", dataAccess.GetListSpecificMaterials("Beklædning"));
        session.setAttribute("allFloorMats", dataAccess.GetListSpecificMaterials("Gulv"));
        session.setAttribute("allWoodpostMats", dataAccess.GetListSpecificMaterials("Stolpe"));
        session.setAttribute("allBeamMats", dataAccess.GetListSpecificMaterials("Rem"));

//        session.setAttribute("allRoofMats", logic.GetListSpecificMaterials("Tagsten"));
//        session.setAttribute("allRafterMats", logic.GetListSpecificMaterials("Spær"));
//        session.setAttribute("allShedMats", logic.GetListSpecificMaterials("Beklædning"));
//        session.setAttribute("allFloorMats", logic.GetListSpecificMaterials("Gulv"));
//        session.setAttribute("allWoodpostMats", logic.GetListSpecificMaterials("Stolpe"));
//        session.setAttribute("allBeams", logic.GetListSpecificMaterials("Rem"));
        return "orderPage";
    }
}
