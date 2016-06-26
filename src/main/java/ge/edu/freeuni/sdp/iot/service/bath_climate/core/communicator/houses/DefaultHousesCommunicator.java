/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.houses;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

/**
 *
 * @author dato
 */
public class DefaultHousesCommunicator implements HousesCommunicator {
    
    private String path;
    
    public DefaultHousesCommunicator(String serviceFunctionPath){
        path = serviceFunctionPath;
    }
    
    @Override
    public HouseRegistryResponse[] getHouses(){
        Client client = ClientBuilder.newClient();
        HouseRegistryResponse[] response = client.target(API_MOCK_TEMPLATE + path)
				.request()
				.get(HouseRegistryResponse[].class);
        return response;
    }
}
