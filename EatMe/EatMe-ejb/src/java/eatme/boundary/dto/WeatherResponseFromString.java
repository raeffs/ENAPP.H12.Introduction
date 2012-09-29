package eatme.boundary.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CurrentWeather")
public class WeatherResponseFromString {
    
    @XmlElement(name = "SkyConditions")
    protected String skyConditions;
    
    @XmlElement(name = "Status")
    protected String status;

    public String getSkyConditions() {
        return skyConditions;
    }

    public void setSkyConditions(String skyConditions) {
        this.skyConditions = skyConditions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}