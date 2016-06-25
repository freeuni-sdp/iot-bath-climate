package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light;

/**
 * Created by rezo on 6/25/16.
 */
public class LightSensorCommunicatorProxy implements LightSensorCommunicator {

    private LightSensorCommunicator communicator;

    public LightSensorCommunicatorProxy(){
        communicator = new DefaultLightSensorCommunicator(API_MOCK_TEMPLATE);
    }

    @Override
    public boolean isLightOn(String houseId) {
        return communicator.isLightOn(houseId);
    }
}
