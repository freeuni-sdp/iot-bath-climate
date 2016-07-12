/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light;

import ge.edu.freeuni.sdp.iot.service.bath_climate.core.Util;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestBuilderFactory;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestWrapper;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity.DefaultHumiditySensorCommunicator;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity.Humidity;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity.HumiditySensorCommunicator;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author dato
 */
public class DefaultHumiditySensorTest {
    
    @Test
    public void testHumidityCreatesCorrectPath() throws Exception {
        String path = String.format(Util.HUMIDITY_SENSOR_API_PROD_TEMPLATE, "1");

        RequestBuilderFactory builderFactory = mock(RequestBuilderFactory.class);
        RequestWrapper requestWrapper = mock(RequestWrapper.class);

        HumiditySensorCommunicator client = new DefaultHumiditySensorCommunicator(requestWrapper, builderFactory, path);


        Response response = mock(Response.class);
        when(response.readEntity(Class.class)).thenReturn(Humidity.class);


        when(requestWrapper.invokeGet(any(Invocation.Builder.class))).thenReturn(response);

        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        client.getSensorData("1");
        verify(builderFactory).getRequestBuilder(argument.capture());

        assertEquals(path, argument.getValue());

    }
    
    @Test 
    public void testHumiditySensorDataCallsRequestCreation() throws Exception {

        String path = String.format(Util.HUMIDITY_SENSOR_API_PROD_TEMPLATE, "1");

        RequestBuilderFactory builderFactory = mock(RequestBuilderFactory.class);
        RequestWrapper requestWrapper = mock(RequestWrapper.class);

        HumiditySensorCommunicator client = new DefaultHumiditySensorCommunicator(requestWrapper, builderFactory, path);


        Response response = mock(Response.class);
        when(response.readEntity(Class.class)).thenReturn(Humidity.class);


        when(requestWrapper.invokeGet(any(Invocation.Builder.class))).thenReturn(response);


        client.getSensorData("1");
        verify(builderFactory).getRequestBuilder(anyString());

    }
    
    @Test
    public void testHumidityCallsRequestWrapper() throws Exception {

        String path = String.format(Util.HUMIDITY_SENSOR_API_PROD_TEMPLATE, "1");

        RequestBuilderFactory builderFactory = mock(RequestBuilderFactory.class);
        RequestWrapper requestWrapper = mock(RequestWrapper.class);

        HumiditySensorCommunicator client = new DefaultHumiditySensorCommunicator(requestWrapper, builderFactory, path);


        Response response = mock(Response.class);
        when(response.readEntity(Class.class)).thenReturn(Humidity.class);


        when(requestWrapper.invokeGet(any(Invocation.Builder.class))).thenReturn(response);


        client.getSensorData("1");
        verify(requestWrapper).invokeGet(any(Invocation.Builder.class));

    }
}
