/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import data.Material;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.Facade;
import logic.FogException;

/**
 *
 * @author Mkhansen
 */
public class CreateOrUpdateMaterial extends Command {

    private Facade logic = new Facade();

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws FogException {
        String name = request.getParameter("nameChoice");
        String desc = request.getParameter("descriptionChoice");
        String material = request.getParameter("materialChoice");
        String type = request.getParameter("typeChoice");
        int matNum = Integer.parseInt(request.getParameter("matNumChoice"));
        int length = Integer.parseInt(request.getParameter("lengthChoice"));
        int height = Integer.parseInt(request.getParameter("heightChoice"));
        int width = Integer.parseInt(request.getParameter("widthChoice"));
        double price = Double.parseDouble(request.getParameter("priceChoice"));

        logic.saveMaterial(new Material(name, desc, material, type, matNum, length, height, width, price));
        
        return new Settings().execute(request, response);
    }

}
