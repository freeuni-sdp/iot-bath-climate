package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.vent;

import ge.edu.freeuni.sdp.iot.service.bath_climate.core.Util;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestBuilderFactory;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestWrapper;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light.DefaultLightSensorClient;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light.LightSensorClient;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light.LightSensorResponse;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class DefaultVentSwitchClientTest {
    String path = Util.createVentUrlGet(Util.VENT_API_PROD_TEMPLATE_ROOT,"/%s","1");
    @Test
    public void testIsVentOnCreatesCorrectPath() throws Exception {


        String path = Util.createVentUrlGet(Util.VENT_API_PROD_TEMPLATE_ROOT,"/%s","1");

        RequestBuilderFactory builderFactory = mock(RequestBuilderFactory.class);
        RequestWrapper requestWrapper = mock(RequestWrapper.class);

        VentSwitchClient client = new DefaultVentSwitchClient(requestWrapper,builderFactory,Util.VENT_API_PROD_TEMPLATE_ROOT);


        Response response = mock(Response.class);
        when(response.readEntity(Class.class)).thenReturn(VetnSwitchResponse.class);


        when(requestWrapper.invokeGet(any(Invocation.Builder.class))).thenReturn(response);

        ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
        client.getVentStatus("1");
        verify(builderFactory).getRequestBuilder(argument.capture());

        assertEquals(path, argument.getValue());

    }



    @Test
    public void testIsVentOnCallsRequestCreation() throws Exception {


        RequestBuilderFactory builderFactory = mock(RequestBuilderFactory.class);
        RequestWrapper requestWrapper = mock(RequestWrapper.class);

        DefaultVentSwitchClient client = new DefaultVentSwitchClient(requestWrapper,builderFactory,Util.VENT_API_PROD_TEMPLATE_ROOT);


        Response response = mock(Response.class);
        when(response.readEntity(Class.class)).thenReturn(LightSensorResponse.class);


        when(requestWrapper.invokeGet(any(Invocation.Builder.class))).thenReturn(response);


        client.getVentStatus("1");
        verify(builderFactory).getRequestBuilder(anyString());

    }

    @Test
    public void testIsVentOnCallsRequestWrapper() throws Exception {


        RequestBuilderFactory builderFactory = mock(RequestBuilderFactory.class);
        RequestWrapper requestWrapper = mock(RequestWrapper.class);

        VentSwitchClient client = new DefaultVentSwitchClient(requestWrapper,builderFactory,Util.VENT_API_MOCK_TEMPLATE_ROOT);


        Response response = mock(Response.class);
        when(response.readEntity(Class.class)).thenReturn(LightSensorResponse.class);


        when(requestWrapper.invokeGet(any(Invocation.Builder.class))).thenReturn(response);


        client.getVentStatus("1");
        verify(requestWrapper).invokeGet(any(Invocation.Builder.class));

    }

    @Test
    public void testSetVentOnCallsRequestWrapper() throws Exception {


        RequestBuilderFactory builderFactory = mock(RequestBuilderFactory.class);
        RequestWrapper requestWrapper = mock(RequestWrapper.class);

        VentSwitchClient client = new DefaultVentSwitchClient(requestWrapper,builderFactory,Util.VENT_API_MOCK_TEMPLATE_ROOT);

        Invocation.Builder request = ClientBuilder.newClient().target(path).request();
        when(builderFactory.getRequestBuilder(anyString())).thenReturn(request);

        client.setVentStatus("1","on",10);
        verify(requestWrapper).invokePost(any(Invocation.Builder.class), any(Entity.class));

    }

}