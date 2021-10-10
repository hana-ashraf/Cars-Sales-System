package carr;
public class Car {
        private int year_of_manufacturer;
        private String model_name;
        private String manufacturer_type;
        private double cost;
        private int car_id;
        private String colour;
        private static int count=1;

        //Constructor
        
        public Car() {
        }

    public Car( int year_of_manufacturer, String model_name, String manufacturer_type, double cost, String colour) {
        this.year_of_manufacturer = year_of_manufacturer;
        this.model_name = model_name;
        this.manufacturer_type = manufacturer_type;
        this.cost = cost;
        this.car_id = count;
        this.colour = colour;
        count++;
    }

        //Getters and setters

        public int getYear_of_manufacturer() {
                return year_of_manufacturer;
        }

        public void setYear_of_manufacturer(int year_of_manufacturer) {
                this.year_of_manufacturer = year_of_manufacturer;
        }

        public String getModel_name() {
                return model_name;
        }

        public void setModel_name(String model_name) {
                this.model_name = model_name;
        }

        public String getManufacturer_type() {
                return manufacturer_type;
        }

        public void setManufacturer_type(String manufacturer_type) {
                this.manufacturer_type = manufacturer_type;
        }

        public double getCost() {
                return cost;
        }

        public void setCost(double cost) {
                this.cost = cost;
        }

        public int getCar_id() {
                return car_id;
        }

        public String getColour() {
                return colour;
        }

        public void setColour(String colour) {
                this.colour = colour;
        }


        @Override
        public String toString()
        {
                return "Year of Manufacturer: " + getYear_of_manufacturer() + "\n" +
                        "Mode name           : " + getModel_name()           + "\n" +
                        "Manufacturer type   : " + getManufacturer_type()    + "\n" +
                        "Price               : " + getCost()                 + "\n" +
                        "Car ID              : " + getCar_id()               + "\n" +
                        "Colour              : " + getColour()               + "\n" +
                        "------------------------------------------"         + "\n";



        }
}