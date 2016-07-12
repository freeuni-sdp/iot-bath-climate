package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light;

import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestBuilderFactory;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestWrapper;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

public class DefaultLightSensorClient implements LightSensorClient {

    private RequestWrapper requestWrapper;
    private RequestBuilderFactory builderFactory;
    private String lightSensorApiUrl;

    public DefaultLightSensorClient(RequestWrapper requestWrapper, RequestBuilderFactory builderFactory, String lightSensorApiUrl) {
        this.requestWrapper = requestWrapper;
        this.builderFactory = builderFactory;
        this.lightSensorApiUrl = lightSensorApiUrl;
    }


    @Override
    public LightSensorResponse isLightOn(String houseId) {
        String path = String.format(this.lightSensorApiUrl, houseId);
        Invocation.Builder request = this.builderFactory.getRequestBuilder(path);

        Response response = this.requestWrapper.invokeGet(request);

        return response.readEntity(LightSensorResponse.class);

    }
}
