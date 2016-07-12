/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.houses;

import ge.edu.freeuni.sdp.iot.service.bath_climate.core.Util;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestBuilderFactory;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http.RequestWrapper;
import java.util.TimerTask;

/**
 *
 * @author dato
 */
public class HouseUpdater extends TimerTask {

    private HousesContainer houseContainer;
    private HousesCommunicator houses;
    
    public HouseUpdater(HousesContainer houseContainer){
        this.houseContainer = houseContainer;
    }
    
    @Override
    public void run() {
        houses = new DefaultHousesCommunicator(new RequestWrapper(), new RequestBuilderFactory(), Util.HOUSES_API_PROD_TEMPLATE);
        houseContainer.setHouses(houses.getHouses());
    }
    
}
