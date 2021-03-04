package parts.ledHeadlights.events;

public class LEDDimmed {
    private final boolean isDimmed;

    public LEDDimmed() {
        this.isDimmed = true;
    }

    public String toString() {
        return "LED Headlight was: Dimmed.";
    }
}
