package event.camera;

public class CameraOff {

    private boolean isOff;

    public CameraOff(){
        this.isOff = true;
    }

    public String toString() {
        return "Camera was turned: Off";
    }
}
