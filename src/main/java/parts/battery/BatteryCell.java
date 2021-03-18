package parts.battery;

public class BatteryCell extends BatteryCellComponent {
    private int energy;

    public BatteryCell() {
        energy = 1;
    }

    @Override
    public int getEnergy() {
        return energy;
    }

    @Override
    public void charge() {
        energy = 1;
    }

    @Override
    public void discharge() {
        energy = 0;
    }
}