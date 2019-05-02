/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Christian Ambjørn Kehr
 */
public class Shed {
    private double depth, width; 
    private WallCoverings wallCovering;
    private Floor floor;

    public Shed(double depth, double width, WallCoverings wallCovering, Floor floor) {
        this.depth = depth;
        this.width = width;
        this.wallCovering = wallCovering;
        this.floor = floor;
    }

    public double getDepth() {
        return depth;
    }

    public double getWidth() {
        return width;
    }

    public WallCoverings getWallCovering() {
        return wallCovering;
    }

    public Floor getFloor() {
        return floor;
    }
    
}
