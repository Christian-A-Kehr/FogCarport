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
class Demand {
    private String name;
    private int Measurements;

    public Demand(String name, int Measurements) {
        this.name = name;
        this.Measurements = Measurements;
    }

    public String getName() {
        return name;
    }

    public int getMeasurements() {
        return Measurements;
    }

    @Override
    public String toString() {
        return "Demand{" + "name=" + name + ", Measurements=" + Measurements + '}';
    }

    
    
}
