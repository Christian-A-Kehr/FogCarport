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
public class DeleteMaterial extends Command {

    private Facade logic = new Facade();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        logic.dropMaterial(Integer.parseInt(request.getParameter("deleteChoice")));
        
        return new Settings().execute(request, response);
    }

}
