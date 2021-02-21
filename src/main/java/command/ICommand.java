package command;

import facade.ControlUnit;

public interface ICommand {
    void execute(String keyCode, ControlUnit controlUnit);
}
