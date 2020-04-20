import java.util.*;

public class Any<T> {
  private T item;

  public Any(T item) {
    this.item = item;
  }

  public void set(T item) {
    this.item = item;
  }

  public T get() {
    return item;
  }

  public String toString() {
    return item.toString();
  }

  public String type() {
    return item.getClass().getSimpleName();
  }

  public boolean equals(Any otherAny) {
    return item.equals(otherAny.get());
  }
}
