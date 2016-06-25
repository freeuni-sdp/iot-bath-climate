package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class DefaultLightSensorCommunicator  implements LightSensorCommunicator{

    private String apiUrlTemplate;

    public DefaultLightSensorCommunicator(String apiUrlTemplate){

        this.apiUrlTemplate = apiUrlTemplate;
    }
    @Override
    public boolean isLightOn(String houseId) {
        Client client = ClientBuilder.newClient();
        Response
                response = client.target(String.format(this.apiUrlTemplate, houseId))
                .request(MediaType.TEXT_PLAIN_TYPE)
                .get();

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        LightSensorResponse s = response.readEntity(LightSensorResponse.class);

        return s.getStatus().equals("true");

    }
}
