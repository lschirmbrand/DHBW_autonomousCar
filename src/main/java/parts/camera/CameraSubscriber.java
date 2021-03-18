package parts.camera;

import com.google.common.eventbus.Subscribe;
import parts.Subscriber;
import parts.camera.event.CameraOff;
import parts.camera.event.CameraOn;

import java.lang.reflect.Method;

public class CameraSubscriber extends Subscriber {

    private final Object cameraPort;

    public CameraSubscriber(Object cameraPort) {
        this.cameraPort = cameraPort;
    }

    @Subscribe
    public void receive(CameraOn cameraOn) {
        try {
            Method onMethod = cameraPort.getClass().getDeclaredMethod("cameraOn");
            onMethod.invoke(cameraPort);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(CameraOff cameraOff) {
        try {
            Method offMethod = cameraPort.getClass().getDeclaredMethod("cameraOff");
            offMethod.invoke(cameraPort);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
