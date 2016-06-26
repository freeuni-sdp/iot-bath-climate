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
public interface HousesCommunicator {
    public static String API_MOCK_TEMPLATE = "https://iot-house-registry.herokuapp.com/houses/";
    
    public HouseRegistryResponse[] getHouses();
}
