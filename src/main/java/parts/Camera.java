package parts;

import com.google.common.eventbus.Subscribe;
import configuration.Configuration;
import parts.camera.CameraFactory;
import parts.camera.event.CameraOn;

import java.lang.reflect.Method;
import java.util.ArrayList;

@SuppressWarnings({"UnstableApiUsage", "unused"})
public class Camera extends Subscriber {
    ArrayList<Object> cameraPortList;

    private void initializeCamera() {
        cameraPortList = new ArrayList<>();
        for (int i = 0; i < Configuration.instance.numberOfCameras; i++) {
            cameraPortList.add(new CameraFactory());
        }
    }

    @Subscribe
    public void receive(CameraOn cameraOn) {
        initializeCamera();
        for (int i = 0; i < Configuration.instance.numberOfCameras; i++) {
            try {
                Method startMethod = cameraPortList.get(i).getClass().getDeclaredMethod("cameraOn");
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

    }
}
