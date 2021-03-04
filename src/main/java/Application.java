import com.google.common.eventbus.EventBus;
import core.ControlUnit;
import core.car.AmazonZoox;
import parts.battery.BatteryPack;
import parts.doors.state.*;
import parts.electricKey.ElectricKey;
import parts.sensors.doorSensors.DoorButton;
import parts.sensors.sonicSensors.ObstacleWarningDisplay;
import parts.sensors.sonicSensors.SonicSensor;
import parts.sensors.temperatureSensors.SensorTemperatureBattery;
import parts.sensors.temperatureSensors.TemperatureDisplay;


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
        DoorLeftOpen doorLeftOpen = new DoorLeftOpen();
        DoorLeftClose doorLeftClose = new DoorLeftClose();


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
                .camera()
                //.lidar()
                .build();


        doorRightOpen.setAmazonZoox(amazonZoox);
        doorRightClose.setAmazonZoox(amazonZoox);
        doorLeftOpen.setAmazonZoox(amazonZoox);
        doorLeftClose.setAmazonZoox(amazonZoox);

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

        //Open right Doors
        doorState.setState(doorRightOpen);
        doorState.changeState();

        //Close right Doors
        doorState.setState(doorRightClose);
        doorState.changeState();

        //Open left Doors
        doorState.setState(doorLeftOpen);
        doorState.changeState();

        //Close left Doors
        doorState.setState(doorLeftClose);
        doorState.changeState();


        //Perform all movement tasks once
        controlUnit.startup();
        controlUnit.move(3000, 15);
        controlUnit.leftTurn(3000, 15);
        controlUnit.move(3500, 15);
        controlUnit.rightTurn(3500, 15);
        controlUnit.move(3000, 15);
        controlUnit.stop();
        controlUnit.emergencyStop();
        controlUnit.shutdown();
    }
}
