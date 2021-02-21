package facade;

import car.AmazonZoox;
import com.google.common.eventbus.EventBus;
import command.ActivateCarCommand;
import command.DeactivateCarCommand;
import configuration.Configuration;
import event.brake.BrakeSet;
import event.brakelight.BrakeLightOff;
import event.brakelight.BrakeLightOn;
import event.camera.CameraOff;
import event.camera.CameraOn;
import event.electricengine.DecreaseRPM;
import event.electricengine.EngineOff;
import event.electricengine.EngineOn;
import event.electricengine.IncreaseRPM;
import event.gps.GPSConnectSatellite;
import event.gps.GPSOff;
import event.gps.GPSOn;
import event.indicator.*;
import event.ledheadlight.LEDDimmed;
import event.ledheadlight.LEDHighBeam;
import event.ledheadlight.LEDOff;
import event.ledheadlight.LEDOn;
import event.lidar.LidarOff;
import event.lidar.LidarOn;
import parts.battery.BatteryCMS;
import parts.electricEngine.ElectricEngine;
import parts.keyReceiver.KeyReceiver;

public class ControlUnit {

    private static final BatteryCMS batteryCMS = new BatteryCMS();
    private static final KeyReceiver keyReceiver = new KeyReceiver();
    private static final boolean carUnlocked = false;
    private static EventBus eventBus;
    private static ElectricEngine.EngineTypeE engineType;
    private static AmazonZoox amazonZoox;
    private static ActivateCarCommand activateCarCommand;
    private static DeactivateCarCommand deactivateCarCommand;

    public static KeyReceiver getKeyReceiver() {
        return keyReceiver;
    }

    public void initialize(AmazonZoox amazonZoox) {
        ControlUnit.amazonZoox = amazonZoox;
        eventBus = new EventBus();
        amazonZoox.buildSubscribers();
        engineType = Configuration.instance.engineType;
        batteryCMS.startUpCMS();
    }

    public boolean checkForLockState() {
        return keyReceiver.getIsLocked() != true;
    }

    public void startup() {
        if (checkForLockState()) {
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
            System.out.println("Car performed: Startup.");

        } else {
            System.out.println("Car has to be unlocked first.");
        }
    }

    public void move(int deltaRPM, int seconds) {
        if (checkForLockState()) {
            eventBus.post(new LeftIndicatorOff());
            eventBus.post(new RightIndicatorOff());
            eventBus.post(new LEDDimmed());
            eventBus.post(new IncreaseRPM(deltaRPM, seconds));
            eventBus.post(new BrakeSet(0));
            eventBus.post(new BrakeLightOff());
            System.out.println("Car performed: Move. With +" + deltaRPM + " RPM for " + seconds + " seconds.");
        }
    }

    public void leftTurn(int deltaRPM, int seconds) {
        if (checkForLockState()) {
            eventBus.post(new LeftIndicatorOn());
            eventBus.post(new DecreaseRPM(deltaRPM, seconds));
            eventBus.post(new BrakeSet(70));
            eventBus.post(new BrakeLightOn());
            System.out.println("Car performed: Left turn. With -" + deltaRPM + " RPM for " + seconds + " seconds.");
        }
    }

    public void rightTurn(int deltaRPM, int seconds) {
        if (checkForLockState()) {
            eventBus.post(new RightIndicatorOn());
            eventBus.post(new DecreaseRPM(deltaRPM, seconds));
            eventBus.post(new BrakeSet(70));
            eventBus.post(new BrakeLightOn());
            System.out.println("Car performed: Right turn. With -" + deltaRPM + " RPM for " + seconds + " seconds.");
        }
    }

    public void stop() {
        if (checkForLockState()) {
            eventBus.post(new BrakeSet(100));
            eventBus.post(new BrakeLightOn());
            System.out.println("Car performed: Stop.");
        }
    }

    public void emergencyStop() {
        if (checkForLockState()) {
            eventBus.post(new BrakeSet(100));
            eventBus.post(new BrakeLightOn());
            eventBus.post(new HazardWarningOn());
            eventBus.post(new EngineOff());
            eventBus.post(new LEDHighBeam());
            eventBus.post(new CameraOff());
            eventBus.post(new LidarOff());
            System.out.println("Car performed: Emergency-Stop. Carefully at getting out!");
        }
    }

    public void shutdown() {
        if (checkForLockState()) {
            eventBus.post(new BrakeSet(100));
            eventBus.post(new EngineOff());
            eventBus.post(new BrakeLightOff());
            eventBus.post(new LEDOff());
            eventBus.post(new HazardWarningOff());
            eventBus.post(new GPSOff());
            eventBus.post(new CameraOff());
            eventBus.post(new LidarOff());
            System.out.println("Car performed: Shutdown.");
        }
    }

    private void manageBatteryConsumption() {
        if (engineType == ElectricEngine.EngineTypeE.ENGINE_NG) {
            batteryCMS.drain(3);
        } else {
            batteryCMS.drain(4);
        }
    }
}
