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
public class HouseRegistryProxy implements HousesCommunicator {

    private final HousesCommunicator housesCommunicator;
    
    public HouseRegistryProxy(){
        housesCommunicator = new DefaultHousesCommunicator(API_MOCK_TEMPLATE);
    }
    
    @Override
    public HouseRegistryResponse[] getHouses() {
        return housesCommunicator.getHouses();
    }
    
}
