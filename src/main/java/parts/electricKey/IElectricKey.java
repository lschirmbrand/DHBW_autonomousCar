package parts.electricKey;

import core.ControlUnit;

public interface IElectricKey {
    void pairKeyWithCar(ControlUnit controlUnit);

    void unlockCar();

    void lockCar();
}
