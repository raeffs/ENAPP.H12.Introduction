package eatme.control;

import javax.ejb.Stateless;

/**
 *
 * @author Admin
 */
@Stateless
public class Monitoring {

    private String serviceKey = "1234-5678-4321-8765";
    
    public boolean areYouAlive(String key) throws Exception {
        if (key.equals(serviceKey)) {
            return true;
        } else {
            throw new Exception("The provided service key does not match!");
        }
    }
}
