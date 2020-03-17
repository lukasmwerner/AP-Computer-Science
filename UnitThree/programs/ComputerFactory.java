public class ComputerFactory {

  public static void main(String[] args) {

    Computer comp1 = new Computer();
    comp1.processor = "Intel i7 5500 2.40 GHz";
    comp1.memory = 16;
    comp1.storage = 500;

    System.out.println(comp1);

  }

}
