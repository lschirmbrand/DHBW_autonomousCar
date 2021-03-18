package parts.battery;

import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor {
    private final List<ITemperatureSensorObserver> observerList = new ArrayList<>();

    public void addObserver(ITemperatureSensorObserver observer) {
        observerList.add(observer);
    }

    public void removeObserver(ITemperatureSensorObserver observer) {
        observerList.remove(observer);
    }

    public void publishTemperature() {
        observerList.forEach(observer -> observer.temperaturePublished(getMeasurement()));
    }

    private double getMeasurement() {
        return 25 + Math.random() * (60 - 25);
    }
}