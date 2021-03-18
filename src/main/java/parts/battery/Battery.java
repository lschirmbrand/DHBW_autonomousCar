package parts.battery;

public class Battery extends BatteryCellComposite {
    private final TemperatureSensor temperatureSensor;

    public Battery() {
        for (int i = 0; i < 32; i++) {
            BatteryCellComposite mainCell = new BatteryCellComposite();
            for (int j = 0; j < 8; j++) {
                BatteryCellComposite subCell = new BatteryCellComposite();

                subCell.add(new BatteryCell());
                subCell.add(new BatteryCell());

                mainCell.add(subCell);
            }
            this.add(mainCell);
        }

        temperatureSensor = new TemperatureSensor();
    }

    public TemperatureSensor getTemperatureSensor() {
        return temperatureSensor;
    }
}