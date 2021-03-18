package parts.door;

public class DoorStateClosed implements IDoorState {

    @Override
    public void getSignal(Door door, OpenDoorButtonSide side) {
        DoorType doorSide = door.getDoorSide();
        if (doorSide.toString().equals(side.toString())) {
            System.out.println("Opening " + doorSide.toString().toLowerCase() + " door");
            door.setDoorState(new DoorStateOpen());
        }
    }
}
