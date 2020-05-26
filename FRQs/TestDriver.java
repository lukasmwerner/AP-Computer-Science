import java.util.ArrayList;
import java.util.Arrays;

public class TestDriver {

  public static void main(String[] args) {
    Gizmo a = new Gizmo("ABC", true);
    Gizmo b = new Gizmo("ABC", false);
    Gizmo c = new Gizmo("XYZ", true);
    Gizmo d = new Gizmo("lmnop", false);
    Gizmo e = new Gizmo("ABC", true);
    Gizmo f = new Gizmo("ABC", false);
    ArrayList<Gizmo> items = new ArrayList<Gizmo>(
      Arrays.asList(a, b, c, d, e, f)
    );
    OnlinePurchaseManager opm = new OnlinePurchaseManager(items);
    String pass = "✅ Test Case Passed";
    String fail = "❌ Test Case Failed";
    System.out.println(opm.countElectronicsByMaker("ABC") == 2 ? pass : fail);
    System.out.println(opm.countElectronicsByMaker("lmnop") == 0 ? pass : fail);
    System.out.println(opm.countElectronicsByMaker("XYZ") == 1 ? pass : fail);
    System.out.println(opm.countElectronicsByMaker("QRP") == 0 ? pass : fail);
    System.out.println(opm.hasAdjacentEqualPair() == false ? pass : fail);
    Gizmo g = new Gizmo("ABC", false);
    Gizmo h = new Gizmo("ABC", false);
    ArrayList<Gizmo> otherList = new ArrayList<Gizmo>(Arrays.asList(g, h));
    OnlinePurchaseManager opm2 = new OnlinePurchaseManager(otherList);
    System.out.println(opm2.hasAdjacentEqualPair() == true ? pass : fail);
  }
}
