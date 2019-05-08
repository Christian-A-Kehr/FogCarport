/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.DataAccessor;
import data.Material;
import java.util.ArrayList;

/**
 *
 * @author Christian Ambjørn Kehr
 */
public class Facade {
      DataAccessor data = new DataAccessor();
     
    public static void main(String[] args) {
        Facade logic = new Facade();
        //logic.getMaterialLogic();
        logic.getAllMatrials();
        
    }
    
    public ArrayList<Material> getAllMatrials(){
        ArrayList list = new ArrayList(data.getAllMaterials());
        System.err.println(list);
        
        return list;
    }
    public ArrayList<Material> getListSpecificMaterials(String type){
        return data.getListSpecificMaterials(type);
    }
    
}
