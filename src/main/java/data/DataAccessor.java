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

                return new Material(name, desc, material, type, matNum, length, height, width, price);
            }
            throw new RuntimeException("no such material " + name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    // Christian Ambjørn Kehr
    @Override
    public Material getMaterialFromId(int id) {
        Material Mat = null;

        try {
            DBConnector connect = new DBConnector();

            String query = "SELECT * FROM Materials WHERE Vare_nummer =" + id + ";";

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

    @Override
    public double getDeliveryPrice(String location) {
        double price = 0;
        try {
            DBConnector connect = new DBConnector();

            String query = "SELECT Delivery_Price FROM Fog.Delivery where Delivery_Location = '" + location + "';";

            Connection connection = connect.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                price = rs.getDouble("Price");
            }
            return price;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return price;
    }

    @Override
    public ArrayList<String> getType() {
        ArrayList<String> types = new ArrayList<>();

        try {
            DBConnector connect = new DBConnector();

            String query = "SELECT DISTINCT Type FROM Fog.Materials;";

            Connection connection = connect.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String type = rs.getString("Type");
                types.add(type);
            }
            return types;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return types;
    }

    public ArrayList<Delivery> getDeliveryLocations() {
        ArrayList<Delivery> deliveryList = new ArrayList<>();
        try {
            DBConnector connect = new DBConnector();

            String query = "SELECT * FROM Fog.Delivery;";

            Connection connection = connect.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String dLocation = rs.getString("Delivery_Location");
                Double dPrice = rs.getDouble("Delivery_Price");

                deliveryList.add(new Delivery(dLocation, dPrice));
            }
            return deliveryList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deliveryList;
    }

    @Override
    public ArrayList<Demand> getAllDemands() {
        ArrayList<Demand> demandList = new ArrayList<>();
        try {
            DBConnector connect = new DBConnector();

            String query = "SELECT * FROM Fog.Variabler;";

            Connection connection = connect.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("Varibable_name");
                int measure = rs.getInt("Measurements");

                demandList.add(new Demand(name, measure));
            }
            return demandList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return demandList;
    }
}
