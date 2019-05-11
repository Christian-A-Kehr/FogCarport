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
class Rooftiles {
    private String name;
    private int length, width, id, amount;
    private double M2price;

    public Rooftiles(String name, int length, int width, int id, int amount, double M2price) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.id = id;
        this.amount = amount;
        this.M2price = M2price;
    }

    
    public Rooftiles(String name, int length, int width, int id) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
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

    public double getM2price() {
        return M2price;
    }
    
    
    
}
