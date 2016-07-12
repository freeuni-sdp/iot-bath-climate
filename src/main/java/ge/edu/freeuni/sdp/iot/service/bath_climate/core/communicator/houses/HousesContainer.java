/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.houses;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dato
 */
public class HousesContainer {
    
    private HouseRegistryResponse[] houses;
    private final Semaphore sem = new Semaphore(0);
    
    public HousesContainer(){}
    
    public void setHouses(HouseRegistryResponse[] houses){
        sem.release();
        this.houses = houses;
    }
    
    public HouseRegistryResponse[] getHouses(){
        try {
            sem.acquire();
        } catch (InterruptedException ex) {
            Logger.getLogger(HousesContainer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return houses;
    }
}
