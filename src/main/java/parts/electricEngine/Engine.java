package parts.electricEngine;

import com.google.common.eventbus.Subscribe;
import parts.Subscriber;
import parts.battery.BatteryCMS;
import parts.electricEngine.event.DecreaseRPM;
import parts.electricEngine.event.EngineOff;
import parts.electricEngine.event.EngineOn;
import parts.electricEngine.event.IncreaseRPM;

public abstract class Engine extends Subscriber implements IElectricEngine {
    private EngineTypeE engineType;

    public abstract void drainEnergy(BatteryCMS batteryCMS);

    public void setEngineType(EngineTypeE engineType) {
        this.engineType = engineType;
    }

    @Subscribe
    public void receive(EngineOn engineOn) {
        on();
    }

    @Subscribe
    public void receive(EngineOff engineOff) {
        off();
    }

    @Subscribe
    public void receive(IncreaseRPM increaseRPM) {
        increaseRPM(increaseRPM.getDeltaRPM(), increaseRPM.getSeconds());
    }

    @Subscribe
    public void receive(DecreaseRPM decreaseRPM) {
        decreaseRPM(decreaseRPM.getDeltaRPM(), decreaseRPM.getSeconds());
    }

    @Override
    public boolean on() {
        System.out.println("Engine confirmed: On");
        return true;
    }

    @Override
    public boolean off() {
        System.out.println("Engine confirmed: Off");
        return true;
    }

    @Override
    public int increaseRPM(int deltaRPM, int seconds) {
        System.out.println("Engine confirmed: Increased by RPM " + deltaRPM + " for " + seconds + " seconds.");
        return deltaRPM;
    }

    @Override
    public int decreaseRPM(int deltaRPM, int seconds) {
        System.out.println("Engine confirmed: Decreased by RPM " + deltaRPM + " for " + seconds + " seconds.");
        return deltaRPM;
    }
}
