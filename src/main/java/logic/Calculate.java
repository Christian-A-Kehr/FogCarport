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
import java.util.HashMap;

/**
 *
 * @author Christian Ambjørn Kehr
 * @author Claus Mikkelsen Findinge
 */
class Calculate implements LogicInterface {
//huske at slette noteform i comamnd

    private DataAccessor dataaccessor = new DataAccessor();
    // roof. length 0,8 + 0,3 

    /////////////////////////////////roof///////////////////////////////////////////////
    @Override
    public int WoodPostNeeded(Carport carport) {
        double carportLength = carport.getLength();
        double woodPostsDistance = dataaccessor.getVariabel(2); // 4000 mm
        double overHang1 = dataaccessor.getVariabel(1); // 150 mm
        double overHang2 = dataaccessor.getVariabel(1); // 150 mm
        double stretchForWoodposts = (carportLength - (overHang1 + overHang2));
        double totalNumberwoodpostsDouble = (stretchForWoodposts + woodPostsDistance) / (carport.getRoof().getWoodpost().getWidth() + woodPostsDistance) * BeamsNeeded(carport);
        int rounded = (int) Math.ceil(totalNumberwoodpostsDouble);
        return rounded;
    }

    @Override
    public double WooPostTotalPrice(Carport carport) {
        double totalPrice = (WoodPostNeeded(carport) * (carport.getHeight() )) * carport.getRoof().getWoodpost().getprice() / 1000;
        return totalPrice;
    }

    @Override
    public int NumbersOfRaftersFlatRoof(double Distance) {
        double rafterWidth = dataaccessor.getVariabel(4);  // 195;
        double rafterDistance = dataaccessor.getVariabel(3); // 600;
        // følgende spærdimensioner = variabler fra database
        //   double spændvidde = 4.02;
        double totalNumbersRaftersDouble = ((Distance + rafterDistance) / (rafterWidth + rafterDistance)); // bredde på spær og afstand til næste spær slåes sammen til en enhed. 
        //Den samlede længde divideres op i carportens længde + spærafstand, da den sidste spær "manglerr med én, da int altid runder ned." en efterfølgende afstandmåling.
        //int integerNumbersRafters = (int) (Math.ceil(totalNumbersRaftersDouble / 1000.0) * 1000); // kan ikke benytte int + 1, da det kan ske, at udregningen bliver et heltal. 
        double Round = Math.ceil(totalNumbersRaftersDouble);
        int integerNumbersRafters = (int) Round;
        return integerNumbersRafters;
    }

    @Override
    public int TotalLengthRaftersFlatRoof(Carport carport) {
        double totalLength = (NumbersOfRaftersFlatRoof(carport.getWidth()) * carport.getLength());
        int mm = (int) totalLength;
        return mm;
    }

    @Override
    public double TotalPriceRaftersFlatRoof(Carport carport) {
        double totalRafterPrice = (TotalLengthRaftersFlatRoof(carport) / 1000) * carport.getRoof().getRafter().getMprice(); // Der divideres med 1000 for at kunne gange med meterprisen.
        return totalRafterPrice;

    }

    //TEST DENNE PGA INT cast Vigtigt! 
    @Override
    public int TotalLengthRaftersWithSlope(Carport carport) {
        double lengthSingleRafterWithSlope = (int) ((carport.getWidth() / 2) / Math.cos(Math.toRadians(carport.getRoof().getAngle()))); // Der ganges med 0,5 for at kunne danne en retvinklet trekant. 
        // Derefter findes længden af c via formlen c = b * cos(A).
        double lengthBothSidesWithSlope = 2 * lengthSingleRafterWithSlope;                                      // Der ganges med to for at få længden af begge hældningssider.
        double totalLength = NumbersOfRaftersFlatRoof(lengthBothSidesWithSlope) * carport.getLength() ; // Antal spær ganges med længden 
        // af de to hældningssider. Resultatet plusses
        // med den samlede længde af de flade spær.
        int round = (int) Math.round(totalLength);
        return round;
    }

    @Override
    public double TotalPriceRaftersWithSlope(Carport carport) {
        double totalprice = (TotalLengthRaftersWithSlope(carport) / 1000) * carport.getRoof().getRafter().getMprice();  // // Der divideres med 1000 for at kunne gange med meterprisen.
        return totalprice;

    }

