package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.vent;


public interface VentSwitchClient {

    public void setVentStatus(String houseId, String status, int interval);
    public VetnSwitchResponse getVentStatus(String houseId);
}
