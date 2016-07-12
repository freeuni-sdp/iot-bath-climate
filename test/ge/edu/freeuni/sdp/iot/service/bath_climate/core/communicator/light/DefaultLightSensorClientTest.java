package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light;

import ge.edu.freeuni.sdp.iot.service.bath_climate.core.Util;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestBuilderFactory;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestWrapper;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class DefaultLightSensorClientTest {


    @Test
    public void testIsLightOnCreatesCorrectPath() throws Exception {


        String path = String.format(Util.LIGHT_SENSOR_API_PROD_TEMPLATE, "1");

        RequestBuilderFactory builderFactory = mock(RequestBuilderFactory.class);
        RequestWrapper requestWrapper = mock(RequestWrapper.class);

        LightSensorClient client = new DefaultLightSensorClient(requestWrapper,builderFactory,path);


        Response response = mock(Response.class);
        when(response.readEntity(Class.class)).thenReturn(LightSensorResponse.class);


        when(requestWrapper.invokeGet(any(Invocation.Builder.class))).thenReturn(response);

        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        client.isLightOn("1");
        verify(builderFactory).getRequestBuilder(argument.capture());

        assertEquals(path, argument.getValue());

    }



    @Test
    public void testIsLightOnCallsRequestCreation() throws Exception {

        String path = String.format(Util.LIGHT_SENSOR_API_PROD_TEMPLATE, "1");

        RequestBuilderFactory builderFactory = mock(RequestBuilderFactory.class);
        RequestWrapper requestWrapper = mock(RequestWrapper.class);

        LightSensorClient client = new DefaultLightSensorClient(requestWrapper,builderFactory,path);


        Response response = mock(Response.class);
        when(response.readEntity(Class.class)).thenReturn(LightSensorResponse.class);


        when(requestWrapper.invokeGet(any(Invocation.Builder.class))).thenReturn(response);


        client.isLightOn("1");
        verify(builderFactory).getRequestBuilder(anyString());

    }

    @Test
    public void testIsLightOnCallsRequestWrapper() throws Exception {

        String path = String.format(Util.LIGHT_SENSOR_API_PROD_TEMPLATE, "1");

        RequestBuilderFactory builderFactory = mock(RequestBuilderFactory.class);
        RequestWrapper requestWrapper = mock(RequestWrapper.class);

        LightSensorClient client = new DefaultLightSensorClient(requestWrapper,builderFactory,path);


        Response response = mock(Response.class);
        when(response.readEntity(Class.class)).thenReturn(LightSensorResponse.class);


        when(requestWrapper.invokeGet(any(Invocation.Builder.class))).thenReturn(response);


        client.isLightOn("1");
        verify(requestWrapper).invokeGet(any(Invocation.Builder.class));

    }

}