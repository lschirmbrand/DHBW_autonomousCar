package parts.electricEngine.event;

public class EngineOff {
    private final boolean isOff;

    public EngineOff() {
        this.isOff = true;
    }

    public boolean getIsOn() {
        return this.isOff;
    }

    public String printString() {
        return "Engine was turned: Off";
    }

}
