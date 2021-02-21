package parts.battery;

public class BatteryCMS {

    private final BatteryPack batteries = new BatteryPack();
    private BatteryCell[] batteryPack;

    public void startUpCMS() {
        this.batteryPack = batteries.getBatteryPack();
    }

    public void drain(int amount) {
        int numDischarged = 0;
        double sum = 0;
        for (int i = 0; i < batteryPack.length; i++) {
            for (int j = 0; j < batteryPack[i].getBatteryCells().length; j++) {
                for (int k = 0; k < batteryPack[i].getBatteryCells()[j].getMaincells().length; k++) {
                    for (int h = 0; h < batteryPack[i].getBatteryCells()[j].getMaincells()[k].getSubcells().length; h++) {
                        if (batteryPack[i].getBatteryCells()[j].getMaincells()[k].getSubcells()[h].getCharged() == 1) {
                            sum++;
                            if (numDischarged < amount) {
                                batteryPack[i].getBatteryCells()[j].getMaincells()[k].getSubcells()[h].setDischarged();
                                numDischarged++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Battery at " + getChargingPercentage(sum - amount) + "%");
    }


    public double getChargingPercentage(double sum) {
        return ((sum / 4096) * 100);
    }
}
