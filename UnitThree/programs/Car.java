public class Car {
    int numDoors;
    String color;

    public Car (int doors, String color) {
        numDoors = doors;
        this.color = color;
    }

    public Car () {}

    public String toString() {
        return "Your car has " + numDoors + " doors and is " + color + " color";
    }
}