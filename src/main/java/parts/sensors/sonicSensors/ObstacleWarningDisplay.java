package parts.sensors.sonicSensors;

import parts.Obstacle;

public class ObstacleWarningDisplay implements ISonicSensorListener {
    @Override
    public Obstacle scan() {
        if (true) {
            System.out.println("No Obstacles around.");
            return null;
        } else {
            Obstacle obstacle = new Obstacle();
            return obstacle;
        }
    }
}
