package event.brakelight;

public class BrakeLightOff {

    private boolean isOff;

    public BrakeLightOff(){
        this.isOff = true;
    }

    public String toString() {
        return "Brake Light was set to: Off";
    }
}
