package event.brakelight;

public class BrakeLightOn {

    private boolean isOn;

    public BrakeLightOn(){
        this.isOn = true;
    }

    public String toString(){
        return "Brake Light was turned: On";
    }
}
