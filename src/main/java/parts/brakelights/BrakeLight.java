package parts.brakelights;

import com.google.common.eventbus.Subscribe;
import parts.Subscriber;
import parts.brakelights.event.BrakeLightOff;
import parts.brakelights.event.BrakeLightOn;

public class BrakeLight extends Subscriber implements IBrakeLight {

    private boolean isOn = false;


    @Subscribe
    public void receive(BrakeLightOn brakeLightOn) {
        brakeLightOn();
    }

    @Subscribe
    public void receive(BrakeLightOff brakeLightOff) {
        brakeLightOff();
    }

    @Override
    public boolean brakeLightOn() {
        System.out.println("Brake Light was confirmed: On");
        this.isOn = true;
        return true;
    }

    @Override
    public boolean brakeLightOff() {
        System.out.println("Brake Light was confirmed: Off");
        this.isOn = false;
        return false;
    }
}
