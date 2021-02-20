package parts.battery;

import parts.battery.*;

public class BatteryCMS {

    private BatteryPack batteries = new BatteryPack();
    private BatteryCell batteryPack[];

    public void startUpCMS() {
        this.batteryPack = batteries.getBatteryPack();
    }

    public void dischargeBattery(int amount) {
        int numDischarged = 0;
        for (int i = 0; i < batteryPack.length; i++) {
            for (int j = 0; j < batteryPack[i].getBatteryCells().length; i++) {
                for (int k = 0; k < batteryPack[i].getBatteryCells()[j].getMaincells().length; k++) {
                    for (int h = 0; h < batteryPack[i].getBatteryCells()[j].getMaincells()[k].getSubcells().length; h++) {
                        if (numDischarged == amount) {
                            break;
                        } else {
                            if (batteryPack[i].getBatteryCells()[j].getMaincells()[k].getSubcells()[h].getCharged() == 1) {
                                batteryPack[i].getBatteryCells()[j].getMaincells()[k].getSubcells()[h].setDischarged();
                                numDischarged++;
                            }
                        }
                    }
                }

            }
        }
    }
}
