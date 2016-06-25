package ge.edu.freeuni.sdp.iot.service.bath_climate.core.communicator.humidity;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by rezo on 6/25/16.
 */
@XmlRootElement
public class Humidity {
    private double humidity;
    private String measurement_time;

    public Humidity(){}

    public Humidity(double humidity, String measurement_time) {
        this.humidity = humidity;
        this.measurement_time = measurement_time;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getMeasurement_time() {
        return measurement_time;
    }

    public void setMeasurement_time(String measurement_time) {
        this.measurement_time = measurement_time;
    }
}
