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
 private int lenght, height, width, id, amount; 
 private double Mprice;

    public Rafter(String material, int lenght, int height, int width, int id, double Mprice, int amount) {
        this.material = material;
        this.lenght = lenght;
        this.height = height;
        this.width = width;
        this.id = id;
        this.Mprice = Mprice;
        this.amount = amount;
    }

    public Rafter(String material, int lenght, int height, int width, int id) {
        this.material = material;
        this.lenght = lenght;
        this.height = height;
        this.width = width;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public double getMprice() {
        return Mprice;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Rafter{" + "material=" + material + ", lenght=" + lenght + ", height=" + height + ", width=" + width + ", id=" + id + ", Mprice=" + Mprice + '}';
    }

}
