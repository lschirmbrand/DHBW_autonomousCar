package parts.sensors.sonicSensors;

import parts.Obstacle;

import java.util.ArrayList;

public class SonicSensor implements ISonicSensorListener {
    private final ArrayList<ISonicSensorListener> listenerList;

    public SonicSensor() {
        listenerList = new ArrayList<>();
    }

    public void addListener(ISonicSensorListener listener) {
        listenerList.add(listener);
    }

    public void removeListener(ISonicSensorListener listener) {
        listenerList.remove(listener);
    }

    @Override
    public Obstacle scan() {
        for (ISonicSensorListener listener : listenerList) {
            listener.scan();
        }
        return null;
    }
}
