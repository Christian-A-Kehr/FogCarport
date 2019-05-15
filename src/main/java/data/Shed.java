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
    private int depth, width; 
    private WallCovering wallCovering;
    private Floor floor;

    public Shed(int depth, int width, WallCovering wallCovering, Floor floor) {
        this.depth = depth;
        this.width = width;
        this.wallCovering = wallCovering;
        this.floor = floor;
    }

    public int getDepth() {
        return depth;
    }

    public int getWidth() {
        return width;
    }

    public WallCovering getWallCovering() {
        return wallCovering;
    }

    public Floor getFloor() {
        return floor;
    }
    
}
