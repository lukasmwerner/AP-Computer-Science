import java.util.ArrayList;

public class DailySchedule {
  private ArrayList<Appointment> apptList;

  public DailySchedule() {
    apptList = new ArrayList<Appointment>();
  }

  public void clearConflicts(Appointment appt) {
    for (int i = 0; i < apptList.size(); i++) {
      Appointment appointment = apptList.get(i);
      if (appointment.conflictsWith(appt)) {
        apptList.remove(i);
        i--; //Avoid skipping errors (aka when we delete we skip too many)
      }
    }
  }

  public boolean addAppt(Appointment appt, boolean emergency) {
    boolean conflicted = false;
    for (int i = 0; i < apptList.size(); i++) {
      Appointment appointment = apptList.get(i);
      if (appointment.conflictsWith(appt)) {
        conflicted = true;
        break;
      }
    }
    boolean didAdd = false;
    if (emergency) {
      clearConflicts(appt);
    }
    if (!conflicted || emergency) {
      apptList.add(appt);
      didAdd = true;
    }
    return didAdd;
  }
}
