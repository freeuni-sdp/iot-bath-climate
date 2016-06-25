package ge.edu.freeuni.sdp.iot.service.bath_climate.core;

import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity.HumiditySensorCommunicator;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light.LightSensorCommunicator;

/**
 * Created by rezo on 6/25/16.
 */
public class Worker extends Thread {

    private HumiditySensorCommunicator humiditySensorCommunicator;
    private LightSensorCommunicator lightSensorCommunicator;

    public Worker(HumiditySensorCommunicator humiditySensorCommunicator, LightSensorCommunicator lightSensorCommunicator){

        this.humiditySensorCommunicator = humiditySensorCommunicator;
        this.lightSensorCommunicator = lightSensorCommunicator;
    }
    @Override
    public void run() {
        super.run();
    }
}
