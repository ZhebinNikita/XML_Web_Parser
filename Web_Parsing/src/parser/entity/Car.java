package parser.entity;

public class Car {

    private String id;
    private String name;
    private double daily_rental_price;
    private String car_class;
    private int busyness;


    public Car(){
        // Initializing
    }
    public Car(String id, String name, double daily_rental_price, String car_class, int busyness){
        this.id = id;
        this.name = name;
        this.daily_rental_price = daily_rental_price;
        this.car_class = car_class;
        this.busyness = busyness;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDaily_rental_price() {
        return daily_rental_price;
    }

    public void setDaily_rental_price(double daily_rental_price) {
        this.daily_rental_price = daily_rental_price;
    }

    public String getCar_class() {
        return car_class;
    }

    public void setCar_class(String car_class) {
        this.car_class = car_class;
    }

    public int getBusyness() {
        return busyness;
    }

    public void setBusyness(int busyness) {
        this.busyness = busyness;
    }


    @Override
    public String toString() {
        return  "ID: " + this.id
                + ", Name: " + this.name
                + ", Daily rental price: " + this.daily_rental_price
                + ", Class: " + this.car_class
                + ", Busyness: " + this.busyness;
    }


    @Override
    public boolean equals(Object obj) {

        try {
            Car car = (Car)obj;

            if(this.id.compareTo(car.id) == 0 && this.name.compareTo(car.name) == 0
                && this.daily_rental_price == car.daily_rental_price && this.car_class.compareTo(car.car_class) == 0
                && this.busyness == car.busyness){
                return true;
            }
        }
        catch (Exception e){

        }
        finally{
            return false;
        }

    }


    @Override
    public int hashCode() {
        return 31 * (int)daily_rental_price + busyness + id.hashCode() + name.hashCode() + car_class.hashCode();
    }
}
