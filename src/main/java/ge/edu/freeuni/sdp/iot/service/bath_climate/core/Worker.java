package ge.edu.freeuni.sdp.iot.service.bath_climate.core;

import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity.Humidity;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity.HumiditySensorCommunicator;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity.HumiditySensorResponse;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light.LightSensorCommunicator;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by rezo on 6/25/16.
 */
public class Worker extends TimerTask {

    private HumiditySensorCommunicator humiditySensorCommunicator;
    private LightSensorCommunicator lightSensorCommunicator;
    private double limit = 20;

    public Worker(HumiditySensorCommunicator humiditySensorCommunicator, LightSensorCommunicator lightSensorCommunicator){

        this.humiditySensorCommunicator = humiditySensorCommunicator;
        this.lightSensorCommunicator = lightSensorCommunicator;
    }
    @Override
    public void run() {
        boolean lightStatus = lightSensorCommunicator.isLightOn("1"); // for cikli housebistvis
        HumiditySensorResponse response = humiditySensorCommunicator.getSensorData("1");
        Humidity hum = response.getHumidity().get(0);
        if (!lightStatus && hum.getHumidity() >= limit){
            
        }
    }
}
