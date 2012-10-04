package eatme.boundary.dto;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Dish {

    private String name;
    private String description;
    private Date validOn;
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getValidOn() {
        return validOn;
    }

    public void setValidOn(Date validOn) {
        this.validOn = validOn;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
