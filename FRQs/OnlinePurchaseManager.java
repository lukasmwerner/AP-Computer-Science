import java.util.ArrayList;

public class OnlinePurchaseManager {
    private ArrayList<Gizmo> purchases;

    public OnlinePurchaseManager(ArrayList<Gizmo> p) {purchases = p;}
    public int countElectronicsByMaker(String maker) {
        int count = 0;
        for (Gizmo gizmo : purchases) {
            if (gizmo.isElectronic() && gizmo.getMaker().equals(maker))
                count++;
        }
        return count;
    }
    public boolean hasAdjacentEqualPair() {

        Gizmo prev = purchases.get(0);
        for (int i = 1; i < purchases.size(); i++) {
            Gizmo current = purchases.get(i);
            if (current.equals(prev)) {
                return true;
            }
            prev = current;
        }
        return false;
    }
}