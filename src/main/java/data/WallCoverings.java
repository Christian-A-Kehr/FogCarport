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
    private int height, length, width;
    private double Mprice;

    public WallCoverings(String name, int height, int length, int width, double Mprice) {
        this.name = name;
        this.height = height;
        this.length = length;
        this.width = width;
        this.Mprice = Mprice;
    }

    public String getName() {
        return name;
    }

    public int getHeight() {
        return height;
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

}
