
package logic;

import data.Carport;
import data.Delivery;
import data.Floor;
import data.Roof;
import data.Shed;
import data.WoodPost;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Christian Ambjørn Kehr
 */

public interface CalculateInterface {
   
   // all calculations i made in mm therefor int is used isted of double
    public HashMap<String, Double> CalculateCarport(Carport carport);

    // woodpost
    public int WoodPostNeeded(Carport carport); // skal laves om til int length (nuværende = carport)
    public double WooPostTotalPrice(Carport carport);

    // rafters flat
    public int NumbersOfRaftersFlatRoof(double Distance);
    public int TotalLengthRaftersFlatRoof(Carport carport);
    public double TotalPriceRaftersFlatRoof(Carport carport);
    // rafters with sloop
    public int NumberOfRaftersSlopedRoof(Carport carport);
    public int TotalLengthRaftersWithSlope(Carport carport);
    public double TotalPriceRaftersWithSlope(Carport carport);
    //beams
    public int BeamsNeeded(double carportWidth, double beamWidth); // skal laves om til int length (nuværende = carport)
    public int BeamsNeededShed(double carportWidth, double shedWidth, double beamWidth);
    public double beamsPrice(Carport carport); 
    
    //floor
    public int floorArea(Shed shed);

    //gabled
    public int calulateGabledHeight(Roof roof);
    public double calculateGabledArea(Roof roof);
    public double calculateGabledWallCoveringPrice(int boardsNeeded, double price, Roof roof);
    public int calculateGabledWallcoverAmount(Roof roof); 

    //wallcover
    public int WallCoveringsNeededDepth(Shed shed, WoodPost woodPost);
    public double calculateWallCoveringPrice(int totalWallCover, double price);
    public int totalWallCoveringsNeeded(Shed shed, WoodPost woodPost);
    public int WallCoveringsNeededwidth(Shed shed, WoodPost woodPost);

    // rooftiles
    public int roofArea(Roof roof);
    public double rooftilesTotalprice(Double price, int amount);

    //battens
    public int battensNeeded(Carport carport);
    
}

