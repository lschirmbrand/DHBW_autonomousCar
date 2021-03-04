package parts.doors.state;

import core.car.AmazonZoox;
import parts.doors.CloseRightDoors;

public class DoorRightClose implements IDoorState {

    private AmazonZoox amazonZoox;

    @Override
    public void changeState(DoorState doorState) {
        CloseRightDoors closeRightDoors = new CloseRightDoors();
        closeRightDoors.execute(amazonZoox);
    }

    @Override
    public void setAmazonZoox(AmazonZoox amazonZoox) {
        this.amazonZoox = amazonZoox;
    }
}
