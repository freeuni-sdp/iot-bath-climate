package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.vent;

/**
 * Created by rezo on 6/25/16.
 */
public interface VentSwitchClient {
    public String API_MOCK_TEMPLATE_ROOT = "http://private-caac5-iotbathventswitch.apiary-mock.com/houses/";
    public void setVentStatus(String houseId, String status);
    public boolean getVentStatus(String houseId);
}
