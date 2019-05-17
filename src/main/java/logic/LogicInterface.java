
package logic;

import data.Carport;
import data.Delivery;
import data.Floor;
import data.Roof;
import data.Shed;
import data.WoodPost;
import java.util.ArrayList;

public interface LogicInterface {
   
   // all calculations i made in M therefor int is used isted of double
    public double CalculateCarport(Carport carport);
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
    public double floorPrice(Floor floor);
    public int calulateGabledHeight(Roof roof);
    public int calculateGabledArea(Carport carport);
    public int calculateGabledWallCovering(Roof roof);
    public int WallCoveringsNeededDepth(Shed shed);
    public double calculateWallCoveringPrice(int totalWallCover, double price);
    public int totalWallCoveringsNeeded(Shed shed);
    public int WallCoveringsNeededwidth(Shed shed);
    public int roofArea(Roof roof);
    public double rooftilesTotalprice(Double price, int amount);
    public Carport GetPrices(Carport carport);
    public int battensNeeded(Carport carport);
    
}

