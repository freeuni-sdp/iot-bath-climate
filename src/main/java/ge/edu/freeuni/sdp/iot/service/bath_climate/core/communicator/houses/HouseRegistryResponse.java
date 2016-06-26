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
    private Value RowKey;
    

    public HouseRegistryResponse(){}

    public HouseRegistryResponse(Value newValue) {
        RowKey = newValue;
    }

    public Value getRowKey() {
        return RowKey;
    }

    public void setRowKey(Value newValue){
        RowKey = newValue;
    }
    
    public String getHouseID(){
        return RowKey.get_();
    }
    
    
    @XmlRootElement
    private class Value {
        
        @XmlElement
        private String $;
        
        @XmlElement
        private String _;
        
        public Value(){}
        
        public Value(String new$, String new_){
            $ = new$;
            _ = new_;
        }
        
        public String get_(){
            return _;
        }
        
        public void set_(String newValue){
            _ = newValue;
        }
        
        public String get$(){
            return $;
        }
        
        public void set$(String new$){
            $ = new$;
        }
    }
}
