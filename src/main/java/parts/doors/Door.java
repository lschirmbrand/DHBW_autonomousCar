package parts.doors;

public class Door {

    private doorTypeE doorSide;

    public doorTypeE getDoorSide() {
        return doorSide;
    }

    public void setDoorSide(doorTypeE doorSide) {
        this.doorSide = doorSide;
    }

    public void openLeft() {
        System.out.println("Left door was: Opened");
    }

    public void openRight() {
        System.out.println("Right door was: Opened");
    }

    public void closeRight() {
        System.out.println("Right door was: Closed");
    }

    public void closeLeft() {
        System.out.println("Left door was: Closed");
    }

    public enum doorTypeE {
        LEFT, RIGHT
    }
}
