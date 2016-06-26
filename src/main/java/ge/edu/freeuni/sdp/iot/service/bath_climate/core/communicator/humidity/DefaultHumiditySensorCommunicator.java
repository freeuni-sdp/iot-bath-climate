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
    public Humidity getSensorData(String houseId) {
        Client client = ClientBuilder.newClient();
        String path = String.format(this.apiCallTemplate, houseId);
        Response response = client.target(path)
                .request(MediaType.TEXT_PLAIN_TYPE)
                .get();

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        Humidity humiditySensorResponses = response.readEntity(Humidity.class);
        return humiditySensorResponses;
    }
}
