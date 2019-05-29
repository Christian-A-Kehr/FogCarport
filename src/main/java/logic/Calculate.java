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
 */
public class Calculate implements CalculateInterface {
//huske at slette noteform i comamnd

    private DataAccessor dataaccessor = new DataAccessor();
    // roof. length 0,8 + 0,3 

    /////////////////////////////////roof///////////////////////////////////////////////
    /**
     *
     * @param carport takes a carport and produces the amount of woodpost needed
     * @return
     */
    @Override
    public int WoodPostNeeded(Carport carport) {
        double standartWoodpostwidth = dataaccessor.getVariabel(6);
        double carportLength = carport.getLength();
        double beamWidth = dataaccessor.getMaterialFromId(carport.getRoof().getBeam().getId()).getWidth();
        double woodPostsDistance = dataaccessor.getVariabel(2); // 4000 mm
        double overHang1 = dataaccessor.getVariabel(1); // 150 mm
        double overHang2 = dataaccessor.getVariabel(1); // 150 mm
        double stretchForWoodposts = (carportLength - (overHang1 + overHang2));
        double totalNumberwoodpostsDouble = (stretchForWoodposts + woodPostsDistance) / (standartWoodpostwidth + woodPostsDistance) * BeamsNeeded(carport.getWidth(), beamWidth);
        int rounded = (int) Math.ceil(totalNumberwoodpostsDouble);
        return rounded;
    }

    /**
     * uses assemble method to produce amount of woodpost needed in a carport
     * with a shed Can be used with woodpost need to finde total amount.
     *
     * @param roof Dimension of the roof
     * @param shed
     * @return
     */
    public int WoodPostNeededViaShed(Roof roof, Shed shed) {
        double standartWoodpostwidth = dataaccessor.getVariabel(6);
        double carportLength = roof.getLength();
        double beamWidth = dataaccessor.getMaterialFromId(roof.getBeam().getId()).getWidth();
        double woodPostsDistance = dataaccessor.getVariabel(2); // 4000 mm
        double overHang1 = dataaccessor.getVariabel(1); // 150 mm
        double overHang2 = dataaccessor.getVariabel(1); // 150 mm
        double stretchForWoodposts = (carportLength - (overHang1 + overHang2));
        double totalNumberwoodpostsDouble = (stretchForWoodposts + woodPostsDistance) / (roof.getWoodpost().getWidth() + woodPostsDistance) * BeamsNeeded(roof.getWidth(), beamWidth);
        int rounded = (int) Math.ceil(totalNumberwoodpostsDouble);
        return rounded;
    }

    /**
     * Findes the price, when comparring lenght and amount of woodpost neede. is
     * /1000 to get mm.
     *
     * @param carport needed for the height
     * @return
     */
    @Override
    public double WooPostTotalPrice(Carport carport) {
        Material mat = dataaccessor.getMaterialFromId(6);
        double totalPrice = WoodPostNeeded(carport) * (carport.getHeight() / 1000) * mat.getPrice();
        return totalPrice;
    }

