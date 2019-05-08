package logic;

import data.Carport;
import data.DBConnector;
import data.DataAccessor;
import data.Material;
import data.Rafter;
import data.WoodPost;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.lang.*;

/**
 *
 * @author Christian Ambjørn Kehr
 * @author Claus Mikkelsen Findinge
 */
class Calculate implements LogicInterface {

    private DataAccessor dataaccessor = new DataAccessor();

    // roof. length 0,8 + 0,3 
    public int WoodPostNeeded(Carport carport) {
        // hvis tiden tillader, så skal l1, l2 og l3 kunne ændres ved hjælp af database

//    WoodPost woodpost = new WoodPost(carport.getRoof().getWoodpost().getMaterial(),
//                                     carport.getRoof().getWoodpost().getLenght(),
//                                     carport.getRoof().getWoodpost().getWidth(),
//                                     carport.getRoof().getWoodpost().getMprice());
        // L1, L2 og L3's værdier skal laves om til variabler, som kan rettes af bruger.
        int L = carport.getLength();
        int L1 = 4000;
        int L2 = 800;
        int L3 = 300;
        int max = (L - (L2 + L3));
        int PostsPrBeams = max / L1;

        // 1000 = nearest meter 
        PostsPrBeams = (int) (Math.ceil(PostsPrBeams / 1000.0) * 1000);
        int TotalPosts = PostsPrBeams * BeamsNeeded(carport);

        return TotalPosts;
    }

    public double WooPostTotalPrice(Carport carport) {
        double totalPrice;

        totalPrice = ((WoodPostNeeded(carport) * carport.getHeight()) * carport.getRoof().getWoodpost().getMprice());

        return totalPrice;
    }

    public int BeamsNeeded(Carport carport) {
        // B1, B2 og B3's værdier skal laves om til variabler, som kan rettes af bruger.
        int B = carport.getLength();
        int B1 = 4000;
        int B2 = 150;
        int B3 = 150;
        int max = (B - (B2 + B3));
        int PostsPrBeams = max / B1;
        PostsPrBeams = (int) (Math.ceil(PostsPrBeams / 1000.0) * 1000);
        int TotalPosts = PostsPrBeams * BeamsNeeded(carport);

        return TotalPosts;
    }

    public double AntalSpær(Carport carport) {

        int spærbredde = 195;
        int spærafstand = 600;
        double spændvidde = 4.02;

        int antalspær = ((carport.getLength() + spærafstand) / (spærbredde + spærafstand)); // bredde på spær og afstand til næste spær slåes sammen til en enhed. 
        //Den samlede længde divideres op i carportens længde + spærafstand, da den sidste spær "mangler" en efterfølgende afstandmåling.

        double længde_c = 0.5 * carport.getWidth(); // Længden ganges med en halv for at danne en retvinklet trekant 
        double længde_a = længde_c * Math.sin(90); // a = c * sin(A)
        double længdeEnkeltSpær = 2 * længde_a;

        double totallængdespær = længdeEnkeltSpær * antalspær;
       return totallængdespær;
    }
       

    public double TotalPrisSpær(Carport carport) {

        double totalpris = (AntalSpær(carport) / 1000) * carport.getRoof().getRafter().getMprice();
        return totalpris;
      
       }

    @Override
    public int WoodPostNeeded() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double WooPostTotalPrice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int BeamsNeeded() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

   

