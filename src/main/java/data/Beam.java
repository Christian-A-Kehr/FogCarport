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
 private int length, height, width, id, amount; 
 private double Mprice;

    public Beam(String material, int length, int height, int width, int id, int amount, double Mprice) {
        this.material = material;
        this.length = length;
        this.height = height;
        this.width = width;
        this.id = id;
        this.amount = amount;
        this.Mprice = Mprice;
    }

    public Beam(String material, int length, int height, int width, int id) {
        this.material = material;
        this.length = length;
        this.height = height;
        this.width = width;
        this.id = id;
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

    public int getId() {
        return id;
    }
    
    public double getMprice() {
        return Mprice;
    }

    public int getAmount() {
        return amount;
    }
 
}
