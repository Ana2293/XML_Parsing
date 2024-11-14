import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import javax.xml.xpath.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws XPathExpressionException, FileNotFoundException {
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        XPathExpression xPathExpression = xPath.compile("//book[price>10 and translate(publish_date, '-', '') " +
                "> translate('2005-12-31', '-', '')]/*");

        File file = new File("books.xml");

        InputSource inputSource = new InputSource(new FileInputStream(file));
        Object object = xPathExpression.evaluate(inputSource, XPathConstants.NODESET);
        NodeList nodeList = (NodeList)object;

        for(int i = 0; i<nodeList.getLength(); i++){
            System.out.println("Node name: " + nodeList.item(i).getNodeName());
            System.out.println("Text content: " + nodeList.item(i).getTextContent());
        }
        }
    }

