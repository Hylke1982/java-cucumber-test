package nl.codecentric.cucumber.example.steps;

import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.codecentric.cucumber.SomeService;
import nl.codecentric.cucumber.configuration.BaseConfiguration;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

public class RestCallSteps extends AbstractSteps{


    @Autowired
    private SomeService someService;

    @Before
    public void before(final Scenario scenario){
        registerScenario(scenario);
    }

    @Given("^A document is modified for a request$")
    public void givenBla(){

        someService.openXmlWithContext();
    }

    @When("^I do a correct REST request$")
    public void iDoACorrectRESTRequest() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I expect OK status code$")
    public void iExpectOKStatusCode() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
