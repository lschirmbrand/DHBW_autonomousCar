package core;

import com.google.common.eventbus.EventBus;
import configuration.Configuration;
import core.car.AmazonZoox;
import parts.battery.BatteryCMS;
import parts.brake.event.BrakeSet;
import parts.brakelights.event.BrakeLightOff;
import parts.brakelights.event.BrakeLightOn;
import parts.camera.event.CameraOff;
import parts.camera.event.CameraOn;
import parts.electricEngine.EngineTypeE;
import parts.electricEngine.event.DecreaseRPM;
import parts.electricEngine.event.EngineOff;
import parts.electricEngine.event.EngineOn;
import parts.electricEngine.event.IncreaseRPM;
import parts.electricKey.ActivateCarCommand;
import parts.electricKey.DeactivateCarCommand;
import parts.gps.events.GPSConnectSatellite;
import parts.gps.events.GPSOff;
import parts.gps.events.GPSOn;
import parts.indicator.events.*;
import parts.keyReceiver.KeyReceiver;
import parts.ledHeadlights.events.LEDDimmed;
import parts.ledHeadlights.events.LEDHighBeam;
import parts.ledHeadlights.events.LEDOff;
import parts.ledHeadlights.events.LEDOn;
import parts.lidar.events.LidarOff;
import parts.lidar.events.LidarOn;

@SuppressWarnings({"UnstableApiUsage", "FieldCanBeLocal"})
public class ControlUnit {

    private static final KeyReceiver keyReceiver = new KeyReceiver();
    private static EventBus eventBus;
    private static EngineTypeE engineType;
    private static AmazonZoox amazonZoox;
    private static ActivateCarCommand activateCarCommand;
    private static DeactivateCarCommand deactivateCarCommand;
    private final BatteryCMS batteryCMS = new BatteryCMS();

    public static KeyReceiver getKeyReceiver() {
        return keyReceiver;
    }


    public void initialize(AmazonZoox amazonZoox) {
        ControlUnit.amazonZoox = amazonZoox;
        eventBus = amazonZoox.getEventBus();
        amazonZoox.buildSubscribers();
        engineType = Configuration.instance.engineType;
        batteryCMS.startUpCMS();
    }

    public boolean checkForLockState() {
        return !keyReceiver.getIsLocked();
    }

    public void startup() {
        if (checkForLockState()) {
            System.out.println("\nCar now performs: Startup.\n");
            eventBus.post(new EngineOn());
            manageBatteryConsumption();
            eventBus.post(new LEDOn());
            manageBatteryConsumption();
            eventBus.post(new GPSOn());
            manageBatteryConsumption();
            eventBus.post(new GPSConnectSatellite("118,75"));
            manageBatteryConsumption();
            eventBus.post(new CameraOn());
            manageBatteryConsumption();
            eventBus.post(new LidarOn());
            manageBatteryConsumption();
            eventBus.post(new LeftIndicatorOn());
            manageBatteryConsumption();

        } else {
            System.out.println("Car has to be unlocked first.");
        }
    }

    public void move(int deltaRPM, int seconds) {
        if (checkForLockState()) {
            System.out.println("\nCar now performs: Move. With +" + deltaRPM + " RPM for " + seconds + " seconds.\n");
            eventBus.post(new LeftIndicatorOff());
            eventBus.post(new RightIndicatorOff());
            eventBus.post(new LEDDimmed());
            eventBus.post(new IncreaseRPM(deltaRPM, seconds));
            eventBus.post(new BrakeSet(0));
            eventBus.post(new BrakeLightOff());
        }
    }

    public void leftTurn(int deltaRPM, int seconds) {
        if (checkForLockState()) {
            System.out.println("\nCar now performs: Left turn. With -" + deltaRPM + " RPM for " + seconds + " seconds.\n");
            eventBus.post(new LeftIndicatorOn());
            eventBus.post(new DecreaseRPM(deltaRPM, seconds));
            eventBus.post(new BrakeSet(70));
            eventBus.post(new BrakeLightOn());
        }
    }

    public void rightTurn(int deltaRPM, int seconds) {
        if (checkForLockState()) {
            System.out.println("\nCar now performs: Right turn. With -" + deltaRPM + " RPM for " + seconds + " seconds.\n");
            eventBus.post(new RightIndicatorOn());
            eventBus.post(new DecreaseRPM(deltaRPM, seconds));
            eventBus.post(new BrakeSet(70));
            eventBus.post(new BrakeLightOn());
        }
    }

    public void stop() {
        if (checkForLockState()) {
            System.out.println("\nCar now performs: Stop.\n");
            eventBus.post(new BrakeSet(100));
            eventBus.post(new BrakeLightOn());
        }
    }

    public void emergencyStop() {
        if (checkForLockState()) {
            System.out.println("\nCar now performs: Emergency-Stop. Carefully at getting out!\n");
            eventBus.post(new BrakeSet(100));
            eventBus.post(new BrakeLightOn());
            eventBus.post(new HazardWarningOn());
            eventBus.post(new EngineOff());
            eventBus.post(new LEDHighBeam());
            eventBus.post(new CameraOff());
            eventBus.post(new LidarOff());
        }
    }

    public void shutdown() {
        if (checkForLockState()) {
            System.out.println("\nCar now performs: Shutdown.\n");
            eventBus.post(new BrakeSet(100));
            eventBus.post(new EngineOff());
            eventBus.post(new BrakeLightOff());
            eventBus.post(new LEDOff());
            eventBus.post(new HazardWarningOff());
            eventBus.post(new GPSOff());
            eventBus.post(new CameraOff());
            eventBus.post(new LidarOff());
        }
    }

    private void manageBatteryConsumption() {
        if (engineType == EngineTypeE.ENGINE_NG) {
            batteryCMS.drain(3);
        } else {
            batteryCMS.drain(4);
        }
    }
}
