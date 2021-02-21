package parts.sensors.doorSensors;

import parts.doors.Door;

import java.util.ArrayList;

public class DoorButton implements IDoorButtonListener {

    private final ArrayList<IDoorButtonListener> doorButtonList;

    public DoorButton() {
        doorButtonList = new ArrayList<>();
    }

    @Override
    public void openDoor(Door.doorTypeE doorSide) {

    }

    public void addListener(IDoorButtonListener listener) {
        doorButtonList.add(listener);
    }

    public void removeListener(IDoorButtonListener listener) {
        doorButtonList.remove(listener);
    }
}
