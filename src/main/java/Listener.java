/**
 * Created by rezo on 6/25/16.
 */

import ge.edu.freeuni.sdp.iot.service.bath_climate.core.Worker;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity.HumiditySensorCommunicatorProxy;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.light.LightSensorClientFactory;
import ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.vent.VentSwitchClientFactory;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    private Timer timer;
    
    // Public constructor is required by servlet spec
    public Listener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        Worker worker = new Worker(new HumiditySensorCommunicatorProxy(),new LightSensorClientFactory().baseClient(), new VentSwitchClientFactory().baseClient());
        
        timer = new Timer();
        timer.schedule(worker, 0, 60000);

    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
      timer.cancel();
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
      /* Session is created. */
    }

    public void sessionDestroyed(HttpSessionEvent se) {
      /* Session is destroyed. */
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }
}
