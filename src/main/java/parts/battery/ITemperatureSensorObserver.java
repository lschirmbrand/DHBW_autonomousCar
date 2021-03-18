package parts.battery;

public interface ITemperatureSensorObserver {
    void temperaturePublished(double temperature);
}