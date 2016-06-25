package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity;

/**
 * Created by rezo on 6/25/16.
 */
public class HumiditySensorCommunicatorProxy  implements HumiditySensorCommunicator{

    private HumiditySensorCommunicator communicator;

    public HumiditySensorCommunicatorProxy(){
        communicator = new DefaultHumiditySensorCommunicator(HumiditySensorCommunicator.API_MOCK_TEMPLATE);
    }

    @Override
    public HumiditySensorResponse getSensorData(String houseId) {
        return this.communicator.getSensorData(houseId);
    }
}
