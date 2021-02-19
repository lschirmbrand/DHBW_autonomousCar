package event.brake;

public class BrakeSet {
    private float value;

    public BrakeSet(float percentage){
        this.value = percentage;
    }

    public String toString(){
        return "Brake was set to: " + this.value + "%.";
    }
}
