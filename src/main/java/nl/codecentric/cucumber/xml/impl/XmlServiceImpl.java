package nl.codecentric.cucumber.xml.impl;

import nl.codecentric.cucumber.xml.ModificationTuple;
import nl.codecentric.cucumber.xml.XmlModificationException;
import nl.codecentric.cucumber.xml.XmlService;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Objects;

public class XmlServiceImpl implements XmlService {

    public String modifyDocument(byte[] documentInBytes, final List<ModificationTuple> modificationTupleList) {

        Objects.requireNonNull(modificationTupleList,"Modification list cannot be empty");


        try {
            final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            final Document document = dbFactory.newDocumentBuilder().parse(new ByteArrayInputStream(documentInBytes));
            final XPath xPath = XPathFactory.newInstance().newXPath();


            for(final ModificationTuple modificationTuple : modificationTupleList){
                final NodeList nodeList = (NodeList) xPath.compile(modificationTuple.getXpath()).evaluate(document, XPathConstants.NODESET);
                for (int i = 0; i < nodeList.getLength(); i++) {
                    final Node node = nodeList.item(i);
                    node.setTextContent(modificationTuple.getNewValue());
                }
            };



            return getStringFromDocument(document);
        } catch (SAXException | ParserConfigurationException | IOException | XPathExpressionException e) {
            new XmlModificationException(e);
        }

        return null;
    }

    protected String getStringFromDocument(Document doc) {
        try {
            final DOMSource domSource = new DOMSource(doc);
            final StringWriter writer = new StringWriter();
            final StreamResult result = new StreamResult(writer);
            final TransformerFactory tf = TransformerFactory.newInstance();
            final Transformer transformer = tf.newTransformer();
            transformer.transform(domSource, result);
            return writer.toString();
        } catch (TransformerException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
