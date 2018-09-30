package testDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import model.Address;
import model.Client;
import model.RegistrationResponse;
import org.junit.Assert;

import java.util.Map;

public class RegistrationStepDefs {
    private Client client = new Client();
    private RegistrationResponse response = new RegistrationResponse();
    private RegistrationRequester requester = new RegistrationRequester();

    @Given("client:")
    public void set_client(Map<String, String> data) {
        client.setEmail(data.get("email"));
        client.setPwd(data.get("pwd"));
        //....
    }

    @Given("client address is:")
    public void set_address(Map<String, String> data) {
        Address address = new Address();
        address.setCity(data.get("city"));
        //......

        client.setAddress(address);
    }

    @When("we register user")
    public void register_user() {
        response = requester.register(client);
    }

    @Then("response is:")
    public void check_response(Map<String, String> data) {
        Assert.assertEquals("", data.get("details"), response.getDetails());
    }
}
