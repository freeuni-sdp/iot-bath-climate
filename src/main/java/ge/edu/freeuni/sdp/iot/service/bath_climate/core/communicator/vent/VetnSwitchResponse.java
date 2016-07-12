package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.vent;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class VetnSwitchResponse {
    @XmlElement
    private String houseid;
    @XmlElement
    private  String status;
    @XmlElement
    private boolean successed;

    public VetnSwitchResponse(){}

    public VetnSwitchResponse(String houseid, String status, boolean successed) {
        this.houseid = houseid;
        this.status = status;
        this.successed = successed;
    }

    public String getHouseid() {
        return houseid;
    }

    public void setHouseid(String houseid) {
        this.houseid = houseid;
    }

    public String getStatus() {
        return status;
    }

    public VetnSwitchResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    public boolean isSuccessed() {
        return successed;
    }

    public void setSuccessed(boolean successed) {
        this.successed = successed;
    }

    public boolean isOn(){
        return this.status.equals("on");
    }
}
