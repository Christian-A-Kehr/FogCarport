/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.DataAccessor;
import data.DataUpdater;
import data.Delivery;
import data.Demand;
import data.Material;
import data.NoDataException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian Ambjørn Kehr
 */
public class Facade {

    DataAccessor data = new DataAccessor();

    public static void main(String[] args) throws NoDataException {
        Facade logic = new Facade();
        //logic.getMaterialLogic();
//        logic.getAllMaterials();
        //System.out.println(logic.getMaterial("Spær C18"));
        //System.err.println(getAllMaterials());
    //    System.out.println(getMaterialType());
        
//        String lal = "Fyn"; 
//        System.err.println(getDelivery(lal));
          //DisplayAllMaterial();

    }
///////////////////////////////////dataAccessor///////////////////////////////////

    public ArrayList<Material> getAllMaterials() {
        ArrayList list = new ArrayList(data.getAllMaterials());
        return list;
    }

    public ArrayList<Material> getListSpecificMaterials(String type) {
        return data.getListSpecificMaterials(type);
    }

    public Material getMaterial(String name) {
        return data.getMaterial(name);
    }

    public Material getMaterialFromId(int id) {
        return data.getMaterialFromId(id);
    }
    
    public ArrayList<String> getMaterialType(){
        return data.getType();
    }

    /////////////////////////////////DataUpdater///////////////////////////////////////////////////
    
    static DataUpdater dataUp = new data.DataUpdater();

    public void saveMaterial(int id, Material material) {
        List<Material> AllMats = dataUp.DisplayAllMaterial();

        for (int i = 0; i < AllMats.size(); i++) {
            if (AllMats.get(i).getMatNum() == id) {
                dataUp.updateMaterial(id, material);
            }
            dataUp.createMaterial(material);
        }
    }

    public void dropMaterial(int id) {
        dataUp.dropMaterial(id);
    }

    public static Delivery getDelivery(String location) throws NoDataException {
        return dataUp.getDelivery(location);
    }

    public void updateDeliveryPrice(String location, double price) {
        dataUp.updateDeliveryPrice(location, price);
    }

    public Demand getVariable(String name) {
        return dataUp.getVariable(name);
    }

    public void updateDemandVariables(String name, int measurements) {
        dataUp.updateDemandVariables(name, measurements);
    }

}
