/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Ambjørn Kehr
 */
public class DataUpdater implements DataUpdaterInterface {

    DBConnector connect = null;
    PreparedStatement myStmt = null;
    ResultSet myRs = null;
    Material mat;
    Delivery deliver; 
    @Override
    public void createMaterial(Material material) {
        try {
            connect = new DBConnector();
            Connection connection = connect.getConnection();

            myStmt = connection.prepareCall("INSERT INTO `Fog`.`Materials` (`Material_Name`, `Vare_nummer`, `Help_Description`, `Length`, `Height`, `Width`, `Price`, `Material`, `Type`) VALUES ('?', '?', '?', '?', '2', '?', '?', '?', '?');");
            myStmt.setString(1, material.getName());
            myStmt.setInt(2, material.getMatNum());
            myStmt.setString(3, material.getDesc());
            myStmt.setInt(4, material.getLength());
            myStmt.setInt(5, material.height);
            myStmt.setInt(6, material.width);
            myStmt.setDouble(7, material.getPrice());
            myStmt.setString(8, material.getMaterial());
            myStmt.setString(9, material.getType());

            myRs = myStmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DataUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateMaterial(int id, Material material) {
        try {
            connect = new DBConnector();
            Connection connection = connect.getConnection();

            myStmt = connection.prepareCall("UPDATE `Fog`.`Materials` SET `Material_Name` = '?', `Help_Description` = '?', `Length` = '?', `Height` = '?', `Width` = '?', `Price` = '?', `Material` = '?', `Type` = '?' WHERE (`Vare_nummer` = '" + id + "');");

            myStmt.setString(1, material.getName());
            myStmt.setString(2, material.getDesc());
            myStmt.setInt(3, material.getLength());
            myStmt.setInt(4, material.height);
            myStmt.setInt(5, material.width);
            myStmt.setDouble(6, material.getPrice());
            myStmt.setString(7, material.getMaterial());
            myStmt.setString(8, material.getType());

            myRs = myStmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DataUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void dropMaterial(int id) {

        try {
            connect = new DBConnector();
            Connection connection = connect.getConnection();

            myStmt = connection.prepareCall("DELETE FROM `Fog`.`Materials` WHERE (`Vare_nummer` = '?');");
            myStmt.setInt(1, id);
            myStmt.execute();

        } catch (SQLException ex) {
            Logger.getLogger(DataUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Material> DisplayAllMaterial() {
        ArrayList<Material> Mats = new ArrayList<>();

        try {
            connect = new DBConnector();

            String query = "SELECT * FROM Materials;";

            Connection connection = connect.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("Material_Name");
                String desc = rs.getString("Help_Description");
                String material = rs.getString("Material");
                String type = rs.getString("Type");
                int matNum = rs.getInt("Vare_nummer");
                int length = rs.getInt("Length");
                int height = rs.getInt("Height");
                int width = rs.getInt("Width");
                double price = rs.getDouble("Price");

                Mats.add(new Material(name, desc, material, type, matNum, length, height, width, price));
            }
            return Mats;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Mats;
    }

    @Override
    public Delivery getDelivery(String location) {
        
        try {
            connect = new DBConnector();
            Connection connection = connect.getConnection();

            myStmt = connection.prepareCall("SELECT * FROM Fog.Delivery where Delivery_Location = '?';");
            myStmt.setString(1, location);
            myRs = myStmt.executeQuery();
            
            deliver = new Delivery(location, myRs.getDouble("Measurements"));
        } catch (SQLException ex) {
            Logger.getLogger(DataUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deliver;
    }

    @Override
    public void updateDeliveryPrice(String location, double price) {
        try {
            connect = new DBConnector();
            Connection connection = connect.getConnection();

            myStmt = connection.prepareCall("UPDATE `Fog`.`Delivery` SET `Delivery_Price` = '?' WHERE (`Delivery_Location` = '?')");

            myStmt.setDouble(1, price);
            myStmt.setString(2, location);

            myStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Demand getVariable(String name) {
       try {
            connect = new DBConnector();
            Connection connection = connect.getConnection();

            myStmt = connection.prepareCall("SELECT * FROM Fog.Variabler where Varibable_name = '" + name + "';");
            myRs = myStmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(DataUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (Demand) myRs;
    }
   

    @Override
    public void updateDemandVariables(String name, int measurements) {
       try {
            connect = new DBConnector();
            Connection connection = connect.getConnection();

            myStmt = connection.prepareCall("UPDATE `Fog`.`Variabler` SET `Measurements` = '?' WHERE (`Varibable_name` = '?');");

            myStmt.setDouble(1, measurements);
            myStmt.setString(2, name);

            myStmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DataUpdater.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
