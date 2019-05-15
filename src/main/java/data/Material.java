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
public class Material {
    public String name, desc, material, type;
    public int matNum, length, height, width;
    private double price;

    public Material(String name, String desc, String matrial, String type, int matNum, int length, int height, int width, double price) {
        this.name = name;
        this.desc = desc;
        this.material = matrial;
        this.type = type;
        this.matNum = matNum;
        this.length = length;
        this.height = height;
        this.width = width;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getMaterial() {
        return material;
    }

    public String getType() {
        return type;
    }

    public int getMatNum() {
        return matNum;
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

    public double getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return name; 
    }
   
}
