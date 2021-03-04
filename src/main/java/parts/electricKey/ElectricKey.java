package parts.electricKey;

import core.ControlUnit;
import parts.electricKey.encoding.AES256;

public class ElectricKey implements IElectricKey {

    private final String keyCode = "ZooxSDC73";
    private final AES256 aES256 = new AES256();
    ActivateCarCommand activateCarCommand = new ActivateCarCommand();
    DeactivateCarCommand deactivateCarCommand = new DeactivateCarCommand();
    private ControlUnit controlUnit;

    public void pairKeyWithCar(ControlUnit controlUnit) {
        this.controlUnit = controlUnit;
    }

    public void lockCar() {
        String encodedKey = AES256.encrypt(keyCode);
        this.deactivateCarCommand.execute(encodedKey, controlUnit);
    }

    public void unlockCar() {
        String encodedKey = AES256.encrypt(keyCode);
        this.activateCarCommand.execute(encodedKey, controlUnit);
    }
}
