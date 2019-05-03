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
    public String name, desc, matrial, type;
    public int matNum, length, height, width, priceM, priceM2;

    public Material(String name, String desc, String matrial, String type, int matNum, int length, int height, int width, int priceM, int priceM2) {
        this.name = name;
        this.desc = desc;
        this.matrial = matrial;
        this.type = type;
        this.matNum = matNum;
        this.length = length;
        this.height = height;
        this.width = width;
        this.priceM = priceM;
        this.priceM2 = priceM2;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public String getMatrial() {
        return matrial;
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

    public int getPriceM() {
        return priceM;
    }

    public int getPriceM2() {
        return priceM2;
    }

    @Override
    public String toString() {
        return name; 
    }
   
}
