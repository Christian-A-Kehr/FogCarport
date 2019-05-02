/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Christan Ambjørn Kehr
 */
public class Carport {
    double height, length, width;
    Roof roof;
    Shed shed;

    public Carport(double height, double length, double width, Roof roof, Shed shed) {
        this.height = height;
        this.length = length;
        this.width = width;
        this.roof = roof;
        this.shed = shed;
    }

    public Carport(double height, double length, double width, Roof roof) {
        this.height = height;
        this.length = length;
        this.width = width;
        this.roof = roof;
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

    public Roof getRoof() {
        return roof;
    }

    public Shed getShed() {
        return shed;
    }
      
}