    @Override
    public int BeamsNeeded(Carport carport) {
        int carportWidth = carport.getWidth();
        int beamsDistance = dataaccessor.getVariabel(2); //4000;
        int overHang3 = dataaccessor.getVariabel(7); //150;
        int overHang4 = dataaccessor.getVariabel(8); // 150;
        int stretchForBeams = (carportWidth - (overHang3 + overHang4));
        double totalNumbersBeams = (stretchForBeams + beamsDistance) / ((carport.getRoof().getBeam().getWidth() + beamsDistance));
        int totalBeamsNeeded = (int) (Math.ceil(totalNumbersBeams / 1000.0) * 1000);
        int Total = (totalBeamsNeeded / 1000) + 2; // outer sides
        return Total;
    }
    // beams are cut to custom measures 

    @Override
    public double beamsPrice(Carport carport) {
        double lenghtPrBeam = carport.getHeight();
        double totalPrice = ((lenghtPrBeam / 1000) * BeamsNeeded(carport)) * carport.getRoof().getBeam().getprice();
        return Math.round(totalPrice);
    }

    @Override
    public int calulateGabledHeight(Roof roof) {
        double roofSlope = roof.getAngle();
        double gabledHeight = (roof.getWidth() / 2) * Math.tan(Math.toRadians(roofSlope));
        int round = (int) Math.round(gabledHeight);
        return round;
    }

    @Override
    public double calculateGabledArea(Roof roof) {
        double gableheight = calulateGabledHeight(roof) / 1000;
        double gablewidth = roof.getWidth() / 1000;
        double gableAreaOneSide = (0.5 * (gableheight * gablewidth));

        return gableAreaOneSide;
    }

    @Override
    public double calculateGabledWallCoveringPrice(int boardsNeeded, double price, Roof roof) {
        // needs to calulate the number of boards needed
        int WallCoverAmount = boardsNeeded * (calulateGabledHeight(roof) / roof.getWallCovering().getLength());
        Double totalPrice = WallCoverAmount * price;
        return totalPrice;
    }

    @Override
    public int calculateGabledWallcoverAmount(Roof roof) {
        double roofside = roof.getWidth() / 2;
        // if you take one half of the roof (trekant), find the m2 (firkant), you will get the missing half to spair 
        double area = roofside * calulateGabledHeight(roof);
        double boardsNeeded = Math.ceil(roofside / roof.getWallCovering().getWidth());
        int total = (int) boardsNeeded;
        return total;
    }

    @Override
    public int roofArea(Roof roof) {
        // first we find the roofs width on one side by finding miss c (Vedhæft evt regne regler) 

        double b = roof.getWidth();
        double A = roof.getAngle();
        if (!(roof.getType().equals("Med rejsning"))) {
            int flatRoof = (int) ((b / 1000) * (roof.getLength() / 1000));
            return flatRoof;
        } else {
            //double c = (b / Math.cos(A));
            double vinkelSum = 180 - A * 2;
            double c = ((b / 1000) * (Math.sin(Math.toRadians(A)) / Math.sin(Math.toRadians(vinkelSum))));
            // then using c = as a rectangles width, the area can be calulated  
            double area = ((c * (roof.getLength() / 1000)) * 2); // * 2 because there's two sides. 
            int done = (int) Math.round(area); // no half m2. 
            return done;
        }
    }

    @Override
    public double rooftilesTotalprice(Double price, int amount) {
        double total = amount * price;
        return total;
    }

    //claus
    @Override
    public int battensNeeded(Carport carport) {
        double battensHeight = carport.getRoof().getBatten().getHeight();
        double battensDistance = 100; // This is an example. Find legislation!

        double stretchBattensOneSide = ((carport.getWidth() / 2) / Math.cos(Math.toRadians(carport.getRoof().getAngle())));
        double stretchBattensTotal = 2 * stretchBattensOneSide;
        double battensNeededDouble = ((stretchBattensTotal + battensDistance) / (battensHeight + battensDistance));
        int round = (int) Math.ceil(battensNeededDouble);
        return round;
    }

    double battensPrice(int amount, double price, Roof roof) {
        double total = (amount * (roof.getLength() / 1000) * price);
        return total;

    }

