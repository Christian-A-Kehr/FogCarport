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
public class Rooftile {
    private String material;
    private int lenght, width, id, amount;
    private double price, totalPrice;

    public Rooftile(String material, int lenght, int width, int id, int amount, double price, double totalPrice) {
        this.material = material;
        this.lenght = lenght;
        this.width = width;
        this.id = id;
        this.amount = amount;
        this.price = price;
        this.totalPrice = totalPrice;
    }

    public Rooftile(String name, int lenght, int width, int id) {
        this.material = name;
        this.lenght = lenght;
        this.width = width;
        this.id = id;
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

    public int getId() {
        return id;
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
        return "Rooftile{" + "material=" + material + ", lenght=" + lenght + ", width=" + width + ", id=" + id + ", amount=" + amount + ", price=" + price + ", totalPrice=" + totalPrice + '}';
    }
    
}
