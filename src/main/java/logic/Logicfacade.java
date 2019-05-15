/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.DataUpdater;
import data.Delivery;
import data.Demand;
import data.Material;
import java.util.List;

/**
 *
 * @author Christian Ambjørn Kehr
 */
public class Logicfacade {
DataUpdater dataUp = new data.DataUpdater();


    public void saveMaterial(int id ,Material material){
        List<Material> AllMats= dataUp.DisplayAllMaterial();
        
            for (int i = 0; i < AllMats.size(); i++) {
            if (AllMats.get(i).getMatNum() == id){
               dataUp.updateMaterial(id, material);
            }
            dataUp.createMaterial(material);
            }
    }

    public void dropMaterial(int id) {
        dataUp.dropMaterial(id);
    }

    public List<Material> DisplayAllMaterial() {
        return DisplayAllMaterial();
    }

    public Delivery getDelivery(String location) {
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
