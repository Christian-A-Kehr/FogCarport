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
 private double lenght, height, width, Mprice;

    public Beam(String material, double lenght, double height, double width, double Mprice) {
        this.material = material;
        this.lenght = lenght;
        this.height = height;
        this.width = width;
        this.Mprice = Mprice;
    }

    public String getMaterial() {
        return material;
    }

    public double getLenght() {
        return lenght;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public double getMprice() {
        return Mprice;
    }
 
 
}
