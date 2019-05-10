package logic;

import data.Carport;
import data.DBConnector;
import data.DataAccessor;
import data.Floor;
import data.Material;
import data.Rafter;
import data.Roof;
import data.Shed;
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
    @Override
    public int WoodPostNeeded(Carport carport) {
           // hvis tiden tillader, så skal l1, l2 og l3 kunne ændres ved hjælp af database

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
    
    @Override
    public double WooPostTotalPrice(Carport carport) {
        double totalPrice;

        totalPrice = ((WoodPostNeeded(carport) * carport.getHeight()) * carport.getRoof().getWoodpost().getMprice());

        return totalPrice;
    }
    @Override
    public int NumbersOfRaftersFlatRoof(Carport carport) {
        int rafter_width = 195;
        int rafter_distance = 600;
        // følgende spærdimensioner = variabler fra database
        //   double spændvidde = 4.02;
        int numbers_rafters = ((carport.getLength() + rafter_distance) / (rafter_width + rafter_distance)); // bredde på spær og afstand til næste spær slåes sammen til en enhed. 
        //Den samlede længde divideres op i carportens længde + spærafstand, da den sidste spær "mangler" en efterfølgende afstandmåling.
        int integer_numbers_rafters = numbers_rafters + 1; //Vi plusser med én, da int altid runder ned.
        return integer_numbers_rafters;
    }
    @Override
    public double TotalLengthRaftersFlatRoof(Carport carport) {
        double total_length = (NumbersOfRaftersFlatRoof(carport) * carport.getWidth());
        return total_length;
    }
    @Override
    public double TotalPriceRaftersFlatRoof(Carport carport) {
        double total_rafter_price = (TotalLengthRaftersFlatRoof(carport) / 1000) * carport.getRoof().getRafter().getMprice(); // Der divideres med 1000 for at kunne gange med meterprisen.
        return total_rafter_price;

    }
    @Override
    public double TotalLengthRaftersWithSlope(Carport carport) {
        double length_single_rafter_with_slope = ((0.5 * carport.getWidth()) / Math.cos(carport.getRoof().getAngle())); // Der ganges med 0,5 for at kunne danne en retvinklet trekant. 
        // Derefter findes længden af c via formlen c = b * cos(A).
        double length_both_sides_with_slope = 2 * length_single_rafter_with_slope;                                      // Der ganges med to for at få længden af begge hældningssider.
        double total_length_all_three_sides = (NumbersOfRaftersFlatRoof(carport) * length_both_sides_with_slope) + TotalLengthRaftersFlatRoof(carport); // Antal spær ganges med længden 
        // af de to hældningssider. Resultatet plusses
        // med den samlede længde af de flade spær.
        return total_length_all_three_sides;
    }

    @Override
    public double TotalPriceRaftersWithSlope(Carport carport) {
        double totalprice = (TotalLengthRaftersWithSlope(carport) / 100) * carport.getRoof().getRafter().getMprice();  // // Der divideres med 1000 for at kunne gange med meterprisen.
        return totalprice;

    }

    @Override
    public int BeamsNeeded(Carport carport) {
       // B1, B2 og B3's værdier skal laves om til variabler, som kan rettes af bruger.
        int B = carport.getLength();
        int B1 = 4000;
        int B2 = 150;
        int B3 = 150;
        int max = (B - (B2 + B3));
        int PostsPrBeams = max / B1;
        int PostsPrBeamsRoundUp = (int) (Math.ceil(PostsPrBeams / 1000.0) * 1000);
        
        return PostsPrBeamsRoundUp;
    }
        // beams are cut to custom measures 
    @Override
    public double beamsPrice(Carport carport) {
        int lenghtprBeam = carport.getHeight();
        double totalPrice = lenghtprBeam * carport.getRoof().getBeam().getMprice() * BeamsNeeded(carport);
        
        return totalPrice; 
    }

    @Override
    public int floorArea(Shed shed) {
       int area = shed.getDepth() * shed.getWidth();
       return area;
    }
     
    @Override
    public double floorPrice(Floor floor) {
        double price = floor.getHeight() * floor.getWidth() * floor.getM2price();
        return price;
    }

    @Override
    public int calulateGabledHeight(Carport carport) {
       int A = carport.getRoof().getAngle();
       int gabledHeight  = (int) ((int) carport.getWidth() * Math.tan(A));
       return gabledHeight;
    }

    @Override
    public int calculateGabledArea(Carport carport) {
        double height = calulateGabledHeight(carport);
        double g = carport.getWidth();
        int area = (int) (2 / (height * g));
        return area;
    }

    @Override
    public int calculateGabledWallCovering(Roof roof) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int WallCoveringsNeededDepth(Shed shed) {
        //overlay used for 100 mm width
        int overlay = 150;
        int shedCoverDepth = shed.getDepth();
        int wallCoverWidth = shed.getWallCovering().getWidth();
        int MaxCover = ((2 * wallCoverWidth) - (2 * overlay));
        int distenceToCover = shedCoverDepth - wallCoverWidth;
        int wallCOverFits = distenceToCover / MaxCover;
        int nearst = (int) (Math.ceil(wallCOverFits / 1000.0) * 1000);
        int finalCoverNeeded = distenceToCover / nearst;
        int finalCoverNeededtotal = (int) (Math.ceil(finalCoverNeeded / 100.0) * 100.0);
        int Overlay = (shedCoverDepth - finalCoverNeededtotal) / 2;

        // https://www.lav-det-selv.dk/artikler/id/76/s/1-paa-2-beklaedning
        // regn nu hvor mange der skal være på indersiden
      
        //return totalAmount;
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public double calculateWallCoveringPrice(int area, Carport carport) {
        double Mprice = carport.getShed().getWallCovering().getMprice();
       // int lenght
            //    = int totalAmount = lenght * Mprice;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int totalWallCoveringsNeeded(Shed shed) {
        int sideOne = WallCoveringsNeededDepth(shed);
        int sideTwo = WallCoveringsNeededDepth(shed);
        int sideThree = WallCoveringsNeededwidth(shed);
        int sideFour = WallCoveringsNeededwidth(shed);
        int allSides = sideOne + sideTwo + sideThree + sideFour;
        return allSides;
    }

    @Override
    public int WallCoveringsNeededwidth(Shed shed) {
          int shedCoverWidth = shed.getWidth();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int roofArea(Carport carport) {
        int b = carport.getWidth(); 
        int A = carport.getRoof().getAngle();
        int area = (int) (b / Math.cos(A)) * 2; // * 2 because there is to sides.    
        return area; 
    }
}
