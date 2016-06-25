/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.houses;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dato
 */
@XmlRootElement
public class HouseRegistryResponse {
    
    @XmlElement
    private String houseId;
    @XmlElement
    private String status;
    @XmlElement
    private String time;

    public HouseRegistryResponse(){}

    public HouseRegistryResponse(String houseId, String status, String time) {
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
}
