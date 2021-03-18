package parts.electricKey;

import parts.keyReceiver.KeyReceiver;

public class DeactivateCarCommand implements ICommand {

    @Override
    public void execute(String encryptedKeyCode, KeyReceiver keyReceiver) {
        keyReceiver.lockCar(encryptedKeyCode);
    }
}
