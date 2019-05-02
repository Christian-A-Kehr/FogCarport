/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.DataAccessor;
import data.Material;
import java.util.ArrayList;

public class LogicFacade {
     DataAccessor data = new DataAccessor();
     
    public static void main(String[] args) {
        LogicFacade logic = new LogicFacade();
        //logic.getMaterialLogic();
        logic.GetAllMatrials();
        
    }
    
    public ArrayList<Material> GetAllMatrials(){
        ArrayList list = new ArrayList(data.getAllMaterials());
        System.err.println(list);
        
        return list;
    }}
    