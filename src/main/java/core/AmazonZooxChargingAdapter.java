package core;

public class AmazonZooxChargingAdapter extends AmazonZoox implements IChargingStation {

    public AmazonZooxChargingAdapter(AmazonZoox.Builder builder) {
        super(builder);
    }

    @Override
    public void pluginTwoPoles() {
        pluginFourPoles();
    }
}

