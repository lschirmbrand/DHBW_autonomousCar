package parts.electricKey;

import core.ControlUnit;

public interface ICommand {
    void execute(String keyCode, ControlUnit controlUnit);
}
