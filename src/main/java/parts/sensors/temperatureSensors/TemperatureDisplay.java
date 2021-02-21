package parts.sensors.temperatureSensors;

public class TemperatureDisplay implements ISensorTemperatureListener {
    @Override
    public void checkTemperature() {
        System.out.println("Temperature is fine!");
    }
}
