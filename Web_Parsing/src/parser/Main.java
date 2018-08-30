package parser;

import java.io.*;
import java.util.List;

import javax.smartcardio.Card;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import parser.entity.Car;

public class Main {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\User\\IdeaProjects\\Web_Parsing\\src\\parser\\cars.xml";


        DOMxmlReader.ParseCars(filePath);



        System.out.println(); ///////////////////////////////////////////



        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAXxmlParser saxp = new SAXxmlParser();
            parser.parse(new File(filePath), saxp);

            List<Car> cars = saxp.getResult();
            for (Car car: cars) {
                System.out.println(car.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }




        System.out.println(); ///////////////////////////////////////////



        List<Car> carList = StAXxmlParser.parseXMLfile(filePath);

        for (Car car : carList) {
            System.out.println(car.toString());
        }


    }
}
