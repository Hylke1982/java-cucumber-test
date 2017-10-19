package nl.codecentric.cucumber.xml.impl;

import nl.codecentric.cucumber.configuration.XmlTemplatesConfiguration;
import nl.codecentric.cucumber.xml.ModificationTuple;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;

public class XmlServiceImplTest {

    XmlTemplatesConfiguration xmlTemplatesConfiguration = new XmlTemplatesConfiguration();
    private XmlServiceImpl xmlService;

    @Before
    public void before() {

        xmlService = new XmlServiceImpl();

    }

    @Test
    public void testModifyDocument() throws Exception {
        final ModificationTuple modificationTuple = new ModificationTuple("/pets/pet[@id=\"cat\"]/name", "whiskers");
        final List<ModificationTuple> modificationTuples = Arrays.asList(modificationTuple);
        final String xmlData = xmlService.modifyDocument(xmlTemplatesConfiguration.templatePets(), modificationTuples);
        assertNotNull(xmlData);
        assertThat(xmlData, containsString("whiskers"));
    }

    @Test
    public void testModifyDocumentWithNullList() throws Exception {
        try {
            final List<ModificationTuple> modificationTuples = null;
            final String xmlData = xmlService.modifyDocument(xmlTemplatesConfiguration.templatePets(), modificationTuples);
            fail("Should not reach this point");
        }catch (final NullPointerException e){
            assertThat(e.getMessage(), containsString("Modification list cannot be empty"));
        }
    }

}