package parts.door;

public class Door implements IOpenDoorButtonObserver {
    private final DoorType doorSide;
    private IDoorState doorState = new DoorStateClosed();

    public Door(DoorType doorSide) {
        this.doorSide = doorSide;
    }

    public void setDoorState(IDoorState doorState) {
        this.doorState = doorState;
    }

    @Override
    public void openDoorButtonPushed(OpenDoorButtonSide side) {
        doorState.getSignal(this, side);
    }

    public DoorType getDoorSide() {
        return doorSide;
    }
}
