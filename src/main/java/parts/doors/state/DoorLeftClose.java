package parts.doors.state;

import core.car.AmazonZoox;
import parts.doors.CloseLeftDoors;

public class DoorLeftClose implements IDoorState {

    private AmazonZoox amazonZoox;

    @Override
    public void changeState(DoorState doorState) {
        CloseLeftDoors closeLeftDoors = new CloseLeftDoors();
        closeLeftDoors.execute(amazonZoox);
    }

    @Override
    public void setAmazonZoox(AmazonZoox amazonZoox) {
        this.amazonZoox = amazonZoox;
    }
}
