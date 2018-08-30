package parser;

// SAX
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import parser.entity.Car;

import java.util.ArrayList;
import java.util.List;


public class SAXxmlParser extends DefaultHandler{

    private List<Car> cars = new ArrayList<Car>();
    private Car car;
    private String thisElement = "";



    public List<Car> getResult(){
        return cars;
    }



    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parse XML...");
    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("id")) {
            car = new Car();
            car.setId(new String(ch, start, length));
        }
        if (thisElement.equals("name")) {
            car.setName(new String(ch, start, length));
        }
        if (thisElement.equals("daily_rental_price")) {
            car.setDaily_rental_price(new Double(new String(ch, start, length)));
        }
        if (thisElement.equals("class")) {
            car.setCar_class(new String(ch, start, length));
        }
        if (thisElement.equals("busyness")) {
            car.setBusyness(new Integer(new String(ch, start, length)));
            cars.add(car);
        }
    }

    @Override
    public void endDocument() {
        System.out.println("Stop parse XML...");
    }


}
