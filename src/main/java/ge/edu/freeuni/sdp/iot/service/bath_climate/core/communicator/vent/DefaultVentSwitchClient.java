package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.vent;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class DefaultVentSwitchClient implements VentSwitchClient {

    private String apiCallTemplateRoot;
    private String setTemplate = "/houses/%s";
    private String getTemplate = "%s";

    public DefaultVentSwitchClient(String apiCallTemplateRoot){

        this.apiCallTemplateRoot = apiCallTemplateRoot;
    }

    @Override
    public void setVentStatus(String houseId, String status, int interval) {
        Client client = ClientBuilder.newClient();
        Entity<String> payload = Entity.json(String.format("{ 'set_status': '%s',  'timeout': %d}", status, interval));
        Response response = client.target(String.format(this.apiCallTemplateRoot +setTemplate, houseId))
                .request(MediaType.TEXT_PLAIN_TYPE)
                .put(payload);
        if (response.getStatus() == 200){
            VetnSwitchResponse vetnSwitchResponse = response.readEntity(VetnSwitchResponse.class);
            System.out.println(vetnSwitchResponse.getStatus());
        }
    }

    @Override
    public boolean getVentStatus(String houseId) {
        Client client = ClientBuilder.newClient();
        Response response = client.target(String.format(this.apiCallTemplateRoot +getTemplate, houseId))
                .request(MediaType.TEXT_PLAIN_TYPE)
                .get();
        if (response.getStatus() == 200){
            VetnSwitchResponse vetnSwitchResponse = response.readEntity(VetnSwitchResponse.class);
            return vetnSwitchResponse.getStatus().equals("on");
        }
        return false;
    }
}
