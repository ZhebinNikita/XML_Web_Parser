package parser.test;

import org.junit.jupiter.api.*;
import parser.DOMxmlParser;
import parser.SAXxmlParser;
import parser.StAXxmlParser;
import parser.entity.Car;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParsedObjectsTest {

    private static String FILE_PATH = "C:\\Users\\User\\IdeaProjects\\Web_Parsing\\src\\parser\\cars.xml";


    @Test
    public void testDOMParsedObjects(){

        DOMxmlParser.ParseCars(FILE_PATH);
        List<Car> actual = DOMxmlParser.getCarList();

        List<Car> expected = new ArrayList<Car>();
        expected.add(new Car("ID_1", "One", 100, "Mini", 0));
        expected.add(new Car("ID_2", "Two", 200, "Lux", 0));
        expected.add(new Car("ID_3", "Three", 300, "Family", 1));



        assertEquals(expected.size(), actual.size(), "Different sizes!!");

        assertCarEquals(expected, actual);

    }


    @Test
    public void testSAXParsedObjects(){

        List<Car> actual = new ArrayList<Car>();
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAXxmlParser saxp = new SAXxmlParser();
            parser.parse(new File(FILE_PATH), saxp);

            actual = saxp.getResult();
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Car> expected = new ArrayList<Car>();
        expected.add(new Car("ID_1", "One", 100, "Mini", 0));
        expected.add(new Car("ID_2", "Two", 200, "Lux", 0));
        expected.add(new Car("ID_3", "Three", 300, "Family", 1));



        assertEquals(expected.size(), actual.size(), "Different sizes!!");

        assertCarEquals(expected, actual);

    }


    @Test
    public void testStAXParsedObjects(){

        List<Car> actual = StAXxmlParser.parseXMLfile(FILE_PATH);

        List<Car> expected = new ArrayList<Car>();
        expected.add(new Car("ID_1", "One", 100, "Mini", 0));
        expected.add(new Car("ID_2", "Two", 200, "Lux", 0));
        expected.add(new Car("ID_3", "Three", 300, "Family", 1));



        assertEquals(expected.size(), actual.size(), "Different sizes!!");

        assertCarEquals(expected, actual);

    }


    public void assertCarEquals(List<Car> expected, List<Car> actual){
        for(int i = 0; i < expected.size(); i++){
            assertEquals(expected.get(i).getId(), actual.get(i).getId());
            assertEquals(expected.get(i).getName(), actual.get(i).getName());
            assertEquals(expected.get(i).getDaily_rental_price(), actual.get(i).getDaily_rental_price());
            assertEquals(expected.get(i).getCar_class(), actual.get(i).getCar_class());
            assertEquals(expected.get(i).getBusyness(), actual.get(i).getBusyness());
        }
    }


}
