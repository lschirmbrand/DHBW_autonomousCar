package event.indicator;

public class RightIndicatorOn {

    private boolean isOn;

    public RightIndicatorOn(){
        this.isOn = true;
    }

    public String toString() {
        return "Right Indicator was turned: On";
    }
}
