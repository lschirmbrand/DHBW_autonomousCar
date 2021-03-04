package parts.indicator;

import com.google.common.eventbus.Subscribe;
import parts.Subscriber;
import parts.indicator.events.*;

@SuppressWarnings({"UnstableApiUsage", "FieldCanBeLocal", "unused"})
public class Indicator extends Subscriber {

    private IndicatorSide indicatorSide;

    private boolean leftIndicatorOn = false;
    private boolean rightIndicatorOn = false;
    private boolean hazardWarningOn = false;

    @Subscribe
    public void receive(LeftIndicatorOn leftIndicatorOn) {
        leftIndicatorOn();
    }

    @Subscribe
    public void receive(LeftIndicatorOff leftIndicatorOff) {
        leftIndicatorOff();
    }

    @Subscribe
    public void receive(RightIndicatorOn rightIndicatorOn) {
        rightIndicatorOn();
    }

    @Subscribe
    public void receive(RightIndicatorOff rightIndicatorOn) {
        rightIndicatorOff();
    }

    @Subscribe
    public void receive(HazardWarningOn hazardWarningOn) {
        hazardWarningOn();
    }

    @Subscribe
    public void receive(HazardWarningOff hazardWarningOff) {
        hazardWarningOff();
    }

    public void leftIndicatorOn() {
        if (indicatorSide == IndicatorSide.LEFT) {
            leftIndicatorOn = true;
            System.out.println("Left Indicator was turned: On");
        }
    }

    public void leftIndicatorOff() {
        if (indicatorSide == IndicatorSide.LEFT) {
            if (this.leftIndicatorOn) {
                leftIndicatorOn = false;
                System.out.println("Left Indicator was turned: Off");
            }
        }
    }

    public void rightIndicatorOn() {
        if (indicatorSide == IndicatorSide.RIGHT) {
            rightIndicatorOn = true;
            System.out.println("Right Indicator was turned: On");
        }
    }

    public void rightIndicatorOff() {
        if (indicatorSide == IndicatorSide.RIGHT) {
            if (this.rightIndicatorOn) {
                rightIndicatorOn = false;
                System.out.println("Right Indicator was turned: Off");
            }
        }
    }

    public void hazardWarningOn() {
        this.hazardWarningOn = true;
        System.out.println("Hazard Warning was turned: On");
    }

    public void hazardWarningOff() {
        this.hazardWarningOn = false;
        System.out.println("Hazard Warning was turned: On");
    }

    public void setSide(IndicatorSide indicator) {
        this.indicatorSide = indicator;
    }
}
