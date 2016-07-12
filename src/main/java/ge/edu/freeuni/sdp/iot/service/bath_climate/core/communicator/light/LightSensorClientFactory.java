package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light;

import ge.edu.freeuni.sdp.iot.service.bath_climate.core.Util;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestBuilderFactory;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestWrapper;


public class LightSensorClientFactory {
    public LightSensorClient baseClient(){
        return createClient(Util.LIGHT_SENSOR_API_PROD_TEMPLATE);
    }
    public LightSensorClient proxyClient(){
        return createClient(Util.LIGHT_SENSOR_API_MOCK_TEMPLATE);
    }

    private LightSensorClient createClient(String path){
        return new DefaultLightSensorClient(new RequestWrapper(), new RequestBuilderFactory(), path);
    }

}
