package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light;


public interface LightSensorCommunicator {

    static String API_MOCK_TEMPLATE = "http://private-62396-bathlightsensor.apiary-mock.com/webapi/status/house/%s";

    public boolean isLightOn(String houseId);
}
