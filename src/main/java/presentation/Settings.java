/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.Facade;
import logic.FogException;

/**
 *
 * @author Mkhansen
 */
public class Settings extends Command {

    private Facade logic = new Facade();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        HttpSession session = request.getSession();
        
        session.setAttribute("allMatTypes", logic.getMaterialType());
        session.setAttribute("allMats", logic.getAllMaterials());
        session.setAttribute("deliveryList", logic.getDeliveryLocations());
        session.setAttribute("demandsList", logic.getAllDemands());
        
        return "settingsPage";
    }

}
