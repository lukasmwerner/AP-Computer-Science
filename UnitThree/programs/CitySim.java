public class CitySim {

  public static void main(String[] args) {

    CityObject city1 = new CityObject("Park", 0, 0);
    Building city2 = new Building("Office", 1, 0, 200);
    CityObject city3 = new Building("Hospital", 0, 1, 400);
    // Building city4 = new CityObject("Road", 1, 1);   // Does not work.  Why?
    Vehicle city4 = new Vehicle("Toyota", 2, 2, 10, "N");

    System.out.println(city1);
    System.out.println(city2);
    System.out.println(city3);
    System.out.println(city4);
  }

}
