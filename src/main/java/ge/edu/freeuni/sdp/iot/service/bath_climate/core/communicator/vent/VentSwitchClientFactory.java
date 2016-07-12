package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.vent;


import ge.edu.freeuni.sdp.iot.service.bath_climate.core.Util;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestBuilderFactory;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestWrapper;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light.DefaultLightSensorClient;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light.LightSensorClient;

public class VentSwitchClientFactory {

    public VentSwitchClient baseClient(){
        return createClient(Util.VENT_API_PROD_TEMPLATE_ROOT);
    }
    public VentSwitchClient proxyClient(){
        return createClient(Util.VENT_API_MOCK_TEMPLATE_ROOT);
    }

    private VentSwitchClient createClient(String path){
        return new DefaultVentSwitchClient(new RequestWrapper(),new RequestBuilderFactory(),path);
    }
}
