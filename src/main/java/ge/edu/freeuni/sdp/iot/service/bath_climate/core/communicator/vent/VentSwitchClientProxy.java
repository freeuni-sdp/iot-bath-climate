package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.vent;


public class VentSwitchClientProxy implements VentSwitchClient {
    private VentSwitchClient client;

    public VentSwitchClientProxy(){
        this.client = new DefaultVentSwitchClient(VentSwitchClient.API_MOCK_TEMPLATE_ROOT);
    }

    @Override
    public void setVentStatus(String houseId, String status) {
        this.client.setVentStatus(houseId,status);
    }

    @Override
    public boolean getVentStatus(String houseId) {
        return this.client.getVentStatus(houseId);
    }
}
