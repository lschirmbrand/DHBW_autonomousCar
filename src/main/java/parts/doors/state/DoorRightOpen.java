package parts.doors.state;

import core.car.AmazonZoox;
import parts.doors.OpenRightDoors;

public class DoorRightOpen implements IDoorState {

    private AmazonZoox amazonZoox;

    @Override
    public void changeState(DoorState doorState) {
        OpenRightDoors openRightDoors = new OpenRightDoors();
        openRightDoors.execute(amazonZoox);
    }

    public void setAmazonZoox(AmazonZoox amazonZoox) {
        this.amazonZoox = amazonZoox;
    }
}
