package event.electricengine;

public class IncreaseRPM {

    private int deltaRPM;
    private int seconds;

    public IncreaseRPM(int deltaRPM, int seconds){
        this.deltaRPM = deltaRPM;
        this.seconds = seconds;
    }

    public String toString(){
        return "Engine RPM was increased for " + this.deltaRPM + " RPMs for " + this.seconds + " seconds.";
    }

    public int getDeltaRPM() {
        return deltaRPM;
    }

    public int getSeconds() {
        return seconds;
    }
}
