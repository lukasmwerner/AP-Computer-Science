public class StepTracker {
    private int numActiveDays;
    private int trackedDays;
    private int totalSteps;
    private int activeThresh;

    public StepTracker() {activeThresh = 10000;}
    public StepTracker(int thresh) {
        activeThresh =  thresh;
    }
    public int activeDays() {return numActiveDays;}
    public void addDailySteps(int stepsWalked) {
        trackedDays++;
        if (stepsWalked >= activeThresh) {numActiveDays++;}
        totalSteps += stepsWalked;
    }
    public double averageSteps() {
        if (trackedDays == 0) {return 0.0;}
        return totalSteps / trackedDays;
    }
}