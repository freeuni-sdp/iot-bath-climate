package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http;

import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

public class RequestWrapper {

    public Response invokePost(Invocation.Builder builder, Entity entity){
        return builder.post(entity);
    }

    public Response invokeGet(Invocation.Builder builder){
        return builder.get();
    }
}
