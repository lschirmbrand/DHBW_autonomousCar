package core;

import configuration.Configuration;
import parts.battery.Battery;
import parts.brake.Brake;
import parts.brakelights.BrakeLight;
import parts.camera.CameraFactory;
import parts.camera.CameraSubscriber;
import parts.door.Door;
import parts.door.DoorType;
import parts.door.OpenDoorButton;
import parts.door.OpenDoorButtonSide;
import parts.electricEngine.Engine;
import parts.electricEngine.EngineNG;
import parts.electricEngine.EngineX;
import parts.gps.GPS;
import parts.indicator.Indicator;
import parts.indicator.IndicatorSide;
import parts.ledHeadlights.LEDHeadlight;
import parts.lidar.LidarFactory;
import parts.lidar.LidarSubscriber;
import parts.ultraSonicSensor.UltrasonicSensor;
import parts.uselessParts.Bench;
import parts.uselessParts.Chassis;
import parts.uselessParts.Wheel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class AmazonZoox implements IAutonomousDrive {

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
    private final ArrayList<Object> cameraPorts;
    private final ArrayList<Object> lidarPorts;
    private final OpenDoorButton leftOpenDoorButton;
    private final OpenDoorButton rightOpenDoorButton;
    private final List<Battery> batteries = new ArrayList<>();
    private final List<UltrasonicSensor> ultrasonicSensors;

    private final ControlUnit controlUnit;

    @SuppressWarnings({"UnstableApiUsage", "FieldCanBeLocal"})
    protected AmazonZoox(Builder builder) {
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
        cameraPorts = builder.cameraPorts;
        lidarPorts = builder.lidarPorts;
        leftOpenDoorButton = builder.leftOpenDoorButton;
        rightOpenDoorButton = builder.rightOpenDoorButton;
        ultrasonicSensors = builder.ultrasonicSensors;

        controlUnit = new ControlUnit();
        buildSubscribers();
        buildObservers();
    }

    public ControlUnit getControlUnit() {
        return controlUnit;
    }

    public void buildSubscribers() {
        electricEngine.forEach(controlUnit::addSubscriber);
        ledHeadlights.forEach(controlUnit::addSubscriber);
        brakelights.forEach(controlUnit::addSubscriber);
        indicators.forEach(controlUnit::addSubscriber);
        brakes.forEach(controlUnit::addSubscriber);
        gps.forEach(controlUnit::addSubscriber);
        cameraPorts.forEach(p -> controlUnit.addSubscriber(new CameraSubscriber(p)));
        lidarPorts.forEach(p -> controlUnit.addSubscriber(new LidarSubscriber(p)));
    }

    private void buildObservers() {
        doors.forEach(door -> {
            rightOpenDoorButton.addObserver(door);
            leftOpenDoorButton.addObserver(door);
        });
        batteries.forEach(battery -> battery.getTemperatureSensor().addObserver(controlUnit));
        ultrasonicSensors.forEach(ultrasonicSensor -> ultrasonicSensor.addObserver(controlUnit));
    }

    public void pluginFourPoles() {
        System.out.println("\n");
        System.out.println("Charging battery (4-pole Connector)");
        batteries.forEach(Battery::charge);
    }

    private void drainEnergy() {
        electricEngine.get(0).drainEnergy(batteries);
    }


    public void pressLeftOpenDoorButton() {
        leftOpenDoorButton.press();
    }

    public void pressRightOpenDoorButton() {
        rightOpenDoorButton.press();
    }

    public String toString() {
        return "\nThe Car is build of: \n" +
                "• " + Configuration.instance.numberOfChassis + " Chassis \n" +
                "• " + Configuration.instance.numberOfElectricEngines + " Electric Engines \n" +
                "• " + Configuration.instance.numberOfLedHeadlights + " LED Headlights\n" +
                "• " + Configuration.instance.numberOfBrakeLights + " Brakelights\n" +
                "• " + Configuration.instance.numberOfIndicators + " Indicators\n" +
                "• " + Configuration.instance.numberOfDoors + " Doors\n" +
                "• " + Configuration.instance.numberOfBenchs + " Benches\n" +
                "• " + Configuration.instance.numberOfWheels + " Wheels\n" +
                "• " + Configuration.instance.numberOfBrakes + " Brakes\n" +
                "• " + Configuration.instance.numberOfGPS + " GPS\n" +
                "• " + Configuration.instance.numberOfCameras + " Cameras\n" +
                "• " + Configuration.instance.numberOfLidars + " Lidars\n";
    }

    @Override
    public void startup() {
        controlUnit.startup();
        drainEnergy();
    }

    @Override
    public void move(int deltaRPM, int seconds) {
        controlUnit.move(deltaRPM, seconds);
        drainEnergy();
    }

    @Override
    public void leftTurn(int deltaRPM, int seconds) {
        controlUnit.leftTurn(deltaRPM, seconds);
        drainEnergy();
    }

    @Override
    public void rightTurn(int deltaRPM, int seconds) {
        controlUnit.rightTurn(deltaRPM, seconds);
        drainEnergy();
    }

    @Override
    public void stop() {
        controlUnit.stop();
        drainEnergy();
    }

    @Override
    public void emergencyStop() {
        controlUnit.emergencyStop();
        drainEnergy();
    }

    @Override
    public void shutdown() {
        controlUnit.shutdown();
        drainEnergy();
    }

    public static class Builder {

        private final ArrayList<Chassis> chassis;
        private final ArrayList<Engine> electricEngines;
        private final ArrayList<LEDHeadlight> ledHeadlights;
        private final ArrayList<BrakeLight> brakelights;
        private final ArrayList<Indicator> indicators;
        private final ArrayList<Door> doors;
        private final ArrayList<Bench> benches;
        private final ArrayList<Wheel> wheels;
        private final ArrayList<Brake> brakes;
        private final ArrayList<GPS> gps;
        private final ArrayList<Object> cameraPorts;
        private final ArrayList<Object> lidarPorts;
        private final List<Battery> batteries;
        private final List<UltrasonicSensor> ultrasonicSensors;
        private OpenDoorButton leftOpenDoorButton;
        private OpenDoorButton rightOpenDoorButton;

        public Builder() {
            chassis = new ArrayList<>();
            electricEngines = new ArrayList<>();
            ledHeadlights = new ArrayList<>();
            brakelights = new ArrayList<>();
            indicators = new ArrayList<>();
            doors = new ArrayList<>();
            benches = new ArrayList<>();
            wheels = new ArrayList<>();
            brakes = new ArrayList<>();
            gps = new ArrayList<>();
            cameraPorts = new ArrayList<>();
            lidarPorts = new ArrayList<>();
            batteries = new ArrayList<>();
            ultrasonicSensors = new ArrayList<>();
        }

        public Builder chassis() {
            IntStream.range(0, Configuration.instance.numberOfChassis).mapToObj(i -> new Chassis()).forEach(this.chassis::add);
            return this;
        }

        public Builder electricEngine() {
            IntStream.range(0, Configuration.instance.numberOfElectricEngines).forEach(i -> {
                switch (Configuration.instance.engineType) {
                    case ENGINE_NG -> electricEngines.add(new EngineNG());
                    default -> electricEngines.add(new EngineX());
                }
            });
            return this;
        }

        public Builder ledHeadlights() {
            IntStream.range(0, Configuration.instance.numberOfLedHeadlights).mapToObj(i -> new LEDHeadlight()).forEach(this.ledHeadlights::add);

            return this;
        }

        public Builder brakeLights() {
            IntStream.range(0, Configuration.instance.numberOfBrakeLights).mapToObj(i -> new BrakeLight()).forEach(this.brakelights::add);

            return this;
        }

        public Builder indicator() {
            IntStream.range(0, Configuration.instance.numberOfIndicators / 2).mapToObj(i -> new Indicator(IndicatorSide.LEFT)).forEach(this.indicators::add);

            IntStream.range(0, Configuration.instance.numberOfIndicators / 2).mapToObj(i -> new Indicator(IndicatorSide.RIGHT)).forEach(this.indicators::add);

            return this;
        }

        public Builder benchs() {
            IntStream.range(0, Configuration.instance.numberOfBenchs).mapToObj(i -> new Bench()).forEach(this.benches::add);

            return this;
        }

        public Builder wheels() {
            IntStream.range(0, Configuration.instance.numberOfWheels).mapToObj(i -> new Wheel()).forEach(this.wheels::add);

            return this;
        }

        public Builder brakes() {
            IntStream.range(0, Configuration.instance.numberOfBrakes).mapToObj(i -> new Brake()).forEach(this.brakes::add);

            return this;
        }

        public Builder doors() {
            int bound = Configuration.instance.numberOfDoors / 2;
            IntStream.range(0, bound).mapToObj(i -> new Door(DoorType.LEFT)).forEach(this.doors::add);
            IntStream.range(0, bound).mapToObj(i -> new Door(DoorType.RIGHT)).forEach(this.doors::add);
            return this;
        }

        public Builder gps() {
            IntStream.range(0, Configuration.instance.numberOfGPS).mapToObj(i -> new GPS()).forEach(this.gps::add);

            return this;
        }

        //CAMERA PORTS

        public Builder camera() {
            IntStream.range(0, Configuration.instance.numberOfCameras).mapToObj(i -> CameraFactory.build()).forEach(cameraPorts::add);

            return this;
        }

        //LIDAR PORTS

        public Builder lidar() {
            IntStream.range(0, Configuration.instance.numberOfLidars).mapToObj(i -> LidarFactory.build()).forEach(lidarPorts::add);

            return this;
        }

        public Builder leftOpenDoorButton() {
            this.leftOpenDoorButton = new OpenDoorButton(OpenDoorButtonSide.LEFT);

            return this;
        }

        public Builder rightOpenDoorButton() {
            this.rightOpenDoorButton = new OpenDoorButton(OpenDoorButtonSide.RIGHT);

            return this;
        }

        public Builder battery() {
            IntStream.range(0, Configuration.instance.numberOfBattery).mapToObj(i -> new Battery()).forEach(this.batteries::add);

            return this;
        }

        public Builder ultrasonicSensor() {
            IntStream.range(0, Configuration.instance.numberOfUltrasonicSensors).mapToObj(i -> new UltrasonicSensor()).forEach(this.ultrasonicSensors::add);

            return this;
        }

        public void build() {
            new AmazonZoox(this);
        }
    }
}
