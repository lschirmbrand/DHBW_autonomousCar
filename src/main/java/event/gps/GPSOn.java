package event.gps;

public class GPSOn {

    private boolean isOn;

    public GPSOn(){
        this.isOn = true;
    }

    public String toString() {
        return "GPS was turned: On";
    }
}
