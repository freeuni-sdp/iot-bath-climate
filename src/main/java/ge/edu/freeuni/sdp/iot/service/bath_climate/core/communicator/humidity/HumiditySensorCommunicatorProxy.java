package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity;

import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestBuilderFactory;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestWrapper;

/**
 * Created by rezo on 6/25/16.
 */
public class HumiditySensorCommunicatorProxy  implements HumiditySensorCommunicator{

    private HumiditySensorCommunicator communicator;

    public HumiditySensorCommunicatorProxy(){
        communicator = new DefaultHumiditySensorCommunicator(new RequestWrapper(),
                                                            new RequestBuilderFactory(),
                                                            HumiditySensorCommunicator.API_MOCK_TEMPLATE);
    }

    @Override
    public Humidity getSensorData(String houseId) {
        return this.communicator.getSensorData(houseId);
    }
}
