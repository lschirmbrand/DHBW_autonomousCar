package car;

import com.google.common.eventbus.EventBus;
import configuration.Configuration;
import event.Subscriber;
import parts.brake.Brake;
import parts.brakelight.Brakelight;
import parts.doors.Door;
import parts.electricEngine.ElectricEngine;
import parts.gps.GPS;
import parts.indicator.Indicator;
import parts.ledHeadlights.LEDHeadlight;
import parts.uselessParts.Bench;
import parts.uselessParts.Chassis;
import parts.uselessParts.Wheel;

import java.util.ArrayList;

public class AmazonZoox {

    private final ArrayList<Chassis> chassis;
    private final ArrayList<ElectricEngine> electricEngine;
    private final ArrayList<LEDHeadlight> ledHeadlights;
    private final ArrayList<Brakelight> brakelights;
    private final ArrayList<Indicator> indicators;


    private final ArrayList<Door> doors;
    private final ArrayList<Bench> benches;
    private final ArrayList<Wheel> wheels;
    private final ArrayList<Brake> brakes;
    private final ArrayList<GPS> gps;
    private final ArrayList<Object> cameraPorts = new ArrayList<Object>();
    private final ArrayList<Object> lidarPorts = new ArrayList<Object>();

    private final EventBus eventBus;


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
        Brake brake = new Brake();
        addSubscriber(brake);
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

        private final ArrayList<Chassis> chassis = new ArrayList<Chassis>();
        private final ArrayList<ElectricEngine> electricEngines = new ArrayList<ElectricEngine>();
        private final ArrayList<LEDHeadlight> ledHeadlights = new ArrayList<LEDHeadlight>();
        private final ArrayList<Brakelight> brakelights = new ArrayList<Brakelight>();
        private final ArrayList<Indicator> indicators = new ArrayList<Indicator>();
        private final ArrayList<Door> doors = new ArrayList<Door>();
        private final ArrayList<Bench> benches = new ArrayList<Bench>();
        private final ArrayList<Wheel> wheels = new ArrayList<Wheel>();
        private final ArrayList<Brake> brakes = new ArrayList<Brake>();
        private final ArrayList<GPS> gps = new ArrayList<GPS>();
        private final ArrayList<Object> cameraPorts = new ArrayList<Object>();
        private final ArrayList<Object> lidarPorts = new ArrayList<Object>();

        Chassis chassisI = new Chassis();
        ElectricEngine electricEngineI = new ElectricEngine();
        LEDHeadlight ledHeadlightI = new LEDHeadlight();
        Brakelight brakelightI = new Brakelight();
        Indicator indicatorI = new Indicator();
        Door doorI = new Door();
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
            for (int i = 0; i < Configuration.instance.numberOfIndicators; i++) {
                this.indicators.add(indicatorI);
            }

            return this;
        }

        public Builder doors() {
            Door.doorTypeE doorType = Door.doorTypeE.LEFT;
            doorI.setDoorSide(doorType);
            for (int i = 0; i < Configuration.instance.numberOfDoors / 2; i++) {
                this.doors.add(doorI);
            }
            doorType = Door.doorTypeE.RIGHT;
            doorI.setDoorSide(doorType);
            for (int i = 0; i < Configuration.instance.numberOfDoors / 2; i++) {
                this.doors.add(doorI);
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

        //LIDAR

        public AmazonZoox build() {
            return new AmazonZoox(this);
        }
    }
}
