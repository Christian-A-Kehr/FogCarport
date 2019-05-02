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
public class Floor {
    private String name;
    private int height, length, width;
    private double M2price;

    public Floor(String name, int height, int length, int width, double M2price) {
        this.name = name;
        this.height = height;
        this.length = length;
        this.width = width;
        this.M2price = M2price;
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

    public double getM2price() {
        return M2price;
    }

}
