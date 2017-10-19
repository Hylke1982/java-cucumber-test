package nl.codecentric.cucumber.impl;

import cucumber.api.Scenario;
import nl.codecentric.cucumber.SomeService;
import nl.codecentric.cucumber.xml.ModificationTuple;
import nl.codecentric.cucumber.xml.XmlService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class SomeServiceImpl implements SomeService {

    @Autowired
    private AtomicReference<Scenario> scenarioAtomicReference;


    @Autowired
    private byte[] templatePets;

    private final XmlService xmlService;

    public SomeServiceImpl(final XmlService xmlService) {
        this.xmlService = xmlService;
    }

    @Override
    public void openXmlWithContext() {
        final Scenario scenario = scenarioAtomicReference.get();
        scenario.write("Open XML with context for: " + scenario.getId());
        final ModificationTuple modificationTuple = new ModificationTuple("/pets/pet[@id=\"cat\"]/name", "whiskers");
        final List<ModificationTuple> modificationTuples = Arrays.asList(modificationTuple);
        final String xmlData = xmlService.modifyDocument(templatePets, modificationTuples);
        // Do something with the data
    }
}
