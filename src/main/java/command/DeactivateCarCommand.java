package command;

import facade.ControlUnit;

public class DeactivateCarCommand implements ICommand {
    @Override
    public void execute(String keyCode, ControlUnit controlUnit) {
        ControlUnit.getKeyReceiver().lockCar(keyCode);
    }
}
