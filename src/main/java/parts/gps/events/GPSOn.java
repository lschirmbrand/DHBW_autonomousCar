package parts.gps.events;

public class GPSOn {

    private final boolean isOn;

    public GPSOn() {
        this.isOn = true;
    }

    public String toString() {
        return "GPS was turned: On";
    }
}
