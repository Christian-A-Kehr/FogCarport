/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.Batten;
import data.Beam;
import data.Carport;
import data.Floor;
import data.Rafter;
import data.Roof;
import data.Rooftile;
import data.Shed;
import data.WallCovering;
import data.WoodPost;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian Ambjørn Kehr
 */
public class CalculateTest {

    String type = "Med rejsning";
    int angle = 15;
    int height = 2000;
    int lenght = 4000;
    int width = 5000;
    Beam beam = new Beam("Spærtræ rem", 4000, 300, 195, 503, 4, 30, 480);
    Rafter rafter = new Rafter("Spærtræ", 5000, 100, 45, 504, 10, 20, 1000);
    WoodPost woodpost = new WoodPost("Stolpe", 2100, 250, 505, 8, 100, 800);
    Batten batten = new Batten("Lægte", 4000, 300, 100, 506, 10, 15, 600);
    Rooftile rooftile = new Rooftile("Trapezplade", 1000, 1000, 507, 20, 19.95, 399);
    WallCovering testWallcover = new WallCovering("Væg beklædning", 2000, 195, 501, 10, 100, 3000);
    Roof testRoof = new Roof(type, angle, height, lenght, width, beam, rafter, woodpost, rooftile, batten, testWallcover);
    Floor testFloor = new Floor("IBF Flise", 1000, 1000, 502, 10, 25, 1000);
    Shed testShed = new Shed(2000, 2000, testWallcover, testFloor);
    Carport testCarport = new Carport(2100, 4000, 5000, testRoof, testShed);

    Roof faltRoof = new Roof("uden rejsning", angle, height, lenght, width, beam, rafter, woodpost, rooftile, batten, testWallcover);
    public CalculateTest() {
    }

