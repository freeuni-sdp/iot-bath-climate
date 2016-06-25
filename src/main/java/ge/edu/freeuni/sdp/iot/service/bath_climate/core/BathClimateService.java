package ge.edu.freeuni.sdp.iot.service.bath_climate.core;

import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light.LightSensorCommunicatorProxy;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.vent.VentSwitchClientProxy;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/ping")
@Consumes( { MediaType.APPLICATION_JSON})
@Produces( { MediaType.APPLICATION_JSON})
public class BathClimateService {


	@GET
	public Response ping()  {

		VentSwitchClientProxy ventSwitchClientProxy = new VentSwitchClientProxy();
		boolean sensorData = ventSwitchClientProxy.getVentStatus("1");
		ventSwitchClientProxy.setVentStatus("1","off");
		return Response.ok().build();
	}


}