package core.car;

import com.google.common.eventbus.EventBus;
import configuration.Configuration;
import parts.Subscriber;
import parts.brake.Brake;
import parts.brakelights.BrakeLight;
import parts.camera.CameraFactory;
import parts.doors.Door;
import parts.electricEngine.Engine;
import parts.electricEngine.EngineNG;
import parts.electricEngine.EngineTypeE;
import parts.electricEngine.EngineX;
import parts.gps.GPS;
import parts.indicator.Indicator;
import parts.indicator.IndicatorSide;
import parts.ledHeadlights.LEDHeadlight;
import parts.lidar.LidarFactory;
import parts.uselessParts.Bench;
import parts.uselessParts.Chassis;
import parts.uselessParts.Wheel;

import java.util.ArrayList;

public class AmazonZoox {

    private final ArrayList<Chassis> chassis;
    private final ArrayList<Engine> electricEngine;
    private final ArrayList<LEDHeadlight> ledHeadlights;
    private final ArrayList<BrakeLight> brakelights;
    private final ArrayList<Indicator> indicators;
    private final ArrayList<Door> doors;
    private final ArrayList<Bench> benches;
    private final ArrayList<Wheel> wheels;
    private final ArrayList<Brake> brakes;
    private final ArrayList<GPS> gps;
    private final ArrayList<Object> cameraPorts = new ArrayList<Object>();
    private final ArrayList<Object> lidarPorts = new ArrayList<Object>();

    private final EventBus eventBus;

    @SuppressWarnings({"UnstableApiUsage", "FieldCanBeLocal"})
    private AmazonZoox(Builder builder) {
        chassis = builder.chassis;
        electricEngine = builder.electricEngines;
        ledHeadlights = builder.ledHeadlights;
        brakelights = builder.brakelights;
        indicators = builder.indicators;
        doors = builder.doors;
        benches = builder.benches;
        wheels = builder.wheels;
        brakes = builder.brakes;
        gps = builder.gps;

        eventBus = new EventBus("Zoox#1");


    }


    public void addSubscriber(Subscriber subscriber) {
        eventBus.register(subscriber);
    }

    public void buildSubscribers() {
        for (Engine s : electricEngine) {
            addSubscriber(s);
        }
        for (LEDHeadlight s : ledHeadlights) {
            addSubscriber(s);
        }
        for (BrakeLight s : brakelights) {
            addSubscriber(s);
        }
        for (Indicator s : indicators) {
            addSubscriber(s);
        }
        for (Brake s : brakes) {
            addSubscriber(s);
        }
        for (GPS s : gps) {
            addSubscriber(s);
        }
        for(Object s : cameraPorts){
            //addSubscriber();
        }
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nThe Car is build of: \n");
        stringBuilder.append("• ").append(Configuration.instance.numberOfChassis).append(" Chassis \n");
        stringBuilder.append("• ").append(Configuration.instance.numberOfElectricEngines).append(" Electric Engines \n");
        stringBuilder.append("• ").append(Configuration.instance.numberOfLedHeadlights).append(" LED Headlights\n");
        stringBuilder.append("• ").append(Configuration.instance.numberOfBrakeLights).append(" Brakelights\n");
        stringBuilder.append("• ").append(Configuration.instance.numberOfIndicators).append(" Indicators\n");
        stringBuilder.append("• ").append(Configuration.instance.numberOfDoors).append(" Doors\n");
        stringBuilder.append("• ").append(Configuration.instance.numberOfBenchs).append(" Benches\n");
        stringBuilder.append("• ").append(Configuration.instance.numberOfWheels).append(" Wheels\n");
        stringBuilder.append("• ").append(Configuration.instance.numberOfBrakes).append(" Brakes\n");
        stringBuilder.append("• ").append(Configuration.instance.numberOfGPS).append(" GPS\n");
        return stringBuilder.toString();
    }

    public ArrayList<Door> getDoors() {
        return doors;
    }

    public static class Builder {

        private final ArrayList<Chassis> chassis = new ArrayList<>();
        private final ArrayList<Engine> electricEngines = new ArrayList<>();
        private final ArrayList<LEDHeadlight> ledHeadlights = new ArrayList<>();
        private final ArrayList<BrakeLight> brakelights = new ArrayList<>();
        private final ArrayList<Indicator> indicators = new ArrayList<>();
        private final ArrayList<Door> doors = new ArrayList<>();
        private final ArrayList<Bench> benches = new ArrayList<>();
        private final ArrayList<Wheel> wheels = new ArrayList<>();
        private final ArrayList<Brake> brakes = new ArrayList<>();
        private final ArrayList<GPS> gps = new ArrayList<>();
        private final ArrayList<Object> cameraPorts = new ArrayList<>();
        private final ArrayList<Object> lidarPorts = new ArrayList<>();

        Chassis chassisI = new Chassis();
        Engine electricEngineI;
        LEDHeadlight ledHeadlightI = new LEDHeadlight();
        BrakeLight brakelightI = new BrakeLight();
        Bench benchI = new Bench();
        Wheel wheelI = new Wheel();
        Brake brakeI = new Brake();
        GPS gpsI = new GPS();

        public Builder chassis() {
            for (int i = 0; i < Configuration.instance.numberOfChassis; i++) {
                this.chassis.add(chassisI);
            }
            return this;
        }

        public Builder electricEngine() {
            if (Configuration.instance.engineType == EngineTypeE.ENGINE_NG) {
                electricEngineI = new EngineNG();
            } else {
                electricEngineI = new EngineX();
            }

            for (int i = 0; i < Configuration.instance.numberOfElectricEngines; i++) {
                electricEngineI.setEngineType(Configuration.instance.engineType);
                this.electricEngines.add(electricEngineI);
            }

            return this;
        }

        public Builder ledHeadlights() {
            for (int i = 0; i < Configuration.instance.numberOfLedHeadlights; i++) {
                this.ledHeadlights.add(ledHeadlightI);
            }

            return this;
        }

        public Builder brakeLights() {
            for (int i = 0; i < Configuration.instance.numberOfBrakeLights; i++) {
                this.brakelights.add(brakelightI);
            }

            return this;
        }

        public Builder indicator() {
            for (int i = 0; i < Configuration.instance.numberOfIndicators / 2; i++) {
                Indicator indicatorl = new Indicator();
                indicatorl.setSide(IndicatorSide.LEFT);
                this.indicators.add(indicatorl);
            }

            for (int i = 0; i < Configuration.instance.numberOfIndicators / 2; i++) {
                Indicator indicatorr = new Indicator();
                indicatorr.setSide(IndicatorSide.RIGHT);
                this.indicators.add(indicatorr);
            }

            return this;
        }

        public Builder doors() {
            for (int i = 0; i < Configuration.instance.numberOfDoors / 2; i++) {
                Door doorl = new Door();
                doorl.setDoorSide(Door.doorTypeE.LEFT);
                this.doors.add(doorl);
            }
            for (int i = 0; i < Configuration.instance.numberOfDoors / 2; i++) {
                Door doorR = new Door();
                doorR.setDoorSide(Door.doorTypeE.RIGHT);
                this.doors.add(doorR);
            }
            return this;
        }

        public Builder benchs() {
            for (int i = 0; i < Configuration.instance.numberOfBenchs; i++) {
                this.benches.add(benchI);
            }

            return this;
        }

        public Builder wheels() {
            for (int i = 0; i < Configuration.instance.numberOfWheels; i++) {
                this.wheels.add(wheelI);
            }

            return this;
        }

        public Builder brakes() {
            for (int i = 0; i < Configuration.instance.numberOfBrakes; i++) {
                this.brakes.add(brakeI);
            }

            return this;
        }

        public Builder gps() {
            for (int i = 0; i < Configuration.instance.numberOfGPS; i++) {
                this.gps.add(gpsI);
            }

            return this;
        }

        //CAMERA

        public Builder camera() {
            for (int i = 0; i < Configuration.instance.numberOfCameras; i++) {
                cameraPorts.add(CameraFactory.build());
            }
            return this;
        }

        //LIDAR

        public Builder lidar() {
            for (int i = 0; i < Configuration.instance.numberOfLidars; i++) {
                lidarPorts.add(LidarFactory.build());
            }
            return this;
        }

        public AmazonZoox build() {
            return new AmazonZoox(this);
        }
    }
}
