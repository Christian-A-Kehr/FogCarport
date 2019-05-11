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
        int carPortLength = carport.getLength();
        int woodPostsDistance = dataaccessor.getVariabel(2); // 4000 mm
        int overHang1 = dataaccessor.getVariabel(1); // 1500 mm
        int overHang2 = dataaccessor.getVariabel(1); // 1500 mm
        int stretchForWoodposts = (carPortLength - (overHang1 + overHang2));
        double totalNumberNoodpostsDouble = (stretchForWoodposts + woodPostsDistance)/ (carport.getRoof().getWoodpost().getWidth() + woodPostsDistance)*2;
        // 1000 = nearest meter 
        int totalNumbersWoodpostsInt = (int) (Math.ceil(totalNumberNoodpostsDouble / 1000.0) * 1000); // kan ikke benytte int + 1, da det kan ske, at udregningen bliver et heltal.
        // int TotalPosts = woodposts_pr_beams * BeamsNeeded(carport);
        return totalNumbersWoodpostsInt;
    }
    
    @Override
    public double WooPostTotalPrice(Carport carport) {
        double totalPrice = (((WoodPostNeeded(carport) * carport.getHeight())/1000) * carport.getRoof().getWoodpost().getprice());
        return totalPrice;
    }
    
    @Override
    public int NumbersOfRaftersFlatRoof(Carport carport) {
        int rafterWidth = dataaccessor.getVariabel(4);  // 195;
        int rafterDistance = dataaccessor.getVariabel(5); // 600;
        // følgende spærdimensioner = variabler fra database
        //   double spændvidde = 4.02;
        double totalNumbersRaftersDouble = ((carport.getLength() + rafterDistance) / (rafterWidth + rafterDistance)); // bredde på spær og afstand til næste spær slåes sammen til en enhed. 
        //Den samlede længde divideres op i carportens længde + spærafstand, da den sidste spær "manglerr med én, da int altid runder ned." en efterfølgende afstandmåling.
        int integerNumbersRafters = (int) (Math.ceil(totalNumbersRaftersDouble / 1000.0) * 1000); // kan ikke benytte int + 1, da det kan ske, at udregningen bliver et heltal. 
        return integerNumbersRafters;
    }
    @Override
    public int TotalLengthRaftersFlatRoof(Carport carport) {
        int totalLength = (NumbersOfRaftersFlatRoof(carport) * carport.getWidth());
        return totalLength;
    }
    @Override
    public double TotalPriceRaftersFlatRoof(Carport carport) {
        double totalRafterPrice = (TotalLengthRaftersFlatRoof(carport) / 1000) * carport.getRoof().getRafter().getMprice(); // Der divideres med 1000 for at kunne gange med meterprisen.
        return totalRafterPrice;

    }
    //TEST DENNE PGA INT cast Vigtigt! 
    @Override
    public int TotalLengthRaftersWithSlope(Carport carport) {
        int lengthSingleRafterWithSlope = (int) ((carport.getWidth() / 2 ) / Math.cos(carport.getRoof().getAngle())); // Der ganges med 0,5 for at kunne danne en retvinklet trekant. 
        // Derefter findes længden af c via formlen c = b * cos(A).
        int lengthBothSidesWithSlope = 2 * lengthSingleRafterWithSlope;                                      // Der ganges med to for at få længden af begge hældningssider.
        int totalLengthAllThreeSides = (NumbersOfRaftersFlatRoof(carport) * lengthBothSidesWithSlope) + TotalLengthRaftersFlatRoof(carport); // Antal spær ganges med længden 
        // af de to hældningssider. Resultatet plusses
        // med den samlede længde af de flade spær.
        return totalLengthAllThreeSides;
    }

    @Override
    public double TotalPriceRaftersWithSlope(Carport carport) {
        double totalprice = (TotalLengthRaftersWithSlope(carport) / 100) * carport.getRoof().getRafter().getMprice();  // // Der divideres med 1000 for at kunne gange med meterprisen.
        return totalprice;

    }

    @Override
    public int BeamsNeeded(Carport carport) {
       // B1, B2 og B3's værdier skal laves om til variabler, som kan rettes af bruger.
        int carportWidth = carport.getWidth();
        int beamsDistance = dataaccessor.getVariabel(2); //4000;
        int overHang3 = dataaccessor.getVariabel(7); //150;
        int overHang4 = dataaccessor.getVariabel(8); // 150;
        int stretchForBeams = (carportWidth - (overHang3 + overHang4));
        double totalNumbersWoodpostsDouble = (stretchForBeams + beamsDistance)/((carport.getRoof().getBeam().getWidth() + beamsDistance));
        int totalNumbersWoodpostsInt = (int) (Math.ceil(totalNumbersWoodpostsDouble / 1000.0) * 1000);;
        return totalNumbersWoodpostsInt;
    }
        // beams are cut to custom measures 
    @Override
    public double beamsPrice(Carport carport) {
        int lenghtPrBeam = carport.getHeight();
        double totalPrice = (lenghtPrBeam * BeamsNeeded(carport)) * carport.getRoof().getBeam().getprice();
        return totalPrice; 
    }

    @Override
    public int floorArea(Shed shed) {
       int floorArea = shed.getDepth() * shed.getWidth();
       return floorArea;
    }
     
    @Override
    public double floorPrice(Floor floor) {
        double floorsPrice = floor.getLength() * floor.getWidth() * floor.getM2price();
        return floorsPrice;
    }

    @Override
    public int calulateGabledHeight(Carport carport) {
       int roofSlope = carport.getRoof().getAngle();
       int gabledHeight  = (int) ((int) carport.getWidth() * Math.tan(roofSlope));
       return gabledHeight;
    }

    @Override
    public int calculateGabledArea(Carport carport) {
        double gableheight = calulateGabledHeight(carport);
        double gablewidth = carport.getWidth();
        int gablehalfarea  = (int) (0.5 * (gableheight * gablewidth));
        int gablearea = gablehalfarea * 2;
        return gablearea;
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
    }}
