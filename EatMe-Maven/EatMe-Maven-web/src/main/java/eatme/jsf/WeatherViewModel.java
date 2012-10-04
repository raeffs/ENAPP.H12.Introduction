package eatme.jsf;

import eatme.boundary.WeatherManager;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Admin
 */
@Named(value = "weatherViewModel")
@RequestScoped
public class WeatherViewModel {

    @Inject
    private WeatherManager weatherManager;
    
    public String getSkyConditions() {
        return weatherManager.getTodaysWeather();
    }
}
