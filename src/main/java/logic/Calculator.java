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
      
    // L1, L2 og L3's værdier skal laves om til variabler, som kan rettes af bruger.
    // max = maxsimum lenght between woodposts before a new post is needed.  
    int L = carport.getLength();
    int Max = 4000;
    int L1 = 150; // L2 = data.getDemand(1) // L1 = 1. Lenght that need to eaves.
    int L2 = 150; // L2 = data.getDemand(1) // L2 = 2. Lenght that need to eaves.
    int Ltotal = (L - (L1 + L2)); 
    int PostsPrBeams = Ltotal/Max;
    
    // 1000 = nearest meter, because if it excite nearest thousand  it must be the next thousand.
    int totalPostsPrBeams = (int) (Math.ceil(PostsPrBeams / 1000.0) * 1000);
    int TotalPosts = totalPostsPrBeams * BeamsNeeded(carport);
    
    return TotalPosts;
    }

    public double WoodPostTotalPrice(Carport carport) {

        double totalPrice = ((WoodPostNeeded(carport) * carport.getHeight()) * carport.getRoof().getWoodpost().getMprice());
        return totalPrice;
    }

    private int BeamsNeeded(Carport carport) {
    // B1, B2 og B3's værdier skal laves om til variabler, som kan rettes af bruger.
    int B = carport.getLength();
    int B1 = 4000;
    int B2 = 150; // B2 = data.getDemand(1) // L1 = 1. Lenght that need to eaves.
    int B3 = 150; // B3 = data.getDemand(1) // L1 = 1. Lenght that need to eaves.
    int max = (B - (B2 + B3)); 
    int PostsPrBeams = max/B1;
    // 1000 = nearest meter, because if it excite nearest thousand  it must be the next thousand.
    int totalPostsPrBeams = (int) (Math.ceil(PostsPrBeams / 1000.0) * 1000);
    int TotalPosts = totalPostsPrBeams;
    
    return TotalPosts;
    }
}  

