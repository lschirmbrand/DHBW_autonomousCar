import car.AmazonZoox;
import com.google.common.eventbus.EventBus;
import event.brake.BrakeSet;
import facade.ControlUnit;
import parts.battery.BatteryCMS;
import parts.battery.BatteryPack;


public class Application {

    private static EventBus eventBus;
    private static ControlUnit controlUnit;

    public static void main(String[] args) {

        AmazonZoox amazonZoox = new AmazonZoox.Builder()
                .chassis()
                .electricEngine()
                .ledHeadlights()
                .brakeLights()
                .indicator()
                .doors()
                .benchs()
                .wheels()
                .brakes()
                .gps()
                .build();

        System.out.println(amazonZoox.toString());
        controlUnit = new ControlUnit();

        BatteryPack battery = new BatteryPack();

        controlUnit.initialize(amazonZoox);
        controlUnit.startup();
        int i = 0;

    }
}
