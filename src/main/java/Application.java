import car.AmazonZoox;
import com.google.common.eventbus.EventBus;
import facade.ControlUnit;
import parts.battery.BatteryPack;
import parts.electricKey.ElectricKey;
import parts.sensors.doorSensors.DoorButton;
import parts.sensors.sonicSensors.ObstacleWarningDisplay;
import parts.sensors.sonicSensors.SonicSensor;
import parts.sensors.temperatureSensors.SensorTemperatureBattery;
import parts.sensors.temperatureSensors.TemperatureDisplay;
import state.DoorRightClose;
import state.DoorRightOpen;
import state.DoorState;


public class Application {

    private static final BatteryPack battery = new BatteryPack();
    private static EventBus eventBus;
    private static DoorButton doorButton;

    public static void main(String[] args) {

        SonicSensor sonicSensor = new SonicSensor();
        ObstacleWarningDisplay obstacleWarningDisplay = new ObstacleWarningDisplay();
        sonicSensor.addListener(obstacleWarningDisplay);
        TemperatureDisplay temperatureDisplay = new TemperatureDisplay();
        SensorTemperatureBattery sensorTemperatureBattery = new SensorTemperatureBattery();
        sensorTemperatureBattery.addListener(temperatureDisplay);
        ControlUnit controlUnit = new ControlUnit();
        ElectricKey electricKey = new ElectricKey();
        DoorState doorState = new DoorState();
        DoorRightOpen doorRightOpen = new DoorRightOpen();
        DoorRightClose doorRightClose = new DoorRightClose();


        //Initialize the Car with the Builder
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


        doorRightOpen.setAmazonZoox(amazonZoox);
        doorRightClose.setAmazonZoox(amazonZoox);

        //ZooxSettings zooxSettings = new ZooxSettings();

        //Print Components of Car
        System.out.println(amazonZoox.toString());

        controlUnit.initialize(amazonZoox);
        electricKey.pairKeyWithCar(controlUnit);

        //Car gets unlocked with the electric Key
        electricKey.unlockCar();

        //Check Surrounding
        sonicSensor.scan();

        //Check Temperature of Battery
        sensorTemperatureBattery.checkTemperature();

        //Open right Door
        doorState.setState(doorRightOpen);
        doorState.changeState();

        //Close right Door
        doorState.setState(doorRightClose);
        doorState.changeState();

        //Perform all movement tasks once
        controlUnit.startup();
        controlUnit.move(3000, 15);
        controlUnit.leftTurn(3000, 15);
        controlUnit.move(3500, 15);
        controlUnit.rightTurn(3000, 15);
        controlUnit.stop();
        controlUnit.emergencyStop();
        controlUnit.shutdown();
    }
}
