package parts.electricKey;

import configuration.Configuration;
import core.AmazonZoox;
import core.ControlUnit;
import parts.electricKey.encoding.AES256;
import parts.keyReceiver.KeyReceiver;

public class ElectricKey implements IElectricKey {
    String keyCode;
    AmazonZoox zoox;
    KeyReceiver keyReceiver;
    ActivateCarCommand activateCarCommand = new ActivateCarCommand();
    DeactivateCarCommand deactivateCarCommand = new DeactivateCarCommand();
    private final ControlUnit controlUnit;

    public ElectricKey(AmazonZoox zoox) {
        this.controlUnit = zoox.getControlUnit();
        this.zoox = zoox;
        this.keyCode = Configuration.instance.keyCode;
        this.keyReceiver = ControlUnit.getKeyReceiver();
    }

    @Override
    public void lockCar() {
        String encodedKey = AES256.encrypt(keyCode);
        this.deactivateCarCommand.execute(encodedKey, keyReceiver);
    }

    @Override
    public void unlockCar() {
        String encodedKey = AES256.encrypt(keyCode);
        this.activateCarCommand.execute(encodedKey, keyReceiver);
    }
}
