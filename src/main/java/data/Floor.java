/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Christian
 */
public class Floor {
    private String name;
    private double height, length, width, M2price;

    public Floor(String name, double height, double length, double width, double M2price) {
        this.name = name;
        this.height = height;
        this.length = length;
        this.width = width;
        this.M2price = M2price;
    }

    public String getName() {
        return name;
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

    public double getM2price() {
        return M2price;
    }
    
    
}
