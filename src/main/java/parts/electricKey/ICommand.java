package parts.electricKey;

import parts.keyReceiver.KeyReceiver;

public interface ICommand {
    void execute(String keyCode, KeyReceiver keyReceiver);
}
