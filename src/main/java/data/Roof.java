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
public class Roof {
   
    private String type, material;     
    private int angle, height, length, width;
    private Beam beam;
    private Rafter rafter;
    private WoodPost woodpost;

    public Roof(String type, String material, int angle, int height, int length, int width, Beam beam, Rafter rafter, WoodPost woodpost) {
        this.type = type;
        this.material = material;
        this.angle = angle;
        this.height = height;
        this.length = length;
        this.width = width;
        this.beam = beam;
        this.rafter = rafter;
        this.woodpost = woodpost;
    }

    public String getType() {
        return type;
    }

    public String getMaterial() {
        return material;
    }

    public int getAngle() {
        return angle;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public Beam getBeam() {
        return beam;
    }

    public Rafter getRafter() {
        return rafter;
    }

    public WoodPost getWoodpost() {
        return woodpost;
    }
    
         // setters used when calculating missing parameters or getteing them from carport class. 

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }
   

    }
       
    
