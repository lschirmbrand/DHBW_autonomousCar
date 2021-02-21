package parts.electricKey;

import facade.ControlUnit;

public interface IElectricKey {
    void pairKeyWithCar(ControlUnit controlUnit);

    void unlockCar();

    void lockCar();
}
