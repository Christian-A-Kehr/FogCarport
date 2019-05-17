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

        String type = quick.getType();
        int angle = quick.getAngle();
        int height = getRoofHeight(carport);
        int lenght = quick.getLength();
        int width = quick.getWidth();
        Beam beam = createBeam(carport);
        Rafter rafter = createRafter(carport);
        WoodPost woodpost = createWoodpost(carport);
        Batten batten = createBatten(carport);

        Rooftile rooftile = createRoofTile(quick);

        WallCovering wallCovering = createGabledWallcover(carport);
        Roof roof = new Roof(type, angle, height, lenght, width, beam, rafter, woodpost, rooftile, batten, wallCovering);
        return roof;
    }

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

    @Override
    public Rafter createRafter(Carport carport) {
        Material mat = DATAACC.getMaterialFromId(carport.getRoof().getRafter().getId());
        Rafter Quick = carport.getRoof().getRafter();
        String material = Quick.getMaterial();
        int lenght = Quick.getLenght();
        int height = Quick.getHeight();
        int width = Quick.getThickness();
        int id = Quick.getId();
        int amount = CAL.TotalLengthRaftersFlatRoof(carport);
        double price = mat.getPrice();
        double totalPrice = CAL.rooftilesTotalprice(price, amount);

        Rafter rafter = new Rafter(material, lenght, height, width, id, amount, price, totalPrice);

        return rafter;
    }

    @Override
    public WoodPost createWoodpost(Carport carport) {
        Material mat = DATAACC.getMaterialFromId(carport.getRoof().getWoodpost().getId());
        WoodPost Quick = carport.getRoof().getWoodpost();
        String material = Quick.getMaterial();
        int lenght = Quick.getLength();
        int height = mat.getHeight();
        int width = Quick.getWidth();
        int id = Quick.getId();
        double price = mat.getPrice();
        int amount = CAL.TotalLengthRaftersFlatRoof(carport);
        double totalPrice = CAL.WooPostTotalPrice(carport);

        WoodPost woodPost = new WoodPost(material, lenght, width, id, amount, price, totalPrice);
        return woodPost;
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
        int amount = CAL.TotalLengthRaftersFlatRoof(carport);
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

    @Override
    public WallCovering createGabledWallcover(Carport carport) {
        Material mat = DATAACC.getMaterialFromId(carport.getRoof().getWallCovering().getId());
        WallCovering quick = carport.getRoof().getWallCovering();

        if (carport.getRoof().getType().equals("Med rejsning")) {
            int area = CAL.calculateGabledArea(carport);

            String material = quick.getMaterial();
            int lenght = CAL.calculateGabledWallCovering(carport.getRoof());
            int width = quick.getWidth();
            int id = quick.getId();
            int amount = CAL.calculateGabledWallCovering(carport.getRoof());
            double price = mat.getPrice();
            double totalPrice = CAL.calculateGabledWallCovering(carport.getRoof());
            WallCovering wallCovering = new WallCovering(material, lenght, width, id, amount, price, totalPrice);
            return wallCovering;
        } else {
            String material = quick.getMaterial();
            int lenght = CAL.calculateGabledWallCovering(carport.getRoof());
            int width = quick.getWidth();
            int id = quick.getId();
            int amount = CAL.calculateGabledWallCovering(carport.getRoof());
            double price = mat.getPrice();
            double totalPrice = CAL.calculateGabledWallCovering(carport.getRoof());
            WallCovering wallCovering = new WallCovering(material, lenght, width, id, amount, price, totalPrice);
            return wallCovering;
        }
    }

    @Override
    public Batten createBatten(Carport carport) {
        Material mat = DATAACC.getMaterialFromId(carport.getRoof().getBatten().getId());
        Batten quick = carport.getRoof().getBatten();
        Batten batter;
        if (carport.getRoof().getType().equals("Med rejsning")) {
            int area = CAL.calculateGabledArea(carport);

            String material = quick.getMaterial();
            int lenght = carport.getWidth();
            int height = mat.getHeight();
            int width = mat.getWidth();
            int id = carport.getRoof().getBatten().getId();
            int amount = CAL.battensNeeded(carport);
            double price = mat.getPrice();
            double totalPrice = CAL.calculateGabledWallCovering(carport.getRoof());
            Batten batten = new Batten(material, lenght, height, width, id, amount, price, totalPrice);
            return batten;
        } else {
            String material = quick.getMaterial();
            int lenght = quick.getLenght();
            int width = quick.getWidth();
            int id = quick.getId();
            int amount = CAL.battensNeeded(carport);
            double price = mat.getPrice();
            double totalPrice = amount * price;
            Batten batten = new Batten(material, lenght, width, width, id, amount, price, totalPrice);
            return batten;
        }
    }

    ///////////////////////////////////////Shed////////////////////////////////////////////
    @Override
    public Shed createShed(Carport carport) throws BuildException{
        Shed shed = null;
        if (carport.getShed().getWidth() == 0 && carport.getShed().getDepth() == 0){
            throw new BuildException("Build faild at shed");
        }
        else{
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
        int amount = CAL.totalWallCoveringsNeeded(carport.getShed());
        double price = mat.getPrice();
        double totalPrice = CAL.rooftilesTotalprice(price, amount);

        WallCovering wallCoverings = new WallCovering(material, lenght, width, id, amount, price, totalPrice);
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
        Double totalPrice = CAL.floorPrice(shed.getFloor());

        Floor floor = new Floor(material, lenght, width, id, amount, price, totalPrice);
        return floor;
    }
    
}
