package nl.codecentric.cucumber.configuration;

import nl.codecentric.cucumber.neo4j.GraphDbService;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Configuration
public class Neo4jConfiguration {

    @Bean(destroyMethod = "shutdown")
    public GraphDatabaseService graphDb() throws IOException {
        return new GraphDatabaseFactory().newEmbeddedDatabase(Files.createTempDirectory("neo4j").toFile() );
    }

    @Bean
    public GraphDbService graphDbService(final GraphDatabaseService graphDb){
        return new GraphDbService(graphDb);
    }
}
