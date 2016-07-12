package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.vent;

import ge.edu.freeuni.sdp.iot.service.bath_climate.core.Util;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestBuilderFactory;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestWrapper;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;


public class DefaultVentSwitchClient implements VentSwitchClient {

    private String template = "/%s";


    private String apiCallTemplateRoot;


    private RequestWrapper requestWrapper;
    private RequestBuilderFactory builderFactory;


    public DefaultVentSwitchClient(RequestWrapper requestWrapper, RequestBuilderFactory builderFactory, String lightSensorApiUrl) {
        this.requestWrapper = requestWrapper;
        this.builderFactory = builderFactory;
        this.apiCallTemplateRoot = lightSensorApiUrl;
    }

    @Override
    public void setVentStatus(String houseId, String status, int interval) {
        Entity<String> payload = Entity.json(String.format(Util.VENT_REQUEST_BODY_TEMPLATE, status, interval));

        String path = String.format(this.apiCallTemplateRoot + template, houseId);
        Invocation.Builder request = this.builderFactory.getRequestBuilder(path);

        this.requestWrapper.invokePost(request,payload);


    }

    @Override
    public VetnSwitchResponse getVentStatus(String houseId) {

        String ventUrlGet = Util.createVentUrlGet(this.apiCallTemplateRoot, template, houseId);
        Invocation.Builder request = this.builderFactory.getRequestBuilder(ventUrlGet);

        Response response = this.requestWrapper.invokeGet(request);
        if (response.getStatus() == 200){
            return response.readEntity(VetnSwitchResponse.class);
        }
        return new VetnSwitchResponse().setStatus("off");
    }
}