    /**
     * 
     * @param Distance 
     * @return
     */
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
        double totalLength = (NumbersOfRaftersFlatRoof(carport.getLength()) * carport.getWidth());
        int round = (int) Math.round(totalLength);
        return round;
    }

    @Override
    public double TotalPriceRaftersFlatRoof(Carport carport) {
        double rafterPrice = dataaccessor.getMaterialFromId(8).getPrice();
        double totalRafterPrice = (TotalLengthRaftersFlatRoof(carport) / 1000) * rafterPrice; // Der divideres med 1000 for at kunne gange med meterprisen.
        return totalRafterPrice;

    }

    //TEST DENNE PGA INT cast Vigtigt! 
    @Override
    public int TotalLengthRaftersWithSlope(Carport carport) {
        double lengthSingleRafterWithSlope = ((carport.getWidth() / 2) / Math.cos(Math.toRadians(carport.getRoof().getAngle()))); // Der ganges med 0,5 for at kunne danne en retvinklet trekant. 
        // Derefter findes længden af c via formlen c = b * cos(A).
        double lengthBothSidesWithSlope = 2 * lengthSingleRafterWithSlope;                                      // Der ganges med to for at få længden af begge hældningssider.
        double totalLength = (NumberOfRaftersSlopedRoof(carport) * lengthBothSidesWithSlope) + TotalLengthRaftersFlatRoof(carport); // Antal spær ganges med længden 
        // af de to hældningssider. Resultatet plusses
        // med den samlede længde af de flade spær.
        int round = (int) Math.round(totalLength);
        return round;
    }

    // er det her noget hejs, kan man bare gør som med fladt tag eller overser jeg noget
    @Override
    public int NumberOfRaftersSlopedRoof(Carport carport) {
        int number = NumbersOfRaftersFlatRoof(carport.getLength()) * 2; // 3 because 2 ekstra rafters is add pr rafter.  
        return Math.round(number);
    }

    @Override
    public double TotalPriceRaftersWithSlope(Carport carport) {
        double lenght = TotalLengthRaftersWithSlope(carport);
        double totalprice = (lenght / 1000) * carport.getRoof().getRafter().getMprice();  // // Der divideres med 1000 for at kunne gange med meterprisen.
        return Math.round(totalprice);

    }

    @Override
    public int BeamsNeeded(double DistianceWith, double BeamWidth) {
        double coveringDistances = DistianceWith;
        double beamsDistance = dataaccessor.getVariabel(2); //4000;
        double overHang3 = dataaccessor.getVariabel(1); //150;
        double overHang4 = dataaccessor.getVariabel(1); // 150;
        double stretchForBeams = (coveringDistances - (overHang3 + overHang4));
        double totalNumbersBeams = (stretchForBeams + beamsDistance) / ((BeamWidth + beamsDistance));
        int totalBeamsNeeded = (int) (Math.ceil(totalNumbersBeams / 1000.0) * 1000);
        int Total = (totalBeamsNeeded / 1000) + 2; // outer sides
        return Total;
    }

    @Override
    public int BeamsNeededShed(double carportWidth, double shedWidth, double beamWidth) {
        double coveringDistances = carportWidth;
        double beamsDistance = dataaccessor.getVariabel(2); //4000;
        double overhang;
        // overhang in one or two sides
        if (coveringDistances == shedWidth) {
            overhang = dataaccessor.getVariabel(1) * 2; //300
        } else {
            overhang = dataaccessor.getVariabel(1);
        }
        double stretchForBeams = (shedWidth - (overhang));
        double totalNumbersBeams = (stretchForBeams + beamsDistance) / ((beamWidth + beamsDistance));
        int totalBeamsNeeded = (int) (Math.ceil(totalNumbersBeams));
        int Total = (totalBeamsNeeded / 1000) + 2; // outer sides
        return totalBeamsNeeded;
        //return Total;
    }

    // beams are cut to custom measures 
    /**
     * BeamsPrice can calulates the Total price for at carport, its made so that
     * it can be called from outside of Assembl class
     *
     * @param carport The carport that needs to be calcualeted
     * @return
     */
    @Override
    public double beamsPrice(Carport carport) {
        Material mat = dataaccessor.getMaterialFromId(carport.getRoof().getBeam().getId());
        double carportWidth = carport.getWidth();
        double beamWidth = mat.getWidth();
        double lenghtPrBeam = carport.getHeight();
        double totalPrice = ((lenghtPrBeam / 1000) * BeamsNeeded(carportWidth, beamWidth)) * mat.getPrice();
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

    /**
     * Calculate price for none flat roof
     *
     * @param boardsNeeded amount of wallcoverPart needed to cover the roof
     * @param price the price for 1 wallcoverPart
     * @param roof needs roof to calculate a roofHeight
     * @return
     */
    @Override
    public double calculateGabledWallCoveringPrice(int boardsNeeded, double price, Roof roof) {
        // needs to calulate the number of boards needed
        Material material = dataaccessor.getMaterialFromId(roof.getWallCovering().getId());
        Material mat = dataaccessor.getMaterialFromId(4);
        double WallCoverAmount = boardsNeeded * (calulateGabledHeight(roof) / mat.getLength());
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
        if (roof.getType().equals("Med rejsning")) {
            //double c = (b / Math.cos(A));
            double vinkelSum = 180 - A * 2;
            double c = ((b / 1000) * (Math.sin(Math.toRadians(A)) / Math.sin(Math.toRadians(vinkelSum))));
            // then using c = as a rectangles width, the area can be calulated  
            double area = ((c * (roof.getLength() / 1000)) * 2); // * 2 because there's two sides. 
            int done = (int) Math.round(area); // no half m2. 
            return done;
        } else {
            int flatRoof = (int) ((b / 1000) * (roof.getLength() / 1000));
            return flatRoof;
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
        Material mat = dataaccessor.getMaterialFromId(18); // standart
        double battensHeight = mat.getHeight();
        double battensDistance = 100;

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
        double woodpostwidth = dataaccessor.getMaterialFromId(6).getWidth();

        double overlay = dataaccessor.getVariabel(5); // 150
        double shedCoverDepth = shed.getDepth() - (2 * woodpostwidth - (2 * dataaccessor.getVariabel(1))); // 1200
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
        double shedCoverWidth = shed.getWidth() - (2 * woodPost.getWidth() - (2 * dataaccessor.getVariabel(1))); // 1200
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
        int floorArea = (shed.getDepth() / 1000) * (shed.getWidth() / 1000);
        return floorArea;
    }

    //////////////////////////////////// Carport //////////////////////////////////
    //
    @Override
    public HashMap<String, Double> CalculateCarport(Carport carport) {
        Assemble assemble = new Assemble();
        HashMap<String, Double> prices = new HashMap();
        // roof prices
        double beamPrice = carport.getRoof().getBeam().getTotalPrice();
        double rafterPrice = carport.getRoof().getRafter().getTotalPrice();
        double rooftilesPrice = carport.getRoof().getRooftiles().getTotalPrice();
//        double battenPrice = battensPrice(carport.getRoof().getBatten().getAmount() , carport.getRoof().getBatten().getPrice() , carport.getRoof());
//        double wallcoverPrice = calculateGabledWallCoveringPrice(carport.getRoof().getWallCovering().getAmount(), carport.getRoof().getWallCovering().getPrice(), carport.getRoof());
        double woodpostPrice = carport.getRoof().getWoodpost().getTotalPrice();
        double roofPrice = beamPrice + rafterPrice + rooftilesPrice /* + battenPrice  + wallcoverPrice*/ + woodpostPrice;
        // add to map
        prices.put("RoofPrice", roofPrice);
        //  Shed prices  
        Shed Quick = carport.getShed();
        double shedPrice = Quick.getWallCovering().getTotalPrice() + Quick.getFloor().getTotalPrice();
        prices.put("ShedPrice", shedPrice);
        double carportPrice = shedPrice + roofPrice;
        prices.put("CarportPrice", carportPrice);

        return prices;
    }

}
