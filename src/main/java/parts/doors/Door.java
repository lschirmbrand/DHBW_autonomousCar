package parts.doors;

import parts.Subscriber;

public class Door extends Subscriber {

    private doorTypeE doorSide;

    public doorTypeE getDoorSide() {
        return doorSide;
    }

    public void setDoorSide(doorTypeE doorSide) {
        this.doorSide = doorSide;
    }

    public void openLeft() {
        if (doorSide == doorTypeE.LEFT) {
            System.out.println("Left door was: Opened");
        }
    }

    public void openRight() {
        if (doorSide == doorTypeE.RIGHT) {
            System.out.println("Right door was: Opened");
        }
    }

    public void closeRight() {
        if (doorSide == doorTypeE.RIGHT) {
            System.out.println("Right door was: Closed");
        }
    }

    public void closeLeft() {
        if (doorSide == doorTypeE.LEFT) {
            System.out.println("Left door was: Closed");
        }
    }

    public enum doorTypeE {
        LEFT, RIGHT
    }
}
