package parts.door;

public interface IDoorState {
    void getSignal(Door door, OpenDoorButtonSide side);
}
