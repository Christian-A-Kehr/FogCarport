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
import logic.FogException;

/**
 *
 * @author Mkhansen
 */
public class GoToOrderPage extends Command {
    private DataAccessor dataAccess = new DataAccessor();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        session.setAttribute("allRoofMats", dataAccess.GetListSpecificMaterials("Tagsten"));
        
        return "orderPage";
    }

}
