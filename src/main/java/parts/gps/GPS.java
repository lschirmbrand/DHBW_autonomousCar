package parts.gps;

import com.google.common.eventbus.Subscribe;
import parts.Subscriber;
import parts.gps.events.GPSConnectSatellite;
import parts.gps.events.GPSOff;
import parts.gps.events.GPSOn;

@SuppressWarnings({"UnstableApiUsage", "FieldCanBeLocal"})
public class GPS extends Subscriber {
    private boolean isOn;
    private String frequenzy;

    @Subscribe
    public void receive(GPSOn gpsOn) {
        this.isOn = true;
        System.out.println("GPS was turned: On");
    }

    @Subscribe
    public void receive(GPSOff gpsOff) {
        this.isOn = false;
        System.out.println("GPS was turned: Off");
    }

    @Subscribe
    public void receive(GPSConnectSatellite gpsConnectSatellite) {
        this.frequenzy = gpsConnectSatellite.getFrequency();
        System.out.println("GPS was set to frequenzy: " + this.frequenzy + " Hz.");
    }
}
