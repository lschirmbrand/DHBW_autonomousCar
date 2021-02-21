package event.indicator;

public class LeftIndicatorOff {

    private final boolean isOff;

    public LeftIndicatorOff() {
        this.isOff = true;
    }

    public String toString() {
        return "Left Indicator was turned: Off";
    }
}
