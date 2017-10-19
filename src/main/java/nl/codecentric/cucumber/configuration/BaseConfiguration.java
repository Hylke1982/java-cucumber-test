package nl.codecentric.cucumber.configuration;

import cucumber.api.Scenario;
import nl.codecentric.cucumber.SomeService;
import nl.codecentric.cucumber.impl.SomeServiceImpl;
import nl.codecentric.cucumber.xml.XmlService;
import nl.codecentric.cucumber.xml.impl.XmlServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.util.concurrent.atomic.AtomicReference;

@Configuration
@Import(value = {XmlTemplatesConfiguration.class, Neo4jConfiguration.class})
public class BaseConfiguration {

    @Bean
    SomeService someService(final XmlService xmlService){
        return new SomeServiceImpl(xmlService);
    }

    @Bean
    XmlService xmlService(){
        return new XmlServiceImpl();
    }

    @Bean
    AtomicReference<Scenario> scenarioAtomicReference(){
        return new AtomicReference<>();
    }


}
