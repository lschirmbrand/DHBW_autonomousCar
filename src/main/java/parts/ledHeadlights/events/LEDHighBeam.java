package parts.ledHeadlights.events;

public class LEDHighBeam {

    private final boolean isHighBeam;

    public LEDHighBeam() {
        this.isHighBeam = true;
    }

    public String toString() {
        return "LED Headlight was set to: High Beam";
    }
}
