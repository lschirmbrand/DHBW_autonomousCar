package parts.battery;

public class BatteryPack {

    private final int numberOfBatteries = 8;
    private final BatteryCell[] batteryPack = new BatteryCell[numberOfBatteries];

    public BatteryPack() {
        for (int i = 0; i < batteryPack.length; i++) {
            batteryPack[i] = new BatteryCell();
            batteryPack[i].createBattery();
        }
    }

    public BatteryCell[] getBatteryPack() {
        return this.batteryPack;
    }
}
