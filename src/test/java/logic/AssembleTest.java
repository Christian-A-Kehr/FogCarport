///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package logic;
//
//import data.Batten;
//import data.Beam;
//import data.Carport;
//import data.Floor;
//import data.Rafter;
//import data.Roof;
//import data.Rooftile;
//import data.Shed;
//import data.WallCovering;
//import data.WoodPost;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author Christian Ambjørn Kehr
// */
//public class AssembleTest {
//    String type = "Med rejsning";
//    int angle = 15;
//    int height = 2000;
//    int lenght = 4000;
//    int width = 5000;
//    Beam beam = new Beam("Spærtræ rem", 4000, 300, 195, 503, 4, 30, 480);
//    Rafter rafter = new Rafter("Spærtræ", 5000, 100, 45, 504, 10, 20, 1000);
//    WoodPost woodpost = new WoodPost("Stolpe", 2100, 250, 505, 8, 100, 800);
//    Batten batten = new Batten("Lægte", 4000, 300, 100, 506, 10, 15, 600);
//    Rooftile rooftile = new Rooftile("Trapezplade", 1000, 1000, 507, 20, 19.95, 399);
//    WallCovering testWallcover = new WallCovering("Væg beklædning", 2000, 195, 501, 10, 100, 3000);
//    Roof testRoof = new Roof(type, angle, height, lenght, width, beam, rafter, woodpost, rooftile, batten, testWallcover);
//    Floor testFloor = new Floor("IBF Flise", 1000, 1000, 502, 10, 25, 1000);
//    Shed testShed = new Shed(2000, 2000, testWallcover, testFloor);
//    Carport testCarport = new Carport(2100, 4000, 5000, testRoof, testShed);
//
//    Roof faltRoof = new Roof("uden rejsning", angle, height, lenght, width, beam, rafter, woodpost, rooftile, batten, testWallcover);
//    public AssembleTest() {
//    }
//
//    /**
//     * Test of AssembleCarport method, of class Assemble.
//     */
//    @Test
//    public void testAssembleCarport() {
//        System.out.println("AssembleCarport");
//        Carport carport = testCarport;
//        Assemble instance = new Assemble();
//        Carport expResult = null;
//        Carport result = instance.AssembleCarport(carport);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createRoof method, of class Assemble.
//     */
//    @Test
//    public void testCreateRoof() {
//        System.out.println("createRoof");
//        Carport carport = testCarport;
//        Assemble instance = new Assemble();
//        Roof expResult = null;
//        Roof result = instance.createRoof(carport);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createRoofViaShed method, of class Assemble.
//     */
//    @Test
//    public void testCreateRoofViaShed() {
//        System.out.println("createRoofViaShed");
//        Carport carport = testCarport;
//        Shed shed = null;
//        Assemble instance = new Assemble();
//        Roof expResult = null;
//        Roof result = instance.createRoofViaShed(carport, shed);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getRoofHeight method, of class Assemble.
//     */
//    @Test
//    public void testGetRoofHeight() {
//        System.out.println("getRoofHeight");
//        Carport carport = testCarport;
//        Assemble instance = new Assemble();
//        int expResult = 0;
//        int result = instance.getRoofHeight(carport);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createRafter method, of class Assemble.
//     */
//    @Test
//    public void testCreateRafter() {
//        System.out.println("createRafter");
//        Carport carport = testCarport;
//        Assemble instance = new Assemble();
//        Rafter expResult = null;
//        Rafter result = instance.createRafter(carport);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createWoodpost method, of class Assemble.
//     */
//    @Test
//    public void testCreateWoodpost() {
//        System.out.println("createWoodpost");
//        Carport carport = testCarport;
//        Assemble instance = new Assemble();
//        WoodPost expResult = null;
//        WoodPost result = instance.createWoodpost(carport);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createWoodpostViaShed method, of class Assemble.
//     */
//    @Test
//    public void testCreateWoodpostViaShed() {
//        System.out.println("createWoodpostViaShed");
//        Carport carport = testCarport;
//        Assemble instance = new Assemble();
//        WoodPost expResult = null;
//        WoodPost result = instance.createWoodpostViaShed(carport);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createBeam method, of class Assemble.
//     */
//    @Test
//    public void testCreateBeam() {
//        System.out.println("createBeam");
//        Carport carport = testCarport;
//        Assemble instance = new Assemble();
//        Beam expResult = null;
//        Beam result = instance.createBeam(carport);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createBeamViaShed method, of class Assemble.
//     */
//    @Test
//    public void testCreateBeamViaShed() {
//        System.out.println("createBeamViaShed");
//        Carport carport = testCarport;
//        Assemble instance = new Assemble();
//        Beam expResult = null;
//        Beam result = instance.createBeamViaShed(carport);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createRoofTile method, of class Assemble.
//     */
//    @Test
//    public void testCreateRoofTile() {
//        System.out.println("createRoofTile");
//        Roof roof = testRoof;
//        Assemble instance = new Assemble();
//        Rooftile expResult = null;
//        Rooftile result = instance.createRoofTile(roof);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createGabledWallcover method, of class Assemble.
//     */
//    @Test
//    public void testCreateGabledWallcover() {
//        System.out.println("createGabledWallcover");
//        Carport carport = testCarport;
//        Assemble instance = new Assemble();
//        WallCovering expResult = null;
//        WallCovering result = instance.createGabledWallcover(carport);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createBatten method, of class Assemble.
//     */
//    @Test
//    public void testCreateBatten() {
//        System.out.println("createBatten");
//        Carport carport = testCarport;
//        Assemble instance = new Assemble();
//        Batten expResult = null;
//        Batten result = instance.createBatten(carport);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createShed method, of class Assemble.
//     */
//    @Test
//    public void testCreateShed() throws Exception {
//        System.out.println("createShed");
//        Carport carport = testCarport;
//        Assemble instance = new Assemble();
//        Shed expResult = null;
//        Shed result = instance.createShed(carport);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createWallcover method, of class Assemble.
//     */
//    @Test
//    public void testCreateWallcover() {
//        System.out.println("createWallcover");
//        Carport carport = testCarport;
//        Assemble instance = new Assemble();
//        WallCovering expResult = null;
//        WallCovering result = instance.createWallcover(carport);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createFloor method, of class Assemble.
//     */
//    @Test
//    public void testCreateFloor() {
//        System.out.println("createFloor");
//        Shed shed = testShed;
//        Assemble instance = new Assemble();
//        Floor expResult = null;
//        Floor result = instance.createFloor(shed);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
//}
