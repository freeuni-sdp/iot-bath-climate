package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity;

import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestBuilderFactory;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestWrapper;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light.LightSensorResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class DefaultHumiditySensorCommunicator  implements HumiditySensorCommunicator{

    private RequestBuilderFactory builderFactory;
    private RequestWrapper requestWrapper;
    private String apiCallTemplate;

    public DefaultHumiditySensorCommunicator(RequestWrapper wrapper, RequestBuilderFactory factory, String apiCallTemplate){
        this.requestWrapper = wrapper;
        this.builderFactory = factory;
        this.apiCallTemplate = apiCallTemplate;
    }
    
    @Override
    public Humidity getSensorData(String houseId) {
        String path = String.format(this.apiCallTemplate, houseId);
        Invocation.Builder request = this.builderFactory.getRequestBuilder(path);
        Response response = this.requestWrapper.invokeGet(request);
        return response.readEntity(Humidity.class);
        
//        Client client = ClientBuilder.newClient();
//        String path = String.format(this.apiCallTemplate, houseId);
//        Response response = client.target(path)
//                .request(MediaType.TEXT_PLAIN_TYPE)
//                .get();
//
//        System.out.println("status: " + response.getStatus());
//        System.out.println("headers: " + response.getHeaders());
//        Humidity humiditySensorResponses = response.readEntity(Humidity.class);
//        return humiditySensorResponses;
    }
}
