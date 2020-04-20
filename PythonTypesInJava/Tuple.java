import java.util.*;

public class Tuple<T> {
    public T itemA;
    public T itemB;

    public Tuple(T a, T b) {
        itemA = a;
        itemB = b;
    }
    public T get(int i) {
        if (i == 0)
            return itemA;
        return itemB;
    }
    public boolean equals(Tuple otherTuple) {
        return itemA.equals(otherTuple.itemA) && itemB.equals(otherTuple.itemB);
    }

    public String toString() {
        return "(" + itemA.toString() + ", " + itemB.toString() + ")";
    }
}