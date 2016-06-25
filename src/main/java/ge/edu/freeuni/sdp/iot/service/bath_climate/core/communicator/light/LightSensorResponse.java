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
    private String date;

    public LightSensorResponse(String houseId, String status, String date) {
        this.houseId = houseId;
        this.status = status;
        this.date = date;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
