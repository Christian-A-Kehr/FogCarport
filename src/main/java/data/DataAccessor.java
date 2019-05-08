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

//    private final DBConnector CONNECTOR;
//    
//    public DataAccessor(DBConnector c){
//        this.CONNECTOR = c;
//    }
            
//    public static void main(String[] args) {
//        System.out.println(GetListSpecificMaterials("Tagsten"));
//    }

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
                int priceM = rs.getInt("PriceM");
                int priceM2 = rs.getInt("PriceM2");

                list.add(new Material(name, desc, material, type, matNum, length, height, width, priceM, priceM2));
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
                int priceM = rs.getInt("PriceM");
                int priceM2 = rs.getInt("PriceM2");

                Mats.add(new Material(name, desc, material, type, matNum, length, height, width, priceM, priceM2));
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
                int priceM = rs.getInt("PriceM");
                int priceM2 = rs.getInt("PriceM2");

                Mat = new Material(name, desc, material, type, matNum, length, height, width, priceM, priceM2);
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
}
