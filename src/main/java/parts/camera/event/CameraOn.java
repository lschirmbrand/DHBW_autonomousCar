package parts.camera.event;

public class CameraOn {

    private boolean isOff;

    public CameraOn() {
        this.isOff = true;
    }

    public String toString() {
        return "Camera was turned: On";
    }
}
