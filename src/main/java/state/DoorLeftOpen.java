package state;

import car.AmazonZoox;
import parts.doors.OpenLeftDoors;

public class DoorLeftOpen implements IDoorState {

    private AmazonZoox amazonZoox;

    @Override
    public void changeState(DoorState doorState) {
        OpenLeftDoors openLeftDoors = new OpenLeftDoors();
        openLeftDoors.execute(amazonZoox);
    }

    @Override
    public void setAmazonZoox(AmazonZoox amazonZoox) {
        this.amazonZoox = amazonZoox;
    }
}
