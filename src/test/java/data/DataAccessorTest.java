/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Christian Ambjørn Kehr
 */
public class DataAccessorTest /*extends junit.extensions.Dbunit*/{
    
    public DataAccessorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class DataAccessor.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        DataAccessor.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllCupCakes method, of class DataAccessor.
     */
    @Test
    public void testGetAllCupCakes() {
        System.out.println("getAllCupCakes");
        ArrayList<CompleteCupCake> expResult = null;
        ArrayList<CompleteCupCake> result = DataAccessor.getAllCupCakes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllMaterials method, of class DataAccessor.
     */
    @Test
    public void testGetAllMaterials() {
        System.out.println("getAllMaterials");
        DataAccessor instance = new DataAccessor();
        ArrayList<Material> expResult = null;
        ArrayList<Material> result = instance.getAllMaterials();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetListSpecificMaterials method, of class DataAccessor.
     */
    @Test
    public void testGetListSpecificMaterials() {
        System.out.println("GetListSpecificMaterials");
        String name = "";
        DataAccessor instance = new DataAccessor();
        ArrayList<Material> expResult = null;
        ArrayList<Material> result = instance.GetListSpecificMaterials(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaterial method, of class DataAccessor.
     */
    @Test
    public void testGetMaterial() {
        System.out.println("getMaterial");
        String name = "";
        DataAccessor instance = new DataAccessor();
        Material expResult = null;
        Material result = instance.getMaterial(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOffer method, of class DataAccessor.
     */
    @Test
    public void testGetOffer() {
        System.out.println("getOffer");
        int Id = 0;
        DataAccessor instance = new DataAccessor();
        Offer expResult = null;
        Offer result = instance.getOffer(Id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarport method, of class DataAccessor.
     */
    @Test
    public void testGetCarport() {
        System.out.println("getCarport");
        int Id = 0;
        DataAccessor instance = new DataAccessor();
        Carport expResult = null;
        Carport result = instance.getCarport(Id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRoof method, of class DataAccessor.
     */
    @Test
    public void testGetRoof() {
        System.out.println("getRoof");
        String name = "";
        DataAccessor instance = new DataAccessor();
        Roof expResult = null;
        Roof result = instance.getRoof(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomer method, of class DataAccessor.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        String name = "";
        DataAccessor instance = new DataAccessor();
        Customer expResult = null;
        Customer result = instance.getCustomer(name);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
