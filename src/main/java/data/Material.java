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
    public String name, desc;
    public int length, height, width, priceM, priceM2;

    public Material(String name, String desc, int length, int height, int width, int priceM, int priceM2) {
        this.name = name;
        this.desc = desc;
        this.length = length;
        this.height = height;
        this.width = width;
        this.priceM = priceM;
        this.priceM2 = priceM2;
    }

    @Override
    public String toString() {
        return "Material{" + "name=" + name + ", desc=" + desc + ", length=" + length + ", height=" + height + ", width=" + width + ", priceM=" + priceM + ", priceM2=" + priceM2 + '}';
    }

}
