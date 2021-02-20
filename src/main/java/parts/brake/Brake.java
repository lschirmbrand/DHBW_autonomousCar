package parts.brake;

import com.google.common.eventbus.Subscribe;
import event.Subscriber;
import event.brake.*;

public class Brake extends Subscriber implements IBrake{

    @Subscribe
    public void receive(BrakeSet brakeSet){
        brakeSet(brakeSet);
    }

    @Override
    public boolean brakeSet(BrakeSet brakeSet) {
        System.out.println("Brake confirmed:  Set to : " + brakeSet.getValue());
        return false;
    }
}
