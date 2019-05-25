/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.Beam;
import data.Carport;
import data.DataAccessor;
import data.Floor;
import data.Material;
import data.Rafter;
import data.Roof;
import data.Rooftile;
import data.Shed;
import data.WallCovering;
import data.WoodPost;
import data.Batten;
import data.DataUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Christian Ambjørn Kehr
 */
public class Assemble implements AssembleInterface {

    private final DataAccessor DATAACC = new DataAccessor();
    private final Calculate CAL = new Calculate();

    @Override
    public Carport AssembleCarport(Carport carport) {
        Roof roof = createRoof(carport);
        Carport carportComplte = null;

        if (carport.getShed().getDepth() > 0 | carport.getShed().getWidth() > 0) {
            try {
                Shed shed = createShed(carport);

                carportComplte = new Carport(carport.getHeight(), carport.getLength(), carport.getWidth(), roof, shed);
                return carportComplte;
            } catch (BuildException ex) {
                Logger.getLogger(Assemble.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            carportComplte = new Carport(carport.getHeight(), carport.getLength(), carport.getWidth(), roof);
            return carportComplte;
        }
        return carportComplte;
    }

    /////////////////////////////////////////////////Roof//////////////////////////////////////////////////////
    @Override
    public Roof createRoof(Carport carport) {
        Roof quick = carport.getRoof();
        Roof roof;
        String type = quick.getType();
        int angle = quick.getAngle();
        int height = getRoofHeight(carport);
        int lenght = quick.getLength();
        int width = quick.getWidth();
        Beam beam = createBeam(carport);
        Rafter rafter = createRafter(carport);
        WoodPost woodpost = createWoodpost(carport);
        Rooftile rooftile = createRoofTile(quick);

        if (carport.getRoof().getType().equals("Med rejsning")) {
            Batten batten = createBatten(carport);
            WallCovering wallCovering = createGabledWallcover(carport);
            roof = new Roof(type, angle, height, lenght, width, beam, rafter, woodpost, rooftile, batten, wallCovering);
            return roof;

        } else {
            roof = new Roof(type, angle, lenght, width, beam, rafter, woodpost, rooftile);
            return roof;
        }
    }

    // done 
    @Override
    public int getRoofHeight(Carport carport) {
        int height;
        // How to find roof height
        if (carport.getRoof().getType().equals("Med rejsning")) {
            height = CAL.calulateGabledHeight(carport.getRoof());
            return height;
        } else {
            String standartOuterRoofCover = "Ydre tagBeklædning";
            Material roofCover = DATAACC.getMaterial(standartOuterRoofCover);
            height = roofCover.getHeight(); // used fog own weppage for this standart. MODEL CAR01R 
            return height;
        }
    }

    // done 
    @Override
    public Rafter createRafter(Carport carport) {
        Material mat = DATAACC.getMaterialFromId(carport.getRoof().getRafter().getId());
        Rafter Quick = carport.getRoof().getRafter();
        Rafter rafter;
        int amount;
        double totalPrice;
        String material = Quick.getMaterial();
        int lenght = Quick.getLenght();
        int height = Quick.getHeight();
        int width = Quick.getThickness();
        int id = Quick.getId();
        int rafterFlat = CAL.NumbersOfRaftersFlatRoof(carport.getLength());
        double price = mat.getPrice();
        if (carport.getRoof().getType().equals("Med rejsning")){
        amount = CAL.NumberOfRaftersSlopedRoof(carport) + rafterFlat;
        totalPrice = CAL.TotalPriceRaftersWithSlope(carport);
        rafter = new Rafter(material, lenght, height, width, id, amount, price, totalPrice);
        return rafter;
        }
        else{
        amount = rafterFlat;
        totalPrice = CAL.TotalPriceRaftersFlatRoof(carport);
        rafter = new Rafter(material, lenght, height, width, id, amount, price, totalPrice);
        return rafter;
    }
    }
    // done
    @Override
    public WoodPost createWoodpost(Carport carport) {
        Material mat = DATAACC.getMaterialFromId(carport.getRoof().getWoodpost().getId());
        WoodPost Quick = carport.getRoof().getWoodpost();
        String material = Quick.getMaterial();
        int lenght = Quick.getLength();
        int height = carport.getHeight();
        int width = Quick.getWidth();
        int id = Quick.getId();
        double price = mat.getPrice();
        int amount = CAL.WoodPostNeeded(carport);
        double totalPrice = CAL.WooPostTotalPrice(carport);

        WoodPost woodPost = new WoodPost(material, lenght, width, id, amount, price, totalPrice);

        // return woodpost
        // hardcoded
        DataUpdater dataUp = new DataUpdater();
        Material standart = dataUp.getMaterialFromId(500);

        String Hmaterial = standart.getMaterial();
        int Hlenght = standart.getLength();
        int Hheight = mat.getHeight();
        int Hwidth = standart.getWidth();
        int Hid = standart.getMatNum();
        double Hprice = mat.getPrice();
        int Hamount = CAL.WoodPostNeeded(carport);
        double HtotalPrice = CAL.WooPostTotalPrice(carport);

        WoodPost Hardcode = new WoodPost(Hmaterial, Hlenght, Hwidth, Hid, Hamount, Hprice, HtotalPrice);

        return Hardcode;
    }

    @Override
    public Beam createBeam(Carport carport) {
        Material mat = DATAACC.getMaterialFromId(carport.getRoof().getBeam().getId());

        Beam Quick = carport.getRoof().getBeam();
        String material = Quick.getMaterial();
        int lenght = Quick.getLength();
        int height = mat.getHeight();
        int width = Quick.getWidth();
        int id = Quick.getId();
        int amount = CAL.BeamsNeeded(carport);
        double price = mat.getPrice();
        double totalPrice = CAL.beamsPrice(carport);

        Beam beam = new Beam(material, lenght, height, width, id, amount, price, totalPrice);
        return beam;
    }

    @Override
    public Rooftile createRoofTile(Roof roof) {
        Material mat = DATAACC.getMaterialFromId(roof.getRooftiles().getId());
        Rooftile quick = roof.getRooftiles();
        String material = quick.getMaterial();
        int lenght = quick.getLenght();
        int width = quick.getWidth();
        int id = quick.getId();
        int area = CAL.roofArea(roof) / (lenght * width);
        int amount = ((int) Math.ceil(area / 100.0));
        double price = mat.getPrice();
        double totalPrice = CAL.rooftilesTotalprice(price, amount);

        Rooftile rooftiles = new Rooftile(material, lenght, width, id, amount, price, totalPrice);
        return rooftiles;
    }

    //  Hardcoded shit incomming
    @Override
    public WallCovering createGabledWallcover(Carport carport) {
        // Lav understående bruger input for det fucker med koden man skal hardcode det lort!

//        Material mat = DATAACC.getMaterialFromId(carport.getRoof().getWallCovering().getId());
//        WallCovering quick = carport.getRoof().getWallCovering();
        // fuck up plan... bruger oversåtende hvis du får tid til at lave det ordenligt 
        int Standart = 501;
        WallCovering quick = new WallCovering("Væg beklædning", 0, 100, 10);
        DataUpdater dataUP = new DataUpdater();
        Material mat = dataUP.getMaterialFromId(Standart);
        if (carport.getRoof().getType().equals("Med rejsning")) {
            String material = quick.getMaterial();
            int lenght = quick.getLength();
            int width = quick.getWidth();
            int id = quick.getId();
            int amount = CAL.calculateGabledWallcoverAmount(carport.getRoof());
            double price = mat.getPrice();
            double totalPrice = CAL.calculateGabledWallCoveringPrice(amount, price, carport.getRoof());
            WallCovering wallCovering = new WallCovering(material, lenght, width, id, amount, price, totalPrice);
            return wallCovering;
        } else {
            String material = quick.getMaterial();
            int lenght = carport.getLength() * 2;
            int width = carport.getWidth() * 2;
            int id = quick.getId();
            int amount = 4;
            double price = mat.getPrice();
            double totalPrice = lenght + width * price;
            WallCovering wallCovering = new WallCovering(material, lenght, width, id, amount, price, totalPrice);
            return wallCovering;
        }
    }

    @Override
    public Batten createBatten(Carport carport) {
        // lægte spærtræ = hardcoded burde være i variabler 
        Material mat = DATAACC.getMaterial("Lægte Spærtræ");
        //getMaterialFromId(carport.getRoof().getBatten().getId());
        //Batten quick = carport.getRoof().getBatten();
        
        String material = "Lægte Spærtræ";
        int lenght = carport.getWidth();
        int height = mat.getHeight();
        int width = mat.getWidth();
        int id = carport.getRoof().getBatten().getId();
        int amount = CAL.battensNeeded(carport);
        double price = mat.getPrice();
        double totalPrice = CAL.battensPrice(amount, price, carport.getRoof());
        Batten batten = new Batten(material, lenght, height, width, id, amount, price, totalPrice);
        return batten;

    }

    ///////////////////////////////////////Shed////////////////////////////////////////////
    @Override
    public Shed createShed(Carport carport) throws BuildException {
        Shed shed = null;
        if (carport.getShed().getWidth() == 0 && carport.getShed().getDepth() == 0) {
            throw new BuildException("Build faild at shed");
        } else {
            try {

                Material mat = DATAACC.getMaterialFromId(carport.getRoof().getRafter().getId());
                Shed Quick = carport.getShed();
                int depth = Quick.getDepth();
                int width = Quick.getWidth();
                WallCovering wallCovering = createWallcover(carport);
                Floor floor = createFloor(Quick);

                shed = new Shed(depth, width, wallCovering, floor);
                return shed;
            } catch (Exception e) {
            }
        }
        return shed;
    }

    @Override
    public WallCovering createWallcover(Carport carport) {
        WallCovering quick = carport.getShed().getWallCovering();
        Material mat = DATAACC.getMaterialFromId(quick.getId());

        String material = quick.getMaterial();
        int width = quick.getWidth();
        int lenght = carport.getHeight();
        int id = quick.getId();
        int amount = CAL.totalWallCoveringsNeeded(carport.getShed(), carport.getRoof().getWoodpost());
        double price = mat.getPrice();
        double totalPrice = CAL.rooftilesTotalprice(price, amount);

        WallCovering wallCoverings = new WallCovering(material, lenght, width, id, amount, price, totalPrice);
        // Forced to make hardcoded solution, not optimal. 
        return wallCoverings;
    }

    @Override
    public Floor createFloor(Shed shed) {
        Material mat = DATAACC.getMaterialFromId(shed.getFloor().getId());
        Floor quick = shed.getFloor();
        String material = quick.getMaterial();
        int lenght = shed.getDepth();
        int width = shed.getWidth();
        int id = quick.getId();
        Double price = mat.getPrice();
        int c = CAL.floorArea(shed) / (lenght * width);
        int amount = ((int) Math.ceil(c / 100.0));
        Double totalPrice = amount * price;

        Floor floor = new Floor(material, lenght, width, id, amount, price, totalPrice);
        return floor;
    }

}
