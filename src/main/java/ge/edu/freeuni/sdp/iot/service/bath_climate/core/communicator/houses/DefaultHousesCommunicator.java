/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.houses;

import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestBuilderFactory;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestWrapper;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity.Humidity;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

/**
 *
 * @author dato
 */
public class DefaultHousesCommunicator implements HousesCommunicator {
    
    private RequestBuilderFactory requestFactory;
    private RequestWrapper requestWrapper;
    private String path;
    
    public DefaultHousesCommunicator(RequestWrapper wrapper, RequestBuilderFactory factory, String serviceFunctionPath){
        requestFactory = factory;
        requestWrapper = wrapper;
        path = serviceFunctionPath;
    }
    
    @Override
    public HouseRegistryResponse[] getHouses(){
        Client client = ClientBuilder.newClient();
        Invocation.Builder request = this.requestFactory.getRequestBuilder(path);
        Response response = this.requestWrapper.invokeGet(request);
        return response.readEntity(HouseRegistryResponse[].class);
        
//        HouseRegistryResponse[] response = client.target(API_MOCK_TEMPLATE + path)
//				.request()
//				.get(HouseRegistryResponse[].class);
//        return response;
    }
}
