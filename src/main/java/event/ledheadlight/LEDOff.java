package event.ledheadlight;

public class LEDOff {
    private boolean isOff;

    public LEDOff(){
        this.isOff = true;
    }

    public String toString(){
        return "LED Headlight was turned: Off";
    }
}
