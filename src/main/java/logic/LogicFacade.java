/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.CompleteCupCake;
import data.DataAccessor;
import java.util.ArrayList;

/**
 *
 * @author Christian Ambjørn Kehr
 */
public class LogicFacade {
private DataAccessor data = new DataAccessor();
    
    public static void main(String[] args) {
        System.err.println(allCupCakes());
    }
public LogicFacade() {
    }
    
    public static ArrayList<CompleteCupCake> allCupCakes() {
        ArrayList<CompleteCupCake> list = DataAccessor.getAllCupCakes();
        return list;
}
}