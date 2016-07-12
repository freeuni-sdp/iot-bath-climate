package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.vent;


public interface VentSwitchClient {
    public String API_MOCK_TEMPLATE_ROOT = "http://private-caac5-iotbathventswitch.apiary-mock.com";
    public String API_PROD_TEMPLATE_ROOT = "http://iot-bath-vent-switch.herokuapp.com";
    public void setVentStatus(String houseId, String status, int interval);
    public boolean getVentStatus(String houseId);
}
