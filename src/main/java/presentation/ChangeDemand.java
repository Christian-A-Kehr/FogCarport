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
 *
 * @author Mkhansen
 */
public class ChangeDemand extends Command {

    private Facade logic = new Facade();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        response.setContentType("text/html,charset=UTF8");
        logic.updateDemandVariables(request.getParameter("demandsChoice"), Integer.parseInt(request.getParameter("measureChoice")));
        return new Settings().execute(request, response);
    }

}
