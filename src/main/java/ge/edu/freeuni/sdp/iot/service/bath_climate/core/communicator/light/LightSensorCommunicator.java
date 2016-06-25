package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light;


public interface LightSensorCommunicator {

    static String API_MOCK_TEMPLATE = "http://iot-bath-light-sensor.herokuapp.com/webapi/status/house/%s";

    public boolean isLightOn(String houseId);
}
