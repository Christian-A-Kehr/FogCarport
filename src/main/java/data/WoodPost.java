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
    private double lenght, width, Mprice;

    public WoodPost(String material, double lenght, double width, double Mprice) {
        this.material = material;
        this.lenght = lenght;
        this.width = width;
        this.Mprice = Mprice;
    }

    public String getMaterial() {
        return material;
    }

    public double getLenght() {
        return lenght;
    }

    public double getWidth() {
        return width;
    }

    public double getMprice() {
        return Mprice;
    }
    
}
