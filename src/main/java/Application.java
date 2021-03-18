import configuration.ZooxSettings;
import core.AmazonZoox;
import core.AmazonZooxChargingAdapter;
import parts.electricKey.ElectricKey;

import java.util.Arrays;


public class Application {


    public static void main(String[] args) {
        if (Arrays.asList(args).contains("-config")) {
            new ZooxSettings();
        }

        AmazonZooxChargingAdapter zoox = buildCar();

        ElectricKey electricKey = new ElectricKey(zoox);
        electricKey.unlockCar();

        //open left door(s) for passenger(s)
        zoox.pressLeftOpenDoorButton();

        // Autonomous drive
        zoox.startup();
        zoox.move(2000, 10);
        zoox.leftTurn(1000, 5);
        zoox.stop();
        zoox.move(3000, 8);
        zoox.rightTurn(3500, 4);
        zoox.emergencyStop();
        zoox.shutdown();

        //open right door(s) for passenger(s)
        zoox.pressRightOpenDoorButton();


        // Charge Zoox
        zoox.pluginTwoPoles();
    }


    private static AmazonZooxChargingAdapter buildCar() {
        AmazonZoox.Builder builder = new AmazonZoox.Builder();
        builder.chassis()
                .electricEngine()
                .ledHeadlights()
                .brakeLights()
                .indicator()
                .benchs()
                .wheels()
                .brakes()
                .doors()
                .gps()
                .camera()
                .lidar()
                .leftOpenDoorButton()
                .rightOpenDoorButton()
                .battery()
                .ultrasonicSensor()
                .build();

        return new AmazonZooxChargingAdapter(builder);
    }
}
