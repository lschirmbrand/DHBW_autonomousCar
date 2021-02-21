package parts.sensors.temperatureSensors;

import java.util.ArrayList;

public class SensorTemperatureBattery implements ISensorTemperatureListener {

    private final ArrayList<ISensorTemperatureListener> listenerList;

    public SensorTemperatureBattery() {
        listenerList = new ArrayList<>();
    }

    public void addListener(ISensorTemperatureListener listener) {
        listenerList.add(listener);
    }

    public void removeListener(ISensorTemperatureListener listener) {
        listenerList.remove(listener);
    }

    @Override
    public void checkTemperature() {
        for (ISensorTemperatureListener listener : listenerList) {
            listener.checkTemperature();
        }
    }
}
