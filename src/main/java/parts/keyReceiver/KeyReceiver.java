package parts.keyReceiver;

import configuration.Configuration;
import parts.electricKey.encoding.AES256;

import java.util.Objects;

public class KeyReceiver implements IKeyReceiver {

    private boolean isLocked = true;

    public boolean getIsLocked() {
        return isLocked;
    }

    @Override
    public void unlockCar(String encryptedKeyCode) {
        if (Objects.equals(AES256.decrypt(encryptedKeyCode), Configuration.instance.keyCode)) {
            this.isLocked = false;
            System.out.println("Car was unlocked.");
        }

    }

    @Override
    public void lockCar(String encryptedKeyCode) {
        if (Objects.equals(AES256.decrypt(encryptedKeyCode), Configuration.instance.keyCode)) {
            this.isLocked = true;
            System.out.println("Car was locked.");
        }
    }
}
