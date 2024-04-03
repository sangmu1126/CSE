class Car {
    String model;
    String color;
    int year;

    Car() {}
    Car(String model) {
        this.model = model;
    }
    Car(String model, String color) {
        this.model = model;
        this.color = color;
    }

    Car(String model, String color, int year) {
        this.model = model;
        this.color = color;
        this.year = year;
    }

    public void printInfo() {
        System.out.println(this.model + " " + this.color + " " + this.year);
    }
}

public class Lab04_1 {
        public static void main(String[] args) {
        Car car1 = new Car();
        Car car2 = new Car("MC20");
        Car car3 = new Car("MC20", "white");
        Car car4 = new Car("MC20", "white", 2021);

        car1.printInfo();
        car2.printInfo();
        car3.printInfo();
        car4.printInfo();
    }
}

