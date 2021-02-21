package command;

import facade.ControlUnit;

public class ActivateCarCommand implements ICommand {
    @Override
    public void execute(String keyCode, ControlUnit controlUnit) {
        ControlUnit.getKeyReceiver().unlockCar(keyCode);
    }
}
