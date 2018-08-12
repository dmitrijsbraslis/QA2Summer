package testDefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Response;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class WeatherStepDefs {
    private WeatherRequester weatherRequester = new WeatherRequester();
    private Response response;

    @When("we getting weather from server")
    public void get_weather() {
        response = weatherRequester.getWeather();
    }

    @Then("lon is (.*)")
    public void check_lon(BigDecimal lon) {
        assertEquals("Wrong LON", lon, response.getCoord().getLon());
    }

    @Then("lat is (.*)")
    public void check_lat(BigDecimal lat) {
        assertEquals("Wrong LAT", lat, response.getCoord().getLat());
    }
}
