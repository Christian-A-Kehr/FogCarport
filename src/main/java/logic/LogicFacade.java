/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.DataAccessor;
import data.Material;

/**
 *
 * @author Christian Ambjørn Kehr
 */
public class LogicFacade {
    public static void main(String[] args) {
        LogicFacade logic = new LogicFacade();
        logic.getMaterialLogic();
    }
    
    public String getMaterialLogic(){
        DataAccessor data = new DataAccessor();
        String Material = "stuff";
        System.out.println(data.getMaterial("test"));
        return Material;
    }
}
