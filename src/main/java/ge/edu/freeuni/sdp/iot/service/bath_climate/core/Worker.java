package ge.edu.freeuni.sdp.iot.service.bath_climate.core;

import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.houses.DefaultHousesCommunicator;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.houses.HouseRegistryResponse;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.houses.HousesCommunicator;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestBuilderFactory;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestWrapper;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity.Humidity;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity.HumiditySensorCommunicator;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light.LightSensorClient;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.vent.VentSwitchClient;

import java.util.TimerTask;

/**
 * Created by rezo on 6/25/16.
 */
public class Worker extends TimerTask {

    private final HumiditySensorCommunicator humiditySensorCommunicator;
    private final LightSensorClient lightSensorClient;
    private final VentSwitchClient ventSwitch;
    private final HousesCommunicator houses;
    private final double limit = 20;

    public Worker(HumiditySensorCommunicator humiditySensorCommunicator, LightSensorClient lightSensorClient, VentSwitchClient ventSwitch){
        houses = new DefaultHousesCommunicator(new RequestWrapper(), new RequestBuilderFactory(), Util.HOUSES_API_PROD_TEMPLATE);
        this.humiditySensorCommunicator = humiditySensorCommunicator;
        this.lightSensorClient = lightSensorClient;
        this.ventSwitch = ventSwitch;
    }
    
    @Override
    public void run() {
        for (HouseRegistryResponse response : houses.getHouses()) {
            String houseid = response.getHouseID();
            boolean lightStatusOn = lightSensorClient.isLightOn(houseid).isOn();
            Humidity hum = humiditySensorCommunicator.getSensorData(houseid);
            boolean alreadyTurnOn = ventSwitch.getVentStatus(houseid).isOn();
            if (!lightStatusOn && hum.getHumidity() >= limit && !alreadyTurnOn){
                ventSwitch.setVentStatus(houseid, Util.VENT_SWITCH_ON,Util.VENT_SWITCH_DEFAULT_TIMEOUT);
            }
        }
    }
}
