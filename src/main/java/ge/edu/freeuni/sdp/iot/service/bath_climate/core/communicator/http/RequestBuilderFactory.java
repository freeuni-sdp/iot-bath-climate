package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.http;



import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;

public class RequestBuilderFactory {


    public Invocation.Builder getRequestBuilder(String path){
        return ClientBuilder.newClient().target(path).request();
    }


}
