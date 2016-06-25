/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.houses;

import java.util.Iterator;

/**
 *
 * @author dato
 */
public class HousesContainer {
    
    private String path;
    
    public HousesContainer(String serviceFunctionPath){
        path = serviceFunctionPath;
    }
    
    public Iterator<HouseRegistryResponse> getHouses(){
        return null;
    }
}
