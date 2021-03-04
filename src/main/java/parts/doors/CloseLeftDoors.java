package parts.doors;

import core.car.AmazonZoox;

import java.util.ArrayList;

public class CloseLeftDoors implements ICommandDoors {
    @Override
    public void execute(AmazonZoox amazonZoox) {
        ArrayList<Door> doors = amazonZoox.getDoors();
        for (Door s : doors) {
            if (s.getDoorSide() == Door.doorTypeE.LEFT) {
                s.closeLeft();
            }
        }
    }
}
