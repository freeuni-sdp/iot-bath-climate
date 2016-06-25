package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity;

/**
 * Created by rezo on 6/25/16.
 */
public interface HumiditySensorCommunicator  {
    public String API_MOCK_TEMPLATE = "http://iot-bath-humidity-sensor.herokuapp.com/webapi/houses/%s";
    public HumiditySensorResponse getSensorData(String houseId);
}
