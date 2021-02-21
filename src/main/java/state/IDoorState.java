package state;

import car.AmazonZoox;

public interface IDoorState {
    void changeState(DoorState doorState);

    void setAmazonZoox(AmazonZoox amazonZoox);
}
