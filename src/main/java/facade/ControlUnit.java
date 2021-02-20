package facade;

import car.AmazonZoox;
import com.google.common.eventbus.EventBus;
import configuration.Configuration;
import event.brake.*;
import event.brakelight.*;
import event.camera.*;
import event.electricengine.*;
import event.gps.*;
import event.indicator.*;
import event.ledheadlight.*;
import event.lidar.*;
import parts.battery.*;
import parts.electricEngine.ElectricEngine;

public class ControlUnit {

    private static EventBus eventBus;
    private static ElectricEngine.EngineTypeE engineType;
    private static final BatteryCMS batteryCMS = new BatteryCMS();

    public void initialize(AmazonZoox amazonZoox) {
        eventBus = new EventBus();
        amazonZoox.buildSubscribers();
        engineType = Configuration.instance.engineType;
        batteryCMS.startUpCMS();
    }

    public void startup() {
        eventBus.post(new EngineOn());
        eventBus.post(new LEDOn());
        eventBus.post(new GPSOn());
        eventBus.post(new GPSConnectSatellite("118,75"));
        eventBus.post(new CameraOn());
        eventBus.post(new LidarOn());
        eventBus.post(new LeftIndicatorOn());
        manageBatteryConsumption();
    }

    public void move(int deltaRPM, int seconds) {
        eventBus.post(new LeftIndicatorOff());
        eventBus.post(new RightIndicatorOff());
        eventBus.post(new LEDDimmed());
        eventBus.post(new IncreaseRPM(deltaRPM, seconds));
        eventBus.post(new BrakeSet(0));
        eventBus.post(new BrakeLightOff());
    }

    public void leftTurn(int deltaRPM, int seconds) {
        eventBus.post(new LeftIndicatorOn());
        eventBus.post(new DecreaseRPM(deltaRPM, seconds));
        eventBus.post(new BrakeSet(70));
        eventBus.post(new BrakeLightOn());
    }

    public void rightTurn(int deltaRPM, int seconds) {
        eventBus.post(new RightIndicatorOn());
        eventBus.post(new DecreaseRPM(deltaRPM, seconds));
        eventBus.post(new BrakeSet(70));
        eventBus.post(new BrakeLightOn());
    }

    public void stop() {
        eventBus.post(new BrakeSet(100));
        eventBus.post(new BrakeLightOn());
    }

    public void emergencyStop() {
        eventBus.post(new BrakeSet(100));
        eventBus.post(new BrakeLightOn());
        eventBus.post(new HazardWarningOn());
        eventBus.post(new EngineOff());
        eventBus.post(new LEDHighBeam());
        eventBus.post(new CameraOff());
        eventBus.post(new LidarOff());
    }

    public void shutdown() {
        eventBus.post(new BrakeSet(100));
        eventBus.post(new EngineOff());
        eventBus.post(new BrakeLightOff());
        eventBus.post(new LEDOff());
        eventBus.post(new HazardWarningOff());
        eventBus.post(new GPSOff());
        eventBus.post(new CameraOff());
        eventBus.post(new LidarOff());
    }

    private void manageBatteryConsumption() {
        if (engineType == ElectricEngine.EngineTypeE.ENGINE_NG) {
            batteryCMS.dischargeBattery(3);
        } else {
            batteryCMS.dischargeBattery(4);
        }
    }
}
