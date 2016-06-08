package ge.edu.freeuni.sdp.bathclimate.core;

import javax.ws.rs.*;
import javax.ws.rs.core.*;


@Path("bathclimate")
@Consumes( { MediaType.APPLICATION_JSON})
@Produces( { MediaType.APPLICATION_JSON})
public class TaskService {

	/*
	HTTP  |              /todos   	            	|            /todos/{ID}
	------|-----------------------------------------|----------------------------------------
	GET   | 200 (OK), list of tasks. 				| 200 (OK), single task. 404 (Not Found).
	PUT   | 404 (Not Found), N/A 					| 200 (OK). 404 (Not Found).
	POST  | 201 (Created),  Location: /todos/{ID} 	| 404 (Not Found).
	DELETE| 404 (Not Found) 						| 200 (OK). 404 (Not Found)
    */	

	


	/**
	 * 
	 * @return 200 (OK), list of tasks.
	 */
	@GET
	public String read()  {
		return "Hello World";
	}


}