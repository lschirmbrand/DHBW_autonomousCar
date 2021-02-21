package event.gps;

public class GPSConnectSatellite {

    private final String frequency;

    public GPSConnectSatellite(String frequency) {
        this.frequency = frequency;
    }

    public String toString() {
        return "GPS was connected with Frequency: " + this.frequency + " Hz";
    }
}
