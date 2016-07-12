package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.vent;


public class SimpleVentSwitchClient implements VentSwitchClient {

    private   DefaultVentSwitchClient client ;

    public SimpleVentSwitchClient(){
        this.client = new DefaultVentSwitchClient(VentSwitchClient.API_PROD_TEMPLATE_ROOT);
    }

    @Override
    public void setVentStatus(String houseId, String status, int interval) {
            this.client.setVentStatus(houseId,status, interval);
    }

    @Override
    public boolean getVentStatus(String houseId) {
        return this.client.getVentStatus(houseId);
    }
}
