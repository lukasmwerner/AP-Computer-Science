public class Appointment {
  private TimeInterval timeInterval;

  public TimeInterval getTime() {
    return timeInterval;
  }

  public boolean conflictsWith(Appointment other) {
    return this.timeInterval.overlapsWith(other.getTime());
  }
}
