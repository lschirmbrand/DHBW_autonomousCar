package parts.electricEngine;

import parts.battery.BatteryCMS;

public class EngineX extends Engine {

    @Override
    public void drainEnergy(BatteryCMS batteryCMS) {
        batteryCMS.drain(4);
    }
}