    /**
     * Test of WoodPostNeeded method, of class Calculate.
     */
    @Test
    public void testWoodPostNeeded() {
        System.out.println("WoodPostNeeded");
        Carport carport = testCarport;
        Calculate instance = new Calculate();
        int expResult = 6;
        int result = instance.WoodPostNeeded(carport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of WooPostTotalPrice method, of class Calculate.
     */
    @Test
    public void testWooPostTotalPrice() {
        System.out.println("WooPostTotalPrice");
        Carport carport = testCarport;
        Calculate instance = new Calculate();
        double expResult = 1260.0;
        double result = instance.WooPostTotalPrice(carport);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of NumbersOfRaftersFlatRoof method, of class Calculate.
     */
    @Test
    public void testNumbersOfRaftersFlatRoof() {
        System.out.println("NumbersOfRaftersFlatRoof");
        double distance = 4000;
        Calculate instance = new Calculate();
        int expResult = 6;
        int result = instance.NumbersOfRaftersFlatRoof(distance);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    @Test
     public void testNumbersOfRaftersSlopedRoof() {
        System.out.println("NumbersOfRaftersFlatRoof");
        double distance = 4000;
        Carport carport = testCarport;
        Calculate instance = new Calculate();
        int expResult = 12;
        int result = instance.NumberOfRaftersSlopedRoof(testCarport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of TotalLengthRaftersFlatRoof method, of class Calculate.
     */
    @Test
    public void testTotalLengthRaftersFlatRoof() {
        System.out.println("TotalLengthRaftersFlatRoof");
        Carport carport = testCarport;
        Calculate instance = new Calculate();
        int expResult = 30000;
        int result = instance.TotalLengthRaftersFlatRoof(carport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of TotalPriceRaftersFlatRoof method, of class Calculate.
     */
    @Test
    public void testTotalPriceRaftersFlatRoof() {
        System.out.println("TotalPriceRaftersFlatRoof");
        Carport carport = testCarport;
        Calculate instance = new Calculate();
        double expResult = 600.0;
        double result = instance.TotalPriceRaftersFlatRoof(carport);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of TotalLengthRaftersWithSlope method, of class Calculate.
     */
    @Test
    public void testTotalLengthRaftersWithSlope() {
        System.out.println("TotalLengthRaftersWithSlope");
        Carport carport = testCarport;
        Calculate instance = new Calculate();
        int expResult = 92117;
        int result = instance.TotalLengthRaftersWithSlope(carport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of TotalPriceRaftersWithSlope method, of class Calculate.
     */
    @Test
    public void testTotalPriceRaftersWithSlope() {
        System.out.println("TotalPriceRaftersWithSlope");
        Carport carport = testCarport;
        Calculate instance = new Calculate();
        double expResult = 1842.34;
        double result = instance.TotalPriceRaftersWithSlope(carport);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of BeamsNeeded method, of class Calculate.
     */
    @Test
    public void testBeamsNeeded() {
        System.out.println("BeamsNeeded");
        Carport carport = testCarport;
        double carportWith = carport.getWidth();
        double beamWith = carport.getRoof().getBeam().getWidth();
        Calculate instance = new Calculate();
        int expResult = 3;
        int result = instance.BeamsNeeded(carportWith, beamWith);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testBeamsNeededShedEndToEndIfEqual() {
        System.out.println("BeamsNeededShed");
        
        double carportWith = 4650;
        double shedWidth = carportWith;
        double beamWith = 195;
        Calculate instance = new Calculate();
        int expResult = 2;
        int result = instance.BeamsNeededShed(carportWith, shedWidth , beamWith);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

     @Test
    public void testBeamsNeededShedEndToEndIfNotEqual() {
        System.out.println("BeamsNeededShed");
        
        double carportWith = 8650;
        double shedWidth = 4650;
        double beamWith = 195;
        Calculate instance = new Calculate();
        int expResult = 3;
        int result = instance.BeamsNeededShed(carportWith, shedWidth , beamWith);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of beamsPrice method, of class Calculate.
     */
    @Test
    public void testBeamsPrice() {
        System.out.println("beamsPrice");
        Carport carport = testCarport;
        Calculate instance = new Calculate();
        double expResult = 189.0;
        double result = instance.beamsPrice(carport);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of floorArea method, of class Calculate.
     */
    @Test
    public void testFloorArea() {
        System.out.println("floorArea");
        Shed shed = testShed;
        Calculate instance = new Calculate();
        int expResult = 4;
        int result = instance.floorArea(shed);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calulateGabledHeight method, of class Calculate.
     */
    @Test
    public void testCalulateGabledHeight() {
        System.out.println("calulateGabledHeight");
        Roof roof = testRoof;
        Calculate instance = new Calculate();
        int expResult = 670;
        int result = instance.calulateGabledHeight(roof);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calculateGabledWallCoveringPrice method, of class Calculate.
     */
    @Test
    public void testCalculateGabledWallCoveringPrice() {
        System.out.println("calculateGabledWallCoveringPrice");
        int boardsNeeded = 10;
        double price = 100.0;
        Roof roof = testRoof;
        Calculate instance = new Calculate();
        double expResult = 0.0;
        double result = instance.calculateGabledWallCoveringPrice(boardsNeeded, price, roof);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calculateGabledWallcoverAmount method, of class Calculate.
     */
    @Test
    public void testCalculateGabledWallcoverAmount() {
        System.out.println("calculateGabledWallcoverAmount");
        Roof roof = testRoof;
        Calculate instance = new Calculate();
        int expResult = 13;
        int result = instance.calculateGabledWallcoverAmount(roof);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of WallCoveringsNeededDepth method, of class Calculate.
     */
    @Test
    public void testWallCoveringsNeededDepth() {
        System.out.println("WallCoveringsNeededDepth");
        Shed shed = testShed;
        WoodPost Woodpost = woodpost;
        Calculate instance = new Calculate();
        int expResult = 3;
        int result = instance.WallCoveringsNeededDepth(shed, woodpost);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calculateWallCoveringPrice method, of class Calculate.
     */
    @Test
    public void testCalculateWallCoveringPrice() {
        System.out.println("calculateWallCoveringPrice");
        int totalWallCover = 10;
        double price = 100.0;
        Calculate instance = new Calculate();
        double expResult = 1000.0;
        double result = instance.calculateWallCoveringPrice(totalWallCover, price);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of totalWallCoveringsNeeded method, of class Calculate.
     */
    @Test
    public void testTotalWallCoveringsNeeded() {
        System.out.println("totalWallCoveringsNeeded");
        Shed shed = testShed;
        WoodPost Woodpost = woodpost;
        Calculate instance = new Calculate();
        int expResult = 12;
        int result = instance.totalWallCoveringsNeeded(shed, woodpost);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of WallCoveringsNeededwidth method, of class Calculate.
     */
    @Test
    public void testWallCoveringsNeededwidth() {
        System.out.println("WallCoveringsNeededwidth");
        Shed shed = testShed;
        WoodPost Woodpost = woodpost;
        Calculate instance = new Calculate();
        int expResult = 3;
        int result = instance.WallCoveringsNeededwidth(shed, woodpost);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of roofArea method, of class Calculate.
     */
    @Test
    public void testRoofArea() {
        System.out.println("roofArea");
        Roof roof = testRoof;
        Calculate instance = new Calculate();
        int expResult = 21;
        int result = instance.roofArea(roof);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void testFlatRoofArea() {
        System.out.println("roofArea");
        Roof roof = faltRoof;
        Calculate instance = new Calculate();
        int expResult = 20;
        int result = instance.roofArea(roof);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of CalculateCarport method, of class Calculate.
     */
    @Test
    public void testCalculateCarport() {
        HashMap<String, String> newMap = new HashMap();
        newMap.put("RoofPrice ", 6279.0 + " kr");
        newMap.put("ShedPrice ", 4000.0 + " kr");
        newMap.put("Carport ", 10279.0 + " kr");

        System.out.println("CalculateCarport");
        Carport carport = testCarport;
        Calculate instance = new Calculate();
        HashMap<String, String> expResult = newMap;
        HashMap<String, String> result = instance.CalculateCarport(carport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of rooftilesTotalprice method, of class Calculate.
     */
    @Test
    public void testRooftilesTotalprice() {
        System.out.println("rooftilesTotalprice");
        Double price = 19.95;
        int amount = 20;
        Calculate instance = new Calculate();
        double expResult = 399.0;
        double result = instance.rooftilesTotalprice(price, amount);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of battensNeeded method, of class Calculate.
     */
    @Test
    public void testBattensNeeded() {
        System.out.println("battensNeeded");
        Carport carport = testCarport;
        Calculate instance = new Calculate();
        int expResult = 14;
        int result = instance.battensNeeded(carport);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of battensPrice method, of class Calculate.
     */
    @Test
    public void testBattensPrice() {
        System.out.println("battensPrice");
        int amount = 10;
        double price = 20.0;
        Roof roof = testRoof;
        Calculate instance = new Calculate();
        double expResult = 800.0;
        double result = instance.battensPrice(amount, price, roof);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
    }

}
