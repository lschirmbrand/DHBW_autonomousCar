package parts.electricEngine;

import parts.battery.Battery;

import java.util.List;

public class EngineX extends Engine {


    @Override
    public void drainEnergy(List<Battery> batteries) {
        for (int i = 0; i < 4; i++) {
            batteries.forEach(battery -> {
                if (battery.getEnergy() > 1) {
                    battery.discharge();
                }
            });
        }
    }
}
