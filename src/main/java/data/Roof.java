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
   
    private String type, matrial;     
    private int angle;
    private double height, length, width; 
    private Beam beam;
    private Rafter rafter;

    public String getType() {
        return type;
    }

    public String getMatrial() {
        return matrial;
    }

    public int getAngle() {
        return angle;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public Beam getBeam() {
        return beam;
    }

    public Rafter getRafter() {
        return rafter;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
        // setters used when calculating missing parameters or getteing them from carport class. 
    
    public void setHeight(double height) {
        this.height = height;
    }
        // set frem carport class
    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    
    
    


}
