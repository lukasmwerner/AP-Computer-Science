public class Vehicle extends CityObject {
    private int speed;
    private String direction;

    public Vehicle(String name, int x, int y, int speed, String direction) {
        super(name, x, y);
        this.speed = speed;
        this.direction = direction;
    }

    public String toString() {
        String str = super.toString();
        return str + " speed: " + speed + " direction: " + direction;
    }
}