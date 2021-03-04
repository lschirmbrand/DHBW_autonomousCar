package parts.electricEngine.event;

public class EngineOn {

    private final boolean isOn;

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
