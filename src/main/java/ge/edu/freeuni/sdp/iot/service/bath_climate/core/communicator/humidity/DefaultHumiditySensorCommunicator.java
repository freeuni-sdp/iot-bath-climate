package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class DefaultHumiditySensorCommunicator  implements HumiditySensorCommunicator{

    private String apiCallTemplate;

    public DefaultHumiditySensorCommunicator(String apiCallTemplate){

        this.apiCallTemplate = apiCallTemplate;
    }
    @Override
    public HumiditySensorResponse getSensorData(String houseId) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(String.format(this.apiCallTemplate, houseId))
                .request(MediaType.TEXT_PLAIN_TYPE)
                .get();

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        return response.readEntity(HumiditySensorResponse.class);
    }
}
