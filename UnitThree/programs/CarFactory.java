public class CarFactory {

    public static void main(String[] args) {
        Car car1 = new Car();
        car1.numDoors = 4;
        car1.color = "Beige";
        Car car2 = new Car();
        car2.numDoors = 2;
        car2.color = "Red";

        Car car3 = new Car(3, "Orange");

        System.out.println(car3);
    }
}