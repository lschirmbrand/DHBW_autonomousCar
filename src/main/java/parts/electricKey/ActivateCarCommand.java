package parts.electricKey;

import core.ControlUnit;

public class ActivateCarCommand implements ICommand {
    @Override
    public void execute(String keyCode, ControlUnit controlUnit) {
        ControlUnit.getKeyReceiver().unlockCar(keyCode);
    }
}
