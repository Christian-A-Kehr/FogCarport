/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Facade;
import logic.FogException;

/**
 *Used to change the price of a given delivery location in the settingsPage.jsp
 * 
 * @author Mkhansen
 */
public class ChangeDelivery extends Command {

    private Facade logic = new Facade();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        response.setContentType("text/html,charset=UTF8");
        logic.updateDeliveryPrice(request.getParameter("delivery"), Double.parseDouble(request.getParameter("newPrice")));
        return new Settings().execute(request, response);
    }

}
