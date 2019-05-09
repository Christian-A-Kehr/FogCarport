
package logic;

import data.Carport;
import data.Floor;
import data.Roof;
import data.Shed;
import data.WoodPost;

public interface LogicInterface {
   
   // all calculations i made in M therefor int is used isted of double
    public int WoodPostNeeded(Carport carport); // skal laves om til int length (nuværende = carport)
    public double WooPostTotalPrice(Carport carport);
    public int BeamsNeeded(Carport carport); // skal laves om til int length (nuværende = carport)
    public double beamsPrice(Carport carport); 
    public int floorArea(Shed shed);
    public double floorPrice(Floor floor);
    public int calulateGabledHeight(Carport carport);
    public int calculateGabledArea(Carport carport);
    public int calculateGabledWallCovering(Roof roof);
    public int totalWallCoveringsNeeded(Shed shed);
    public double calculateWallCoveringPrice(int area, Carport carport);
    public int WallCoveringsNeededDepth(Shed shed);
    public int WallCoveringsNeededwidth(Shed shed);
    public int roofArea(Carport carport); 
   // public carport GetPrices(Carport carport);
        
    
   
}

