import java.util.*;
public class Test {
    public static void main(String[] args) {
        Any a = new Any(1);
        System.out.println(a);
        System.out.println(a.type());
        a.set("hi");
        System.out.println(a);
        System.out.println(a.type());
        Any b = new Any("hi");
        Any c = new Any(1);
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));

        ArrayList<Any> listOfAnys = new ArrayList<Any>();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                listOfAnys.add(new Any("I'm not an int"));
            } else {
                listOfAnys.add(new Any(i));
            }
        }
        for (Any any : listOfAnys) {
            System.out.print(any.toString() + ", ");
        }
        System.out.println();

        ///////////////////////////////
        Tuple t = new Tuple("Lukas", 15);
        Tuple s = new Tuple("Lukas", 15);
        System.out.println(t);
        System.out.println(t.equals(s));
    }
}

