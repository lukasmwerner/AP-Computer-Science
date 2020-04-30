
public class Gizmo {
    private String maker;
    private boolean isElectronic;
    public Gizmo(String m, boolean i) {
        maker = m;
        isElectronic = i;
    }
    public String getMaker() {
        return maker;
    }
    public boolean isElectronic() {
        return isElectronic;
    }
    @Override
    public boolean equals(Object obj) {
        Gizmo other = (Gizmo)(obj);
        return getMaker().equals(other.getMaker()) && isElectronic() == other.isElectronic();
    }
}