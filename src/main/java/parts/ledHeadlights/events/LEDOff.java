package parts.ledHeadlights.events;

public class LEDOff {
    private final boolean isLEDOff;

    public LEDOff() {
        this.isLEDOff = true;
    }

    public String toString() {
        return "LED Headlight was turned: Off";
    }
}
