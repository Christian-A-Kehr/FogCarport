/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Mkhansen
 */
public class DataAccessor implements DataAcessorInterface {
        //int Variabel; // used to get variables in getVariable
//    private final DBConnector CONNECTOR;
//    
//    public DataAccessor(DBConnector c){
//        this.CONNECTOR = c;
//    }
            
    //public static void main(String[] args) {
//        System.out.println(GetListSpecificMaterials("Tagsten"));
           //System.err.println(getVariabel(1));
   // }
    Beam beam;
    
    @Override
    public ArrayList<Material> getAllMaterials() {
        ArrayList<Material> list = new ArrayList<>();

        try {
            DBConnector connect = new DBConnector();

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

                list.add(new Material(name, desc, material, type, matNum, length, height, width, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // @author Christian Ambjørn Kehr
    @Override
    public ArrayList<Material> getListSpecificMaterials(String type) {
        ArrayList<Material> Mats = new ArrayList<>();

        try {
            DBConnector connect = new DBConnector();

            String query = "SELECT * FROM Materials WHERE Type ='" + type + "';";

            Connection connection = connect.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("Material_Name");
                String desc = rs.getString("Help_Description");
                String material = rs.getString("Material");
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

    //  @author MkHansen og Christian Ambjørn Kehr
    @Override
    public Material getMaterial(String name) {
        Material Mat = null;

        try {
            DBConnector connect = new DBConnector();

            String query = "SELECT * FROM Materials WHERE Material_Name ='" + name + "';";

            Connection connection = connect.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String desc = rs.getString("Help_Description");
                String material = rs.getString("Material");
                String type = rs.getString("Type");
                int matNum = rs.getInt("Vare_nummer");
                int length = rs.getInt("Length");
                int height = rs.getInt("Height");
                int width = rs.getInt("Width");
                double price = rs.getDouble("Price");

                Mat = new Material(name, desc, material, type, matNum, length, height, width, price);
            }
            return Mat;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Mat;
    }
    
     @Override
    public Material getMaterialFromId(int id) {
          Material Mat = null;

        try {
            DBConnector connect = new DBConnector();

            String query = "SELECT * FROM Materials WHERE Vare_nummer ='" + id + "';";

            Connection connection = connect.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("Material_Name");
                String desc = rs.getString("Help_Description");
                String material = rs.getString("Material");
                String type = rs.getString("Type");
                
                int length = rs.getInt("Length");
                int height = rs.getInt("Height");
                int width = rs.getInt("Width");
                double price = rs.getDouble("Price");

                Mat = new Material(name, desc, material, type, id, length, height, width, price);
            }
            return Mat;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Mat;
    }


    @Override
    public Offer getOffer(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Carport getCarport(int Id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//
//    @Override

    public Roof getRoof(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
    public Customer getCustomer(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getVariabel(int id) {
        int Variabel = 0;
        try {
            DBConnector connect = new DBConnector();
             
            String query = "SELECT * FROM Fog.Variabler where idVariabler ='" + id + "';";

            Connection connection = connect.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int matNum = rs.getInt("Measurements");
                

                Variabel = matNum;
            }
            return Variabel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Variabel;
    }

    @Override
    public int getMaterialPrice(int id) {
          int Variabel = 0;
        try {
            DBConnector connect = new DBConnector();
             
            String query = "SELECT * FROM Materials where Vare_nummer ='" + id + "';";

            Connection connection = connect.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int matNum = rs.getInt("Measurements");
                

                Variabel = matNum;
            }
            return Variabel;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Variabel;
    }
}
