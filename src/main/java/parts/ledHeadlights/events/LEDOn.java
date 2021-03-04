package parts.ledHeadlights.events;

public class LEDOn {

    private final boolean isLEDOn;

    public LEDOn() {
        this.isLEDOn = true;
    }

    public String toString() {
        return "LED Headlights were turned: On";
    }
}
