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
public class Rafter {
    
 private String material;
 private int lenght, height, width; 
 private double Mprice;

    public Rafter(String material, int lenght, int height, int width, double Mprice) {
        this.material = material;
        this.lenght = lenght;
        this.height = height;
        this.width = width;
        this.Mprice = Mprice;
    }

    public Rafter(String material, int length) {
        this.material = material;
        this.lenght = length;
    }

    public String getMaterial() {
        return material;
    }

    public int getLenght() {
        return lenght;
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
