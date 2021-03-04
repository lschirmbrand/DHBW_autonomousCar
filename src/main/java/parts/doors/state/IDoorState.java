package parts.doors.state;

import core.car.AmazonZoox;

public interface IDoorState {
    void changeState(DoorState doorState);

    void setAmazonZoox(AmazonZoox amazonZoox);
}
