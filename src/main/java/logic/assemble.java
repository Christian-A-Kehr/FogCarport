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
import data.Rooftiles;
import data.Shed;
import data.WallCoverings;
import data.WoodPost;
import data.Battens;

/**
 *
 * @author Christian Ambjørn Kehr
 */
public class assemble implements AssembleInterface {

    private final Calculate CAL = new Calculate();
    private final DataAccessor DATAACC = new DataAccessor();
    private Carport carportComplte;
    private Roof roof;
    private Shed shed;
    private Rafter rafter;
    private Beam beam;
    private WoodPost woodpost;
    private WallCoverings wallCoverings;
    private Floor floor;
    private Rooftiles rooftiles;
    private Battens battens;
    private int height, lenght, width, id, amount, depth, area;
    private double price, totalPrice;
    private String material;

    // Makes a carport with a price that is the price of one ithem with can be used to calculate or list the prices  
    public Carport assembleCarport(Carport carport) {
        roof = createRoof(carport);

        if (carport.getShed().getDepth() > 0 | carport.getShed().getWidth() > 0) {
            shed = createShed(carport);
            carportComplte = new Carport(carport.getHeight(), carport.getLength(), carport.getWidth(), roof, shed);
        } else {
            carportComplte = new Carport(carport.getHeight(), carport.getLength(), carport.getWidth(), roof);
        }

        return carportComplte;
    }

   

    public Roof createRoof(Carport carport) {
        Roof quick = carport.getRoof();

        String type = quick.getType();
        material = quick.getMaterial();
        int angle = quick.getAngle();
        height = getRoofHeight(carport);
        lenght = quick.getLength();
        width = quick.getWidth();
        beam = createBeam(carport);
        rafter = createRafter(carport);
        woodpost = createWoodpost(carport);
        rooftiles = createRoofTile(quick);
        
           /////////////////////////////////////////////////////////////////////////////////////////////////
        //wallCoverings = createGabledWallcover(quick);
        roof = new Roof(type, material, angle, height, lenght, width, beam, rafter, woodpost, rooftiles, battens, wallCoverings);
        return roof;
    }
    
     public int getRoofHeight(Carport carport) {
        // How to find roof height
        if (carport.getRoof().getType().equals("Med rejsning")) {
            height = CAL.calulateGabledHeight(carport.getRoof());
        } else {
            String standartOuterRoofCover = "Ydre tagBeklædning";
            Material roofCover = DATAACC.getMaterial(standartOuterRoofCover);
            height = roofCover.getHeight(); // used fog own weppage for this standart. MODEL CAR01R 
        }
        return height;
    }

    @Override
    public Rafter createRafter(Carport carport) {
        Material mat = DATAACC.getMaterialFromId(carport.getRoof().getRafter().getId());
        Rafter Quick = carport.getRoof().getRafter();
        material = Quick.getMaterial();
        lenght = Quick.getLenght();
        height = Quick.getHeight();
        width = Quick.getWidth();
        id = Quick.getId();
        amount = CAL.TotalLengthRaftersFlatRoof(carport);
        price = mat.getPrice();
        totalPrice = CAL.rooftilesTotalprice(price, amount);

        rafter = new Rafter(material, lenght, height, width, id, amount, price, totalPrice);

        return rafter;
    }

    @Override
    public WoodPost createWoodpost(Carport carport) {
        Material mat = DATAACC.getMaterialFromId(carport.getRoof().getWoodpost().getId());
        WoodPost Quick = carport.getRoof().getWoodpost();
        material = Quick.getMaterial();
        lenght = Quick.getLength();
        height = mat.getHeight();
        width = Quick.getWidth();
        id = Quick.getId();
        price = mat.getPrice();
        amount = CAL.TotalLengthRaftersFlatRoof(carport);
        totalPrice = CAL.WooPostTotalPrice(carport);

        WoodPost woodPost = new WoodPost(material, lenght, width, id, amount, price, totalPrice);
        return woodpost;
    }

