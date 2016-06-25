package ge.edu.freeuni.sdp.iot.service.bath_climate.core;

//import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.houses.HousesContainer;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity.Humidity;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity.HumiditySensorCommunicator;
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
//    private HousesContainer houses;

    public Worker(HumiditySensorCommunicator humiditySensorCommunicator, LightSensorCommunicator lightSensorCommunicator){
//        houses = new HousesContainer("/houses");
        this.humiditySensorCommunicator = humiditySensorCommunicator;
        this.lightSensorCommunicator = lightSensorCommunicator;
    }
    @Override
    public void run() {
//        for (Object object : col) {
//            
//        }
        boolean lightStatus = lightSensorCommunicator.isLightOn("1"); // for cikli housebistvis
        Humidity hum = humiditySensorCommunicator.getSensorData("1");
        if (!lightStatus && hum.getHumidity() >= limit){
            
        }
    }
}
