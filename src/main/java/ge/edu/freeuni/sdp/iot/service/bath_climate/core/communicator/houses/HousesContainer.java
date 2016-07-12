/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.houses;

/**
 *
 * @author dato
 */
public class HousesContainer {
    
    private HouseRegistryResponse[] houses;
    
    public HousesContainer(){}
    
    public void setHouses(HouseRegistryResponse[] houses){
        synchronized (this.houses){
            this.houses = houses;
        }
    }
    
    public synchronized HouseRegistryResponse[] getHouses(){
       synchronized (this.houses){
           return this.houses;
       }
    }
}