    @Override
    public Beam createBeam(Carport carport) {
        Material mat = DATAACC.getMaterialFromId(carport.getRoof().getBeam().getId());

        Beam Quick = carport.getRoof().getBeam();
        material = Quick.getMaterial();
        lenght = Quick.getLength();
        height = mat.getHeight();
        width = Quick.getWidth();
        id = Quick.getId();
        amount = CAL.TotalLengthRaftersFlatRoof(carport);
        price = mat.getPrice();
        totalPrice = CAL.beamsPrice(carport);

        beam = new Beam(material, lenght, height, width, id, amount, price, totalPrice);
        return beam;
    }

    @Override
    public Rooftiles createRoofTile(Roof roof) {
        Material mat = DATAACC.getMaterialFromId(roof.getRooftiles().getId());
        Rooftiles quick = roof.getRooftiles();
        material = quick.getMaterial();
        lenght = quick.getLenght();
        width = quick.getWidth();
        id = quick.getId();
        area = CAL.roofArea(roof) / (lenght * width);
        amount = ((int) Math.ceil(area / 100.0));
        price = mat.getPrice();
        totalPrice = CAL.rooftilesTotalprice(price, amount);

        rooftiles = new Rooftiles(material, lenght, width, id, amount, price, totalPrice);
        return rooftiles;
    }

    @Override
    public WallCoverings createGabledWallcover(Carport carport) {
        Material mat = DATAACC.getMaterialFromId(carport.getRoof().getWallCoverings().getId());
        WallCoverings quick = carport.getRoof().getWallCoverings();
        
        if (roof.getType().equals("Med rejsning")){
            area = CAL.calculateGabledArea(carport);
            
            material   = quick.getMaterial();
            lenght     = CAL.calculateGabledWallCovering(carport.getRoof());
            width      = quick.getWidth();
            id         = quick.getId();
            amount     = CAL.calculateGabledWallCovering(roof);
            price      = mat.getPrice();
            totalPrice = CAL.calculateGabledWallCovering(roof);
            wallCoverings = new WallCoverings(material, lenght, width, id, amount, price, totalPrice);
        }
        else{
            material   = quick.getMaterial();
            lenght     = CAL.calculateGabledWallCovering(carport.getRoof());
            width      = quick.getWidth();
            id         = quick.getId();
            amount     = CAL.calculateGabledWallCovering(roof);
            price      = mat.getPrice();
            totalPrice = CAL.calculateGabledWallCovering(roof);
            wallCoverings = new WallCoverings(material, lenght, width, id, amount, price, totalPrice);
        }
        return wallCoverings; 
    }
    
    
    ///////////////////////////////////////Shed////////////////////////////////////////////
    
    
    @Override
    public Shed createShed(Carport carport) {
        Material mat = DATAACC.getMaterialFromId(carport.getRoof().getRafter().getId());
        Shed Quick = carport.getShed();
        depth = Quick.getDepth();
        width = Quick.getWidth();
        wallCoverings = createWallcover(Quick.getWallCovering());
        floor = createFloor(Quick);

        shed = new Shed(depth, width, wallCoverings, floor);
        return shed;
    }

    @Override
    public WallCoverings createWallcover(WallCoverings wallCovering) {
//        Material mat = DATAACC.getMaterialFromId(wallCovering.getId());
//        material = wallCovering.getMaterial();
//        height = wallCovering.getHeight();
//        lenght = wallCovering.getLength();
//        width = wallCovering.getWidth();
//        id = wallCovering.getId();
//        price = mat.getPrice();
//        amount = CAL.totalWallCoveringsNeeded(shed);
//        totalPrice = CAL.rooftilesTotalprice(price, amount);
//
//        wallCoverings = new WallCoverings(material, height, lenght, width, id, amount, price, totalPrice);
//        return wallCoverings;
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Floor createFloor(Shed shed) {
        Material mat = DATAACC.getMaterialFromId(shed.getFloor().getId());
        Floor quick = shed.getFloor();
        material = quick.getMaterial();
        lenght = shed.getDepth();
        width = shed.getWidth();
        id = quick.getId();
        price = mat.getPrice();
        int c = CAL.floorArea(shed) / (lenght * width);
        amount = ((int) Math.ceil(c / 100.0));
        totalPrice = CAL.floorPrice(shed.getFloor());

        floor = new Floor(material, lenght, width, id, amount, price, totalPrice);
        return floor;
    }

}