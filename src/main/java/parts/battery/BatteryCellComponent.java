package parts.battery;

public abstract class BatteryCellComponent {
    public abstract int getEnergy();

    public abstract void charge();

    public abstract void discharge();
}