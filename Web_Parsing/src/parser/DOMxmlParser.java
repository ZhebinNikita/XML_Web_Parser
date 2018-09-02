package parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import parser.entity.Car;


public class DOMxmlParser {

    private static List<Car> carList;

    public static void ParseCars(String filepath){

        File xmlFile = new File(filepath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;

        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());

            // теперь XML полностью загружен в память
            // в виде объекта Document

            NodeList nodeList = doc.getElementsByTagName("car");

            carList = new ArrayList<Car>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                carList.add(getCar(nodeList.item(i)));
            }

            // show all info
            for (Car car : carList) {
                System.out.println(car.toString());
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        }

    }


    private static Car getCar(Node node) {
        Car car = new Car();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            car.setId(getTagValue("id", element));
            car.setName(getTagValue("name", element));
            car.setDaily_rental_price(Double.parseDouble(getTagValue("daily_rental_price", element)));
            car.setCar_class(getTagValue("class", element));
            car.setBusyness(Integer.parseInt(getTagValue("busyness", element)));
        }
        return car;
    }


    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }


    public static List<Car> getCarList() {
        return carList;
    }

}
