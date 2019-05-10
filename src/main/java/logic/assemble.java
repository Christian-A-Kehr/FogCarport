/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.Beam;
import data.Carport;
import data.Rafter;
import data.Roof;
import data.Shed;
import data.WoodPost;

/**
 *
 * @author Christian Ambjørn Kehr
 */
public class assemble {
    Calculate Cal = new Calculate();
    
    private Roof roof;
    private Shed shed;
    private Rafter rafter;
    private Beam beam;
    private WoodPost woodpost;
    private int roofHeight;

    public Carport assembleCarport(Carport carport) {
        roof = createRoof(carport);
        shed = createShed(carport)
        rafter = createRafter(carport)
        woodpost = createWoodpost(carport)

        
        
        Carport newCarport = new Carport(carport.getHeight(), carport.getLength(), carport.getWidth(), roof, shed);
    }

    public int getRoofHeight(Carport carport) {
        // How to find roof height
        if (carport.getRoof().getType().equals("Med rejsning")) {
            roofHeight = Cal.calulateGabledHeight(carport);
        } else {
            roofHeight = 15; // 15 bør ændres til en variable, så de kan vælge tillæget af et fladt tag hvis der er tid    
        }
        return roofHeight;
    }

    private Roof createRoof(Carport carport) {
       Roof roof = new Roof(carport.getRoof().getType(),
                carport.getRoof().getMaterial(),
                carport.getRoof().getAngle(),
                getRoofHeight(carport),
                carport.getRoof().getLength(),
                carport.getRoof().getWidth(),
                
               createBeam(carport),
                createRafter(carport),
                createWoodpost(carport));
       return  roof;
    }

    private Shed createShed(Carport carport) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Rafter createRafter(Carport carport) {
        rafter = new Rafter(carport.getRoof().getRafter().getMaterial(),
                carport.getLength(),
                carport.getRoof().getRafter().getHeight(),
                carport.getRoof().getRafter().getWidth(),);
        
        return rafter;
    }

    private WoodPost createWoodpost(Carport carport) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Beam createBeam(Carport carport) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
