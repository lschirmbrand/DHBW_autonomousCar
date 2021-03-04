package parts.gps.events;

public class GPSOff {

    private final boolean isOff;

    public GPSOff() {
        this.isOff = true;
    }

    public String toString() {
        return "GPS was turned: Off";
    }
}
