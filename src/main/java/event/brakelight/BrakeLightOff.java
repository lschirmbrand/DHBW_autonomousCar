package event.brakelight;

public class BrakeLightOff {

    private final boolean isOff;

    public BrakeLightOff() {
        this.isOff = true;
    }

    public String toString() {
        return "Brake Light was set to: Off";
    }
}
