package parts.brakelights;

import com.google.common.eventbus.Subscribe;
import event.brakelight.BrakeLightOff;
import event.brakelight.BrakeLightOn;

public class BrakeLight implements IBrakeLight {

    private boolean isOn = false;


    @Subscribe
    public void receive(BrakeLightOn brakeLightOn){
        brakeLightOn();
    }

    @Subscribe
    public void receive(BrakeLightOff brakeLightOff){
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
