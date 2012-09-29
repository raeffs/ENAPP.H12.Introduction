package eatme.boundary;

import eatme.boundary.dto.WeatherResponseFromString;
import eatme.boundary.webservices.weather.GlobalWeather;
import java.io.StringReader;
import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Admin
 */
@Stateful
@LocalBean
public class WeatherManager {

    private String todaysWeather;
    private long lastUpdate;

    public String getTodaysWeather() {
        if (todaysWeather == null || (System.currentTimeMillis() - lastUpdate) > (1000 * 3600 * 12)) {
            callWeatherService();
        }
        return todaysWeather;
    }

    private void callWeatherService() {
        GlobalWeather weatherService = new GlobalWeather();
        String rawResponse = weatherService.getGlobalWeatherSoap().getWeather("Zurich", "Switzerland");
        WeatherResponseFromString response = unmarshallResponse(rawResponse);
        if (response != null && response.getStatus().equals("Success")) {
            todaysWeather = response.getSkyConditions();
        } else {
            todaysWeather = null;
        }
    }

    private WeatherResponseFromString unmarshallResponse(String rawResponse) {
        WeatherResponseFromString response = null;
        try {
            JAXBContext context = JAXBContext.newInstance(WeatherResponseFromString.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            response = (WeatherResponseFromString) unmarshaller.unmarshal(new StringReader(rawResponse));
        } finally {
            return response;
        }
    }
}
