public class Camera {

    private enum CameraVariantE {
        V1, V2
    }

    private static Camera instance = new Camera();

    public Camera.Port port;

    private CameraVariantE cameraVariant;
    private boolean isOn = false;

    private Camera(){
        this.port = new Port();
    }

    public static Camera getInstance(){
        return instance;
    }

    public String innerCameraOn() {
        if(isOn){
            return "Camera was already: On";
        }
        else{
            this.isOn = true;
            return "Camera was turned: On";
        }
    }

    public String innerCameraOff() {
        if(isOn){
            this.isOn = false;
            return "Camera was turned: On";
        }
        else{
            return "Camera was already: On";
        }
    }

    public String innerSetCameraVariant(String variant) {
        if (variant.equals("V1")) {
            this.cameraVariant = CameraVariantE.V1;
            return "Changed Camera to: " + this.cameraVariant.toString();
        } else {
            this.cameraVariant = CameraVariantE.V2;
            return "Changed Camera to: " + this.cameraVariant.toString();
        }
    }

    // inner class port
    public class Port implements ICamera {

        @Override
        public String cameraOn() {
            return innerCameraOn();
        }

        @Override
        public String cameraOff() {
            return innerCameraOff();
        }

        @Override
        public String setCameraVariant(String variant) {
            return innerSetCameraVariant(variant);
        }
    }
}