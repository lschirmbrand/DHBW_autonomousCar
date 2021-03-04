package parts.brake.event;

public class BrakeSet {
    private final float value;

    public BrakeSet(float percentage) {
        this.value = percentage;
    }

    public String toString() {
        return "Brake was set to: " + this.value + "%.";
    }

    public float getValue() {
        return this.value;
    }

}
