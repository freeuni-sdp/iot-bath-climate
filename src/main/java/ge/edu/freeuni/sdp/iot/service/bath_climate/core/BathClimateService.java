package ge.edu.freeuni.sdp.iot.service.bath_climate.core;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("/ping")
@Consumes( { MediaType.APPLICATION_JSON})
@Produces( { MediaType.APPLICATION_JSON})
public class BathClimateService {


	@GET
	public Response ping()  {
                return Response.ok().build();
	}


}