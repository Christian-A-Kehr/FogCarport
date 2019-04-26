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
public class DataAccessor {
    public static void main(String[] args) {
      
//        System.out.println(getCupCakePrice("Jordbær"));
//        System.out.println(getAllCupCakes().toString());
//        System.out.println(getUser("John").toString());
//        createUser("John", "1234", "Teeest@testmail.dk", 1000);
//
//        System.out.println("Start");
//        getAllCupCakes();
//        String Jordbær = "Jordbær";
//        CompleteCupCake j = getCupCake(Jordbær);
//        System.out.println("CupCake found: " + j.getName());
        System.out.println(getAllCupCakes().toString()); 
    }
     
    public static ArrayList<CompleteCupCake> getAllCupCakes() {
        ArrayList<CompleteCupCake> list = new ArrayList<>();

        try {
            DBConnector c = new DBConnector();

            String query = "SELECT * FROM CupCakes_list;";

            Connection connection = c.getConnection();
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String name = rs.getString("c_name");
                double price = rs.getDouble("c_price");

                list.add(new CompleteCupCake(name, price));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
