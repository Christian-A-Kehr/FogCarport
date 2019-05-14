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
 private double price, totalPrice;

    public Rafter(String material, int lenght, int height, int width, int id, int amount, double price, double totalPrice) {
        this.material = material;
        this.lenght = lenght;
        this.height = height;
        this.width = width;
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.totalPrice = totalPrice;
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
        return price;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Rafter{" + "material=" + material + ", lenght=" + lenght + ", height=" + height + ", width=" + width + ", id=" + id + ", Mprice=" + price + '}';
    }

}
