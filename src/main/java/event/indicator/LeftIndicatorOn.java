package event.indicator;

public class LeftIndicatorOn {

    private final boolean isOn;

    public LeftIndicatorOn() {
        this.isOn = true;
    }

    public String toString() {
        return "Left Indicator was turned: On";
    }
}
