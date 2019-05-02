/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Mkhansen
 */
public class WoodPost {
    private String material;
    private int lenght, width; 
    private double Mprice;

    public WoodPost(String material, int lenght, int width, double Mprice) {
        this.material = material;
        this.lenght = lenght;
        this.width = width;
        this.Mprice = Mprice;
    }

    public String getMaterial() {
        return material;
    }

    public int getLenght() {
        return lenght;
    }

    public int getWidth() {
        return width;
    }

    public double getMprice() {
        return Mprice;
    }

}
