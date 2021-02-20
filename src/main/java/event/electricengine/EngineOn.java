package event.electricengine;

public class EngineOn {

    private boolean isOn;

    public EngineOn() {
        this.isOn = true;
    }

    public boolean getIsOn() {
        return this.isOn;
    }

    public String toString() {
        return "Engine was turned: On";
    }
}
