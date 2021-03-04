package parts.camera;

import com.google.common.eventbus.Subscribe;
import parts.camera.event.*;

import java.lang.reflect.Method;

public class CameraSubscriber {

    private Object cameraPort;

    public CameraSubscriber(Object cameraPort) {
        this.cameraPort = cameraPort;
    }

    @Subscribe
    public void receive(CameraOn cameraOn){
        try{
            Method onMethod = cameraPort.getClass().getDeclaredMethod("on");
            onMethod.invoke(cameraPort);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(CameraOff cameraOff){
        try{
            Method offMethod = cameraPort.getClass().getDeclaredMethod("off");
            offMethod.invoke(cameraPort);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
