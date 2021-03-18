package parts.battery;

import java.util.ArrayList;
import java.util.List;

public class BatteryCellComposite extends BatteryCellComponent {

    protected final List<BatteryCellComponent> batteryCellComponents = new ArrayList<>();

    public void add(BatteryCellComponent batteryCellComponent) {
        batteryCellComponents.add(batteryCellComponent);
    }

    @Override
    public int getEnergy() {
        return batteryCellComponents.stream().mapToInt(BatteryCellComponent::getEnergy).sum();
    }

    @Override
    public void charge() {
        batteryCellComponents.forEach(BatteryCellComponent::charge);
    }

    @Override
    public void discharge() {
        batteryCellComponents.forEach(batteryCellComponent -> {
            if (batteryCellComponent.getEnergy() > 0) {
                batteryCellComponent.discharge();
            }
        });
    }
}