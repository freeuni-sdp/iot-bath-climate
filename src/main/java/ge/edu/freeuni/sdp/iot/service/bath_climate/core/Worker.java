package ge.edu.freeuni.sdp.iot.service.bath_climate.core;

import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.houses.DefaultHousesCommunicator;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.houses.HouseRegistryResponse;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.houses.HousesCommunicator;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity.Humidity;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity.HumiditySensorCommunicator;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light.LightSensorCommunicator;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.vent.VentSwitchClient;
import java.util.List;
import java.util.TimerTask;

/**
 * Created by rezo on 6/25/16.
 */
public class Worker extends TimerTask {

    private final HumiditySensorCommunicator humiditySensorCommunicator;
    private final LightSensorCommunicator lightSensorCommunicator;
    private final VentSwitchClient ventSwitch;
    private final HousesCommunicator houses;
    private final double limit = 20;

    public Worker(HumiditySensorCommunicator humiditySensorCommunicator, LightSensorCommunicator lightSensorCommunicator, VentSwitchClient ventSwitch){
        houses = new DefaultHousesCommunicator("/houses");
        this.humiditySensorCommunicator = humiditySensorCommunicator;
        this.lightSensorCommunicator = lightSensorCommunicator;
        this.ventSwitch = ventSwitch;
    }
    
    @Override
    public void run() {
        for (HouseRegistryResponse response : houses.getHouses()) {
            String houseid = response.getHouseID();
            boolean lightStatusOn = lightSensorCommunicator.isLightOn(houseid);
            Humidity hum = humiditySensorCommunicator.getSensorData(houseid);
            boolean alreadyTurnOn = ventSwitch.getVentStatus(houseid);
            if (!lightStatusOn && hum.getHumidity() >= limit && !alreadyTurnOn){
                ventSwitch.setVentStatus(houseid, "true");
            }
        }
    }
}
