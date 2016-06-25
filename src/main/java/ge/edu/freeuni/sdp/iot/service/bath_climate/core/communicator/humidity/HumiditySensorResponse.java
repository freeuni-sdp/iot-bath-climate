package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity;

import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class HumiditySensorResponse {

    @XmlList
    private List<Humidity> humidity;

    public HumiditySensorResponse(){}

    public HumiditySensorResponse(List<Humidity> humidity) {
        this.humidity = humidity;
    }

    public List<Humidity> getHumidity() {
        return humidity;
    }

    public void setHumidity(List<Humidity> humidity) {
        this.humidity = humidity;
    }
}
