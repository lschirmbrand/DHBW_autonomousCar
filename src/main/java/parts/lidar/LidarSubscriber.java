package parts.lidar;

import com.google.common.eventbus.Subscribe;
import parts.Subscriber;
import parts.lidar.events.LidarOff;
import parts.lidar.events.LidarOn;

import java.lang.reflect.Method;

public class LidarSubscriber extends Subscriber {
    private final Object lidarPort;

    public LidarSubscriber(Object lidarPort) {
        this.lidarPort = lidarPort;
    }

    @Subscribe
    public void receive(LidarOn lidarOn) {
        try {
            Method onMethod = lidarPort.getClass().getDeclaredMethod("lidarOn");
            onMethod.invoke(lidarPort);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Subscribe
    public void receive(LidarOff lidarOff) {
        try {
            Method offMethod = lidarPort.getClass().getDeclaredMethod("lidarOff");
            offMethod.invoke(lidarPort);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
