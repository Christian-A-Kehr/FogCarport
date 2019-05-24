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
public class Facade implements FacadeInterface{

    private DataAccessor data = new DataAccessor();
    private DataUpdater dataUp = new data.DataUpdater();

    /////////////////////////////testing///////////////////////////////////
//    public static void main(String[] args) throws NoDataException {
//        Facade logic = new Facade();
        //System.err.println(getAllMaterials());

//         System.err.println(getListSpecificMaterials(type));
//        String name = "Spær C18";
//        getMaterial(name);
        // System.err.println(getMaterialFromId(50));
//                 String type = "spær";
//   System.out.println(getMaterialType());
//        System.err.println(getDelivery(lal));
        //DisplayAllMaterial();
        //Material testMat = new Material("Test", "dette er en test", "test", "Test", 50, 2, 50, 60, 50);
        //saveMaterial(testMat);
        //dataUp.updateMaterial(50, testMat);
        //     String location = "Fyn";
//        System.err.println(getDelivery(location));
        //updateDeliveryPrice(location, 1475); // 1475
//        String variable = "Udhæng_max";
//        System.err.println(getVariable(variable));
//        updateDemandVariables(variable, 150); // 150
//         System.err.println(getDeliveryLocations());
    

//    }
///////////////////////////////////dataAccessor///////////////////////////////////
    //tested

    @Override
    public ArrayList<Material> getAllMaterials() {
        ArrayList list = new ArrayList(data.getAllMaterials());
        return list;
    }

    //tested
    @Override
    public ArrayList<Material> getListSpecificMaterials(String type) {
        return data.getListSpecificMaterials(type);
    }

    ////// See if this is needed when done///////
    @Override
    public Material getMaterial(String name) {
        return data.getMaterial(name);
    }

    //tested
    @Override
    public Material getMaterialFromId(int id) {
        return data.getMaterialFromId(id);
    }

    //test
    @Override
    public ArrayList<String> getMaterialType() {
        return data.getType();
    }

    /////////////////////////////////DataUpdater///////////////////////////////////////////////////
  

    //Tested
    @Override
    public void saveMaterial(Material material) {
        List<Material> AllMats = dataUp.DisplayAllMaterial();

        for (int i = 0; i < AllMats.size(); i++) {
            if (AllMats.get(i).getMatNum() == material.getMatNum()) {
                dataUp.updateMaterial(material.getMatNum(), material);
            } else {
                dataUp.createMaterial(material);
            }
        }
    }

    // tested
    @Override
    public void dropMaterial(int id) {
        dataUp.dropMaterial(id);
    }

    //tested
    @Override
    public Delivery getDelivery(String location) throws NoDataException {
        return dataUp.getDelivery(location);
    }

    //tested
    @Override
    public void updateDeliveryPrice(String location, double price) {
        dataUp.updateDeliveryPrice(location, price);
    }
    //tested
//    @Override
    public Demand getVariable(String name) throws NoDataException {
        return dataUp.getVariable(name);
    }
    // tested
    @Override
    public void updateDemandVariables(String name, int measurements) {
        dataUp.updateDemandVariables(name, measurements);
    }

    //tested
    @Override
    public ArrayList<Delivery> getDeliveryLocations() {
        return data.getDeliveryLocations();
    }

    @Override
    public ArrayList<Demand> getAllDemands() {
        return data.getAllDemands();
    }
}
