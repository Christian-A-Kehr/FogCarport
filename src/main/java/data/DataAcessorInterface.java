/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;

/**
 *
 * @author Christian Ambjørn Kehr
 */

// implement in a Datamapper to get all lists and single objects in database. 
public interface DataAcessorInterface {
    
    
    // Used show all Material in the Database
    public ArrayList<Material> getAllMaterials ();
    
    // Used to show in relevant dropDownBoxses and prices.
    public ArrayList<Material> getListSpecificMaterials(String type);
    
    // Used to recover offers and get single objects from database
    public Material getMaterial (String name);
    
    public Material getMaterialFromId (int id);
    
    // used to get an offer from database
    public Offer getOffer (int Id);

    // Used to recover offers data to JSP and create objects
    public Carport getCarport (int Id);
    
    public Roof getRoof (String name);
    
    public Customer getCustomer (String name);
    
    public int getVariabel(int id);
    
    public int getMaterialPrice(int id);
    
    public double getDeliveryPrice(String name);
    
    public ArrayList<String> getType();
    
}