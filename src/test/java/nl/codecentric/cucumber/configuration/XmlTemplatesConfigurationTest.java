package nl.codecentric.cucumber.configuration;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class XmlTemplatesConfigurationTest {

    XmlTemplatesConfiguration uut;

    @Before
    public void setUp() throws Exception {
        uut = new XmlTemplatesConfiguration();
    }

    @Test
    public void templatePets() throws Exception {
        final byte[] bytes = uut.templatePets();
        assertThat(bytes.length, is(greaterThan(0)));
    }

}