package eatme.boundary;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import eatme.boundary.dto.Cloudiness;
import eatme.boundary.dto.ProductType;
import eatme.boundary.dto.TimeType;
import eatme.boundary.dto.WeatherResponseFromString;
import eatme.boundary.dto.Weatherdata;
import eatme.boundary.webservices.weather.GlobalWeather;
import java.io.StringReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
            callWeatherServiceRestful();
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

    private void callWeatherServiceRestful() {
        String base_uri = "http://api.met.no/weatherapi/locationforecast";

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource webResource = client.resource(base_uri).path("1.8");

        Weatherdata result = webResource
                .queryParam("lat", "47.0137")
                .queryParam("lon", "8.3054")
                .queryParam("msl", "440")
                .get(Weatherdata.class);
        Cloudiness c = null;
        for (ProductType pt : result.getProduct()) {
            Calendar gc = new GregorianCalendar();
            for (TimeType t : pt.getTime()) {
                if (t.getFrom().getDay() == gc.get(Calendar.DAY_OF_MONTH)
                        && t.getFrom().getHour() == 12) {
                    try {
                        c = (Cloudiness) t.getLocation().get(0)
                                .getGroundCoverAndPressureAndMaximumPrecipitation()
                                .get(5)
                                .getValue();
                        break;
                    } catch (Exception e) {
                        // nothing to do
                    }
                }
            }
        }
        if (c == null) {
            this.todaysWeather = "unknown";
        } else {
            this.todaysWeather = c.getPercent();
        }
    }
}
