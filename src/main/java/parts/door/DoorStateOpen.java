package parts.door;

public class DoorStateOpen implements IDoorState {
    @Override
    public void getSignal(Door door, OpenDoorButtonSide side) {
        DoorType doorSide = door.getDoorSide();
        if (doorSide.toString().equals(side.toString())) {
            System.out.println("Closing " + doorSide.toString().toLowerCase() + " door");
            door.setDoorState(new DoorStateClosed());
        }
    }
}
