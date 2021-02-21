package parts.sensors.doorSensors;

import parts.doors.Door;

public interface IDoorButtonListener {
    void openDoor(Door.doorTypeE doorSide);
}
