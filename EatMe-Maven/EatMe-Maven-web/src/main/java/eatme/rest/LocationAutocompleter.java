package eatme.rest;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Admin
 */
@Stateless
@Path("locationAutocompleter")
public class LocationAutocompleter {

    @GET
    @Path("{name}")
    @Produces({"text/plain"})
    public String find(@PathParam("name") String locationName) {
        return "Hello World from REST Webservice! Your location: " + locationName;
    }

}
