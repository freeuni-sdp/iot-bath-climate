package ge.edu.freeuni.sdp.iot.service.bath_climate.core;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import static org.junit.Assert.*;


public class BathClimateServiceTest extends JerseyTest {


    @Override
    protected Application configure() {
        return new ResourceConfig(BathClimateService.class);
    }

    @Test
    public void ping() throws Exception {
        Response response = target("ping").request().get();
        assertEquals(200, response.getStatus());
    }

}