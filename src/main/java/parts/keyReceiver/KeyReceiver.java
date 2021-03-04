package parts.keyReceiver;

import parts.electricKey.encoding.AES256;

public class KeyReceiver implements IKeyReceiver {

    private final AES256 aes256 = new AES256();
    private boolean isLocked = true;

    public boolean getIsLocked() {
        return isLocked;
    }

    @Override
    public void unlockCar(String keyCode) {
        if (AES256.decrypt(keyCode).equals("ZooxSDC73")) {
            this.isLocked = false;
            System.out.println("Car was unlocked.");
        }

    }

    @Override
    public void lockCar(String keyCode) {
        if (AES256.decrypt(keyCode).equals("ZooxSDC73")) {
            this.isLocked = true;
            System.out.println("Car was locked.");
        }
    }
}
