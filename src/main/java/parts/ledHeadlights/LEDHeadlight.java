package parts.ledHeadlights;

import com.google.common.eventbus.Subscribe;
import parts.Subscriber;
import parts.ledHeadlights.events.LEDDimmed;
import parts.ledHeadlights.events.LEDHighBeam;
import parts.ledHeadlights.events.LEDOff;
import parts.ledHeadlights.events.LEDOn;

public class LEDHeadlight extends Subscriber implements ILEDHeadlights {

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
