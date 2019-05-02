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
public class WallCoverings {
    private String name;
    private double height, length, width, Mprice;

    public WallCoverings(String name, double height, double length, double width, double Mprice) {
        this.name = name;
        this.height = height;
        this.length = length;
        this.width = width;
        this.Mprice = Mprice;
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

    public double getMprice() {
        return Mprice;
    }

  
    
}
