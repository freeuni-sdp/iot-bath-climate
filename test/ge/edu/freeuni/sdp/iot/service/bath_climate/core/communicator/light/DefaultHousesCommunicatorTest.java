/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light;

import ge.edu.freeuni.sdp.iot.service.bath_climate.core.Util;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.houses.DefaultHousesCommunicator;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.houses.HouseRegistryResponse;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.houses.HousesCommunicator;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestBuilderFactory;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestWrapper;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author dato
 */
public class DefaultHousesCommunicatorTest {
    
    
    @Test
    public void testHousesCreatesCorrectPath() throws Exception {
        String path = Util.HOUSES_API_PROD_TEMPLATE;

        RequestBuilderFactory builderFactory = mock(RequestBuilderFactory.class);
        RequestWrapper requestWrapper = mock(RequestWrapper.class);

        HousesCommunicator client = new DefaultHousesCommunicator(requestWrapper, builderFactory, path);


        Response response = mock(Response.class);
        when(response.readEntity(Class.class)).thenReturn(HouseRegistryResponse.class);


        when(requestWrapper.invokeGet(any(Invocation.Builder.class))).thenReturn(response);

        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        client.getHouses();
        verify(builderFactory).getRequestBuilder(argument.capture());

        assertEquals(path, argument.getValue());

    }
    
    @Test 
    public void testHousesSensorDataCallsRequestCreation() throws Exception {

        String path = String.format(Util.HOUSES_API_PROD_TEMPLATE, "1");

        RequestBuilderFactory builderFactory = mock(RequestBuilderFactory.class);
        RequestWrapper requestWrapper = mock(RequestWrapper.class);

        HousesCommunicator client = new DefaultHousesCommunicator(requestWrapper, builderFactory, path);


        Response response = mock(Response.class);
        when(response.readEntity(Class.class)).thenReturn(HouseRegistryResponse.class);


        when(requestWrapper.invokeGet(any(Invocation.Builder.class))).thenReturn(response);


        client.getHouses();
        verify(builderFactory).getRequestBuilder(anyString());

    }
    
    @Test
    public void testHousesCallsRequestWrapper() throws Exception {

        String path = String.format(Util.HOUSES_API_PROD_TEMPLATE, "1");

        RequestBuilderFactory builderFactory = mock(RequestBuilderFactory.class);
        RequestWrapper requestWrapper = mock(RequestWrapper.class);

        HousesCommunicator client = new DefaultHousesCommunicator(requestWrapper, builderFactory, path);


        Response response = mock(Response.class);
        when(response.readEntity(Class.class)).thenReturn(HouseRegistryResponse.class);


        when(requestWrapper.invokeGet(any(Invocation.Builder.class))).thenReturn(response);


        client.getHouses();
        verify(requestWrapper).invokeGet(any(Invocation.Builder.class));

    }
}
