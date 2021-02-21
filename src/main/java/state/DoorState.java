package state;

public class DoorState {

    private IDoorState state;

    public IDoorState getState() {
        return state;
    }

    public void setState(IDoorState state) {
        this.state = state;
    }

    public void changeState() {
        state.changeState(this);
    }
}
