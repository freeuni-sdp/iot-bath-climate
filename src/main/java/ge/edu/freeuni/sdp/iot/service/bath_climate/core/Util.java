package ge.edu.freeuni.sdp.iot.service.bath_climate.core;


public class Util {

    public static final String VENT_SWITCH_ON = "on";
    public static final String VENT_SWITCH_OFF = "off";
    public static final int VENT_SWITCH_DEFAULT_TIMEOUT = 30;
    public static final String LIGHT_SENSOR_API_MOCK_TEMPLATE = "http://private-62396-bathlightsensor.apiary-mock.com/webapi/status/house/%s";
    public static final String LIGHT_SENSOR_API_PROD_TEMPLATE = "http://iot-bath-light-sensor.herokuapp.com/webapi/status/house/%s";
    public static final String HUMIDITY_SENSOR_API_MOCK_TEMPLATE = "http://private-31b8b-iotbathhumiditysensor.apiary-mock.com/webapi/houses/%s";
    public static final String HUMIDITY_SENSOR_API_PROD_TEMPLATE = "http://iot-bath-humidity-sensor.herokuapp.com/webapi/houses/%s";


}
