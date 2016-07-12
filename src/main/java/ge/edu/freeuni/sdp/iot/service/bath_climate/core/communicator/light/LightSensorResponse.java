package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by rezo on 6/25/16.
 */
@XmlRootElement
public class LightSensorResponse {
    @XmlElement
    private String houseId;
    @XmlElement
    private String status;
    @XmlElement
    private String time;

    public LightSensorResponse(){}

    public LightSensorResponse(String houseId, String status, String time) {
        this.houseId = houseId;
        this.status = status;
        this.time = time;
    }

    public String getHouseId() {
        return houseId;
    }

    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isOn(){
        return this.status.equals("true");
    }
}
