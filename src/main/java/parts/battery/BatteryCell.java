package parts.battery;

public class BatteryCell {

    private final int numberMainCells = 32;
    private final int numberSubCells = 8;
    private final int numberSingleCells = 2;

    private final BatteryCell[] batteryCells = new BatteryCell[numberMainCells];
    private final BatteryCell[] maincells = new BatteryCell[numberSubCells];
    private final BatteryCell[] subcells = new BatteryCell[numberSingleCells];

    private final byte charged = 1;
    private final byte discharged = 0;

    private byte chargingState;

    public void createBattery() {
        for (int i = 0; i < numberMainCells; i++) {
            batteryCells[i] = new BatteryCell();
            batteryCells[i].createMainCell();
        }
    }

    public void createMainCell() {
        for (int i = 0; i < numberSubCells; i++) {
            maincells[i] = new BatteryCell();
            maincells[i].createSubCell();
        }
    }

    private void createSubCell() {
        for (int i = 0; i < numberSingleCells; i++) {
            subcells[i] = new BatteryCell();
            subcells[i].chargingState = charged;
        }
    }

    public BatteryCell[] getBatteryCells() {
        return batteryCells;
    }

    public BatteryCell[] getMaincells() {
        return maincells;
    }

    public BatteryCell[] getSubcells() {
        return subcells;
    }

    public byte getCharged() {
        return chargingState;
    }

    public void setDischarged() {
        this.chargingState = discharged;
    }

}
