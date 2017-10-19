package nl.codecentric.cucumber.configuration;


import org.apache.commons.io.IOUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class XmlTemplatesConfiguration {


    @Bean
    public byte[] templatePets() throws IOException {
        InputStream in = null;
        try {
            in = this.getClass().getResourceAsStream("/xml/pets.xml");
            return IOUtils.toByteArray(in);
        } finally {
            in.close();
        }
    }
}
