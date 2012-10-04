package eatme.boundary.dto;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Chatmessage {

    private String message;
    private Date enteredat;
    private String username;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getEnteredat() {
        return enteredat;
    }

    public void setEnteredat(Date enteredat) {
        this.enteredat = enteredat;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
