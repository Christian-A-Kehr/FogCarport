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
    private int Mprice;

    public WoodPost(String material, int lenght, int width, int Mprice) {
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

    public int getMprice() {
        return Mprice;
    }

}
