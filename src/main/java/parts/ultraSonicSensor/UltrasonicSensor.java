package parts.ultraSonicSensor;

import java.util.ArrayList;
import java.util.List;

public class UltrasonicSensor {
    private final List<IUltrasonicSensorObserver> observerList = new ArrayList<>();

    public void addObserver(IUltrasonicSensorObserver observer) {
        observerList.add(observer);
    }

    public void removeObserver(IUltrasonicSensorObserver observer) {
        observerList.remove(observer);
    }

    public void publishDistance() {
        observerList.forEach(observer -> observer.distancePublished(getMeasurement()));
    }

    private double getMeasurement() {
        return 25 + Math.random() * (60 - 25);
    }
}
