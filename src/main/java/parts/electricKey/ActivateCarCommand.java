package parts.electricKey;

import parts.keyReceiver.KeyReceiver;

public class ActivateCarCommand implements ICommand {

    @Override
    public void execute(String encryptedKeyCode, KeyReceiver keyReceiver) {
        keyReceiver.unlockCar(encryptedKeyCode);
    }
}
