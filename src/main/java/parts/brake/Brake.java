package parts.brake;

import com.google.common.eventbus.Subscribe;
import parts.Subscriber;
import parts.brake.event.BrakeSet;

@SuppressWarnings({"UnstableApiUsage", "FieldCanBeLocal"})
public class Brake extends Subscriber implements IBrake {

    private double brakePercentage;

    @Subscribe
    public void receive(BrakeSet brakeSet) {
        this.brakePercentage = brakeSet.getValue();
        System.out.println("Brake confirmed:  Set to: " + this.brakePercentage + "%.");
    }
}