    /////////////////////////////////////////////Sheed///////////////////////////////////
    // WTF skete her... ryd op christian(mig selv) 
    @Override
    public int WallCoveringsNeededDepth(Shed shed, WoodPost woodpost) {
        //overlay used for 100 mm width wallcover => standart width
        double overlay = dataaccessor.getVariabel(5); // 150
        double shedCoverDepth = shed.getDepth() - (2 * woodpost.getWidth() - (2* dataaccessor.getVariabel(1))); // 1200
        double wallCoverWidth = shed.getWallCovering().getWidth();
        double woodPostWidth = woodpost.getWidth();
        // distance to second board 
        double MaxCover = ((2 * wallCoverWidth) + (2 * overlay));
        // when calculation placements of the board, one board is places against the woodpost inner side. 
        double distenceToCover = shedCoverDepth - wallCoverWidth;
        double wallCoverFits = distenceToCover / MaxCover;
        double nearst = (Math.ceil(wallCoverFits / 1000.0) * 1000);
        double outerCover = Math.ceil(distenceToCover / nearst);
        int Round = (int) outerCover;
        // Find ud af om næste linje er tanke torsk eller vigtig
        //int Overlay = (shedCoverDepth - finalCoverNeededtotal) / 2;
        // https://www.lav-det-selv.dk/artikler/id/76/s/1-paa-2-beklaedning
        int indercover = Round - 1;
        int totalAmount = (indercover + Round);
        return totalAmount;
    }

    @Override
    public double calculateWallCoveringPrice(int totalWallCover, double price) {
        double total = totalWallCover * price;
        return total;
    }

    @Override
    public int totalWallCoveringsNeeded(Shed shed, WoodPost woodPost) {
        int sideOne = WallCoveringsNeededDepth(shed, woodPost);
        int sideTwo = WallCoveringsNeededDepth(shed, woodPost);
        int sideThree = WallCoveringsNeededwidth(shed, woodPost);
        int sideFour = WallCoveringsNeededwidth(shed, woodPost);
        int allSides = sideOne + sideTwo + sideThree + sideFour;
        return allSides;
    }

    @Override
    public int WallCoveringsNeededwidth(Shed shed, WoodPost woodPost) {
        //overlay used for 100 mm width wallcover => standart width
        double overlay = dataaccessor.getVariabel(5); // 150
        double shedCoverWidth = shed.getWidth() - (2 * woodPost.getWidth() - (2* dataaccessor.getVariabel(1))); // 1200
        double wallCoverWidth = shed.getWallCovering().getWidth();
        double woodPostWidth = woodPost.getWidth();
        // distance to second board 
        double MaxCover = ((2 * wallCoverWidth) + (2 * overlay));
        // when calculation placements of the board, one board is places against the woodpost inner side. 
        double distenceToCover = shedCoverWidth - wallCoverWidth;
        double wallCoverFits = distenceToCover / MaxCover;
        double nearst = (Math.ceil(wallCoverFits / 1000.0) * 1000);
        double outerCover = Math.ceil(distenceToCover / nearst);
        int Round = (int) outerCover;
        // Find ud af om næste linje er tanke torsk eller vigtig
        //int Overlay = (shedCoverDepth - finalCoverNeededtotal) / 2;
        // https://www.lav-det-selv.dk/artikler/id/76/s/1-paa-2-beklaedning
        int indercover = Round - 1;
        int totalAmount = (indercover + Round);
        return totalAmount;
    }

    @Override
    public int floorArea(Shed shed) {
        int floorArea = shed.getDepth() /1000 * shed.getWidth() / 1000;
        return floorArea;
    }

    //////////////////////////////////// Carport //////////////////////////////////
    //
    @Override
    public HashMap<String, String> CalculateCarport(Carport carport) {
        HashMap<String, String> prices = new HashMap();
        // roof prices
        double beamPrice = carport.getRoof().getBeam().getTotalPrice();
        double rafterPrice = carport.getRoof().getRafter().getTotalPrice();
        double rooftilesPrice = carport.getRoof().getRooftiles().getTotalPrice();
        double battenPrice = carport.getRoof().getBatten().getTotalPrice();
        double wallcoverPrice = carport.getRoof().getWallCovering().getTotalPrice();
        double woodpostPrice = carport.getRoof().getWoodpost().getTotalPrice();
        double roofPrice = beamPrice + rafterPrice + rooftilesPrice + battenPrice + wallcoverPrice + woodpostPrice;
        // add to map
        prices.put("RoofPrice ", roofPrice + " kr");
        //  Shed prices  
        Shed Quick = carport.getShed();
        double shedPrice = Quick.getWallCovering().getTotalPrice() + Quick.getFloor().getTotalPrice();
        prices.put("ShedPrice ", shedPrice + " kr");
        double carportPrice = shedPrice + roofPrice;
        prices.put("Carport ", carportPrice + " kr");

        return prices;
    }

}
