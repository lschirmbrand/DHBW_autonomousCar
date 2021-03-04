package parts.lidar;

import com.google.common.eventbus.Subscribe;
import parts.lidar.events.*;

import java.lang.reflect.Method;

public class LidarSubscriber {
    private Object lidarPort;

    public LidarSubscriber(Object lidarPort) {
        this.lidarPort = lidarPort;
    }

    @Subscribe
    public void receive(LidarOn lidarOn){
        try{
            Method onMethod = lidarPort.getClass().getDeclaredMethod("on");
            onMethod.invoke(lidarPort);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(LidarOff lidarOff){
        try{
            Method offMethod = lidarPort.getClass().getDeclaredMethod("off");
            offMethod.invoke(lidarPort);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
