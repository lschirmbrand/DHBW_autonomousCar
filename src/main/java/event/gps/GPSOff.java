package event.gps;

public class GPSOff {

    private boolean isOff;

    public GPSOff(){
        this.isOff = true;
    }

    public String toString(){
        return "GPS was turned: Off";
    }
}
