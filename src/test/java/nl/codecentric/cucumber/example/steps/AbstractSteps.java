package nl.codecentric.cucumber.example.steps;

import cucumber.api.Scenario;
import nl.codecentric.cucumber.configuration.BaseConfiguration;
import nl.codecentric.cucumber.neo4j.GraphDbService;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.concurrent.atomic.AtomicReference;

@ContextConfiguration(classes = {BaseConfiguration.class})
public abstract class AbstractSteps {

    @Autowired
    private AtomicReference<Scenario> scenarioAtomicReference;

    @Autowired
    private GraphDbService graphDbService;

    protected void registerScenario(final Scenario scenario) {
        System.out.println(String.format("Scenario id %s", scenario.getId()));
        scenarioAtomicReference.set(scenario);
        graphDbService.createScenarioNode(scenario.getId());
    }
}
