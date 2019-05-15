/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.Beam;
import data.Carport;
import data.Floor;
import data.Material;
import data.Rafter;
import data.Roof;
import data.Shed;
import data.WallCovering;
import data.WoodPost;
import data.Rooftile;

/**
 *
 * @author Christian Ambjørn Kehr
 */
public interface AssembleInterface {

    public Carport assembleCarport(Carport carport);

    public int getRoofHeight(Carport carport);

    public Roof createRoof(Carport carport);

    public Shed createShed(Carport carport);

    public Rafter createRafter(Carport carport);

    public WoodPost createWoodpost(Carport carport);

    public Beam createBeam(Carport carport);

    public WallCovering createWallcover(Carport carport);

    public WallCovering createGabledWallcover(Carport carport);

    public Floor createFloor(Shed shed);

    public Rooftile createRoofTile(Roof roof);
}
