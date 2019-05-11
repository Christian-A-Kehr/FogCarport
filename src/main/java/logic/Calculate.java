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
        int carport_length = carport.getLength();
        int woodposts_distance = dataaccessor.getVariabel(1); // 4000 mm
        int overhang1 = dataaccessor.getVariabel(2); // 1500 mm
        int overhang2 = dataaccessor.getVariabel(3); // 1500 mm
        int stretch_for_woodposts = (carport_length - (overhang1 + overhang2));
        double total_numbers_woodposts_double = (stretch_for_woodposts + woodposts_distance)/ (carport.getRoof().getWoodpost().getWidth() + woodposts_distance)*2;

        // 1000 = nearest meter 
        int total_numbers_woodposts_int = (int) (Math.ceil(total_numbers_woodposts_double / 1000.0) * 1000); // kan ikke benytte int + 1, da det kan ske, at udregningen bliver et heltal.
        // int TotalPosts = woodposts_pr_beams * BeamsNeeded(carport);

        return total_numbers_woodposts_int;
    }
    
    @Override
    public double WooPostTotalPrice(Carport carport) {
        double total_price = (((WoodPostNeeded(carport) * carport.getHeight())/1000) * carport.getRoof().getWoodpost().getMprice());

        return total_price;
    }
    @Override
    public int NumbersOfRaftersFlatRoof(Carport carport) {
        int rafter_width = dataaccessor.getVariabel(4);  // 195;
        int rafter_distance = dataaccessor.getVariabel(5); // 600;
        // følgende spærdimensioner = variabler fra database
        //   double spændvidde = 4.02;
        double total_numbers_rafters_double = ((carport.getLength() + rafter_distance) / (rafter_width + rafter_distance)); // bredde på spær og afstand til næste spær slåes sammen til en enhed. 
        //Den samlede længde divideres op i carportens længde + spærafstand, da den sidste spær "manglerr med én, da int altid runder ned." en efterfølgende afstandmåling.
        int integer_numbers_rafters = (int) (Math.ceil(total_numbers_rafters_double / 1000.0) * 1000); // kan ikke benytte int + 1, da det kan ske, at udregningen bliver et heltal. 
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
        int carport_width = carport.getWidth();
        int beams_distance = dataaccessor.getVariabel(6); //4000;
        int overhang3 = dataaccessor.getVariabel(7); //150;
        int overhang4 = dataaccessor.getVariabel(8); // 150;
        int stretch_for_beams = (carport_width - (overhang3 + overhang4));
        double total_numbers_woodposts_double = (carport_width + beams_distance)/((carport.getRoof().getBeam().getWidth() + beams_distance));
        int total_numbers_woodposts_int = (int) (Math.ceil(total_numbers_woodposts_double / 1000.0) * 1000);;
        return total_numbers_woodposts_int;
    }
        // beams are cut to custom measures 
    @Override
    public double beamsPrice(Carport carport) {
        int lenght_pr_beam = carport.getHeight();
        double totalPrice = (lenght_pr_beam * BeamsNeeded(carport)) * carport.getRoof().getBeam().getprice();
        
        return totalPrice; 
    }

    @Override
    public int floorArea(Shed shed) {
       int area = shed.getDepth() * shed.getWidth();
       return area;
    }
     
    @Override
    public double floorPrice(Floor floor) {
        double price = floor.getLength() * floor.getWidth() * floor.getM2price();
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
