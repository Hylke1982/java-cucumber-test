package nl.codecentric.cucumber.xml;

import java.util.List;

public interface XmlService {

    /**
     * Modify document using these expressions
     *
     * @param documentInBytes
     * @param modifications
     * @return
     */
    String modifyDocument(final byte[] documentInBytes, final List<ModificationTuple> modifications);

}
