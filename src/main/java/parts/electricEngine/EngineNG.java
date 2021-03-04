package parts.electricEngine;

import parts.battery.BatteryCMS;

public class EngineNG extends Engine {
    @Override
    public void drainEnergy(BatteryCMS batteryCMS) {
        batteryCMS.drain(3);
    }
}
