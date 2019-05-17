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

    static DataAccessor data = new DataAccessor();

    /////////////////////////////testing///////////////////////////////////
    public static void main(String[] args) throws NoDataException {
        Facade logic = new Facade();
        //logic.getMaterialLogic();
//        logic.getAllMaterials();
//        String name = "Spær C18";
//        System.out.println(logic.getMaterial(name));
        //System.err.println(getAllMaterials());
        //    System.out.println(getMaterialType());

//        String lal = "Fyn"; 
//        System.err.println(getDelivery(lal));
        //DisplayAllMaterial();
        //Material testMat = new Material("Test", "dette er en test", "test", "Test", 50, 2, 50, 60, 50);
       //saveMaterial(testMat);
        //dataUp.updateMaterial(50, testMat);
        
        System.err.println(getDeliveryLocations());
        
        
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

    public ArrayList<String> getMaterialType() {
        return data.getType();
    }

    /////////////////////////////////DataUpdater///////////////////////////////////////////////////
    static DataUpdater dataUp = new data.DataUpdater();
    //Tested
    public void saveMaterial(Material material) {
        List<Material> AllMats = dataUp.DisplayAllMaterial();

        for (int i = 0; i < AllMats.size(); i++) {
            if (AllMats.get(i).getMatNum() == material.getMatNum()) {
                dataUp.updateMaterial(material.getMatNum(), material);
            }
            else {
            dataUp.createMaterial(material);
        }}
    }
    // tested
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
    
    public static ArrayList<Delivery> getDeliveryLocations(){
        return data.getDeliveryLocations();
    }
}
