package event.electricengine;

public class EngineOff {
    private boolean isOff;

    public EngineOff(){
        this.isOff = true;
    }

    public boolean getIsOn(){
        return this.isOff;
    }

    public String toString(){
        return "Engine was turned: Off";
    }

}
