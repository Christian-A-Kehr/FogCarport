/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.List;

/**
 *
 * @author Christian Ambjørn Kehr
 */
public interface DataUpdaterInterface {
    
    // Material's
    public void createMaterial(Material material);
    public void updateMaterial(int id, Material material);
    public void dropMaterial(int id);
    public List<Material> DisplayAllMaterial();
    // Delivery's
    public Delivery getDelivery(String location) throws  NoDataException;  
    public void updateDeliveryPrice(String location, double price);
    // variable's 
    public Demand getVariable(String name) throws NoDataException;
    public void updateDemandVariables(String name, int measurements);
    
}
