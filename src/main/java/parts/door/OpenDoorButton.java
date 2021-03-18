package parts.door;

import java.util.ArrayList;
import java.util.List;

public class OpenDoorButton {
    private final List<IOpenDoorButtonObserver> observerList = new ArrayList<>();

    private final OpenDoorButtonSide side;

    public OpenDoorButton(OpenDoorButtonSide side) {
        this.side = side;
    }

    public void addObserver(IOpenDoorButtonObserver observer) {
        observerList.add(observer);
    }

    public void removeObserver(IOpenDoorButtonObserver observer) {
        observerList.remove(observer);
    }

    public void press() {
        System.out.println("\nButton pressed: " + side.toString().toLowerCase());
        for (IOpenDoorButtonObserver iOpenDoorButtonObserver : observerList) {
            iOpenDoorButtonObserver.openDoorButtonPushed(side);
        }
    }
}
