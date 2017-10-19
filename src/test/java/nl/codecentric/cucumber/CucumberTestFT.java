package nl.codecentric.cucumber;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"nl.codecentric.cucumber"},
        features = {"classpath:features/access-rest-api.feature"},
        format = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber-access-rest-api.json"})
public class CucumberTestFT {
}
