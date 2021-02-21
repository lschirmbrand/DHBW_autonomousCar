package parts.ledHeadlights;

import com.google.common.eventbus.Subscribe;
import event.ledheadlight.LEDDimmed;
import event.ledheadlight.LEDHighBeam;
import event.ledheadlight.LEDOff;
import event.ledheadlight.LEDOn;

public class LEDHeadlight implements ILEDHeadlights {

    @Subscribe
    public void receive(LEDOn lEDOn) {
        on();
    }

    @Subscribe
    public void receive(LEDOff ledOff) {
        off();
    }

    @Subscribe
    public void receive(LEDDimmed lEDDimmed) {
        dimmed();
    }

    @Subscribe
    public void receive(LEDHighBeam ledHighBeam) {
        highBeam();
    }

    @Override
    public boolean on() {
        System.out.println("LED Headlights confirmed: On");
        return true;
    }

    @Override
    public boolean off() {
        System.out.println("LED Headlights confirmed: Off");
        return true;
    }

    @Override
    public boolean dimmed() {
        System.out.println("LED Headlights confirmed: Dimmed");
        return true;
    }

    @Override
    public boolean highBeam() {
        System.out.println("LED Headlights confirmed: High Beam");
        return true;
    }
}
