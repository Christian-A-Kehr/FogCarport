/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author Christan Ambjørn Kehr
 */
public class Carport {
    private int height, length, width;
    private Roof roof;
    private Shed shed;

    public Carport(int height, int length, int width, Roof roof, Shed shed) {
        this.height = height;
        this.length = length;
        this.width = width;
        this.roof = roof;
        this.shed = shed;
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

    public Roof getRoof() {
        return roof;
    }

    public Shed getShed() {
        return shed;
    }

}
