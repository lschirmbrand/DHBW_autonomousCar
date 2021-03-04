package parts.electricEngine.event;

public class DecreaseRPM {

    private final int deltaRPM;
    private final int seconds;

    public DecreaseRPM(int deltaRPM, int seconds) {
        this.deltaRPM = deltaRPM;
        this.seconds = seconds;
    }

    public String toString() {
        return "Engine RPM was decreased for " + this.deltaRPM + " RPMs for " + this.seconds + " seconds.";
    }

    public int getDeltaRPM() {
        return deltaRPM;
    }

    public int getSeconds() {
        return seconds;
    }
}
