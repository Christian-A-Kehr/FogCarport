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
public class WoodPost {

    private String material;
    private int length, width, id;
    private double Mprice;

    public WoodPost(String material, int length, int width, int id, double Mprice) {
        this.material = material;
        this.length = length;
        this.width = width;
        this.id = id;
        this.Mprice = Mprice;
    }

    public WoodPost(String material, int length) {
        this.material = material;
        this.length = length;
    }

    public String getMaterial() {
        return material;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public double getMprice() {
        return Mprice;
    }

    public int getId() {
        return id;
    }
}
