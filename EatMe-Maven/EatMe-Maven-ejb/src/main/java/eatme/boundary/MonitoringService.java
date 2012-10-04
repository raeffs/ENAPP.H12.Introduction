package eatme.boundary;

import eatme.control.Monitoring;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author Admin
 */
@WebService(serviceName = "MonitoringService")
@Stateless()
public class MonitoringService {
    
    @Inject
    private Monitoring ejbRef;

    @WebMethod(operationName = "areYouAlive")
    public boolean areYouAlive(@WebParam(name = "key") String key) throws Exception {
        return ejbRef.areYouAlive(key);
    }
    
}
