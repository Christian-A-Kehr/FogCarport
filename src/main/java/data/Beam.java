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
public class Beam {
 private String material;
 private int length, height, width; 
 private double Mprice;

    public Beam(String material, int length, int height, int width, double Mprice) {
        this.material = material;
        this.length = length;
        this.height = height;
        this.width = width;
        this.Mprice = Mprice;
    }

    public Beam(String material, int length) {
        this.material = material;
        this.length = length;
    }

    public String getMaterial() {
        return material;
    }

    public int getLength() {
        return length;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public double getMprice() {
        return Mprice;
    }
 
   
}
