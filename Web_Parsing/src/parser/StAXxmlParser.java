package parser;

import parser.entity.Car;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class StAXxmlParser {


    public static List<Car> parseXMLfile(String fileName) {
        List<Car> studentsList = new ArrayList<Car>();
        Car car = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try {


            // инициализируем reader и скармливаем ему xml файл
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            // проходим по всем элементам xml файла
            while (reader.hasNext()) {

                // получаем событие (элемент) и разбираем его по атрибутам
                XMLEvent xmlEvent = reader.nextEvent();

                if (xmlEvent.isStartElement()) {

                    StartElement startElement = xmlEvent.asStartElement();

                    if (startElement.getName().getLocalPart().equals("id")) {
                        car = new Car();
                        xmlEvent = reader.nextEvent();
                        car.setId(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("name")) {
                        xmlEvent = reader.nextEvent();
                        car.setName(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("daily_rental_price")) {
                        xmlEvent = reader.nextEvent();
                        car.setDaily_rental_price(Double.valueOf(xmlEvent.asCharacters().getData()));
                    } else if (startElement.getName().getLocalPart().equals("class")) {
                        xmlEvent = reader.nextEvent();
                        car.setCar_class(xmlEvent.asCharacters().getData());
                    } else if (startElement.getName().getLocalPart().equals("busyness")) {
                        xmlEvent = reader.nextEvent();
                        car.setBusyness(Integer.parseInt(xmlEvent.asCharacters().getData()));
                    }

                }

                // if it's end element Сar,
                // so add a new user
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("car")) {
                        studentsList.add(car);
                    }
                }

            }


        } catch (Exception exc) {
            exc.printStackTrace();
        }

        return studentsList;
    }


}
