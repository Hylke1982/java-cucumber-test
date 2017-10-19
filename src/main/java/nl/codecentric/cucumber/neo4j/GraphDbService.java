package nl.codecentric.cucumber.neo4j;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Transaction;

public class GraphDbService {

    private final GraphDatabaseService graphDatabaseService;

    public GraphDbService(GraphDatabaseService graphDatabaseService) {
        this.graphDatabaseService = graphDatabaseService;
    }

    public void createScenarioNode(final String scenario){
        final Transaction transaction = graphDatabaseService.beginTx();
        graphDatabaseService.createNode(new Label() {
            @Override
            public String name() {
                return "scenario";
            }
        });
        transaction.close();
    }
}
