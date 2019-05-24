
package logic;

import data.Carport;
import data.Delivery;
import data.Floor;
import data.Roof;
import data.Shed;
import data.WoodPost;
import java.util.ArrayList;
import java.util.HashMap;

public interface LogicInterface {
   
   // all calculations i made in mm therefor int is used isted of double
    public HashMap<String, String> CalculateCarport(Carport carport);
    
    public int WoodPostNeeded(Carport carport); // skal laves om til int length (nuværende = carport)
    public double WooPostTotalPrice(Carport carport);
    
    public int NumbersOfRaftersFlatRoof(Carport carport);
    public int TotalLengthRaftersFlatRoof(Carport carport);
    public double TotalPriceRaftersFlatRoof(Carport carport);
    public int TotalLengthRaftersWithSlope(Carport carport);
    public double TotalPriceRaftersWithSlope(Carport carport);
    
    public int BeamsNeeded(Carport carport); // skal laves om til int length (nuværende = carport)
    public double beamsPrice(Carport carport); 
    
    public int floorArea(Shed shed);
    
    public int calulateGabledHeight(Roof roof);
    public double calculateGabledArea(Roof roof);
    public double calculateGabledWallCoveringPrice(int boardsNeeded, double price, Roof roof);
    public int calculateGabledWallcoverAmount(Roof roof); 
    
    public int WallCoveringsNeededDepth(Shed shed, WoodPost woodPost);
    public double calculateWallCoveringPrice(int totalWallCover, double price);
    public int totalWallCoveringsNeeded(Shed shed, WoodPost woodPost);
    public int WallCoveringsNeededwidth(Shed shed, WoodPost woodPost);
    
    public int roofArea(Roof roof);
    public double rooftilesTotalprice(Double price, int amount);
    
    public int battensNeeded(Carport carport);
    
}

