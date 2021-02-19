package event.indicator;

public class RightIndicatorOff {

    private boolean isOff;

    public RightIndicatorOff(){
        this.isOff = true;
    }

    public String toString() {
        return "Right Indicator was turned: Off";
    }
}
