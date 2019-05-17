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
import data.NoDataException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian Ambjørn Kehr
 */
public interface FacadeInterface {
    ///////////////////////////////////dataAccessor///////////////////////////////////

    public ArrayList<Material> getAllMaterials();

    public ArrayList<Material> getListSpecificMaterials(String type);

    public Material getMaterial(String name);

    public Material getMaterialFromId(int id);

    public ArrayList<String> getMaterialType();

    /////////////////////////////////DataUpdater///////////////////////////////////////////////////
    public void saveMaterial(Material material);

    public void dropMaterial(int id);

    public Delivery getDelivery(String location) throws NoDataException;

    public void updateDeliveryPrice(String location, double price);

    public Demand getVariable(String name) throws NoDataException;

    public void updateDemandVariables(String name, int measurements);

    public ArrayList<Delivery> getDeliveryLocations();
}
