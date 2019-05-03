/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.Carport;
import data.DataAccessor;

/**
 *
 * @author Christian Ambjørn Kehr
 */
public class Calculator {
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
    int PostsPrBeams = max/L1;
    
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

    private int BeamsNeeded(Carport carport) {
    // B1, B2 og B3's værdier skal laves om til variabler, som kan rettes af bruger.
    int B = carport.getLength();
    int B1 = 4000;
    int B2 = 150;
    int B3 = 150;
    int max = (B - (B2 + B3)); 
    int PostsPrBeams = max/B1;
    PostsPrBeams = (int) (Math.ceil(PostsPrBeams / 1000.0) * 1000);
    int TotalPosts = PostsPrBeams * BeamsNeeded(carport);
    
    return TotalPosts;
    }
}  

