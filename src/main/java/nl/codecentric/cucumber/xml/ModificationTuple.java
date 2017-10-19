package nl.codecentric.cucumber.xml;

public class ModificationTuple {

    private final String xpath;

    private final String newValue;

    public ModificationTuple(final String xpath, final String newValue) {
        this.xpath = xpath;
        this.newValue = newValue;
    }

    public String getXpath() {
        return xpath;
    }

    public String getNewValue() {
        return newValue;
    }
}
