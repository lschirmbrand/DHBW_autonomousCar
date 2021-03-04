package configuration;

public class InteriorMemento {

    private Boolean rejectDrunkenPassenger;
    private Boolean stopByPoliceRequest;
    private Boolean allowDriveByNight;
    private BehaviorWithNaggingPassengers behaviorWithNaggingPassengers;
    private MusicDuringDrive musicDuringDrive;


    public InteriorMemento(Boolean rejectDrunkenPassenger, Boolean stopByPoliceRequest, Boolean allowDriveByNight,
                           BehaviorWithNaggingPassengers behaviorWithNaggingPassengers,
                           MusicDuringDrive musicDuringDrive) {
        super();
        this.rejectDrunkenPassenger = rejectDrunkenPassenger;
        this.stopByPoliceRequest = stopByPoliceRequest;
        this.allowDriveByNight = allowDriveByNight;
        this.behaviorWithNaggingPassengers = behaviorWithNaggingPassengers;
        this.musicDuringDrive = musicDuringDrive;

    }


    public Boolean getRejectDrunkenPassenger() {
        return rejectDrunkenPassenger;
    }

    public void setRejectDrunkenPassenger(Boolean rejectDrunkenPassenger) {
        this.rejectDrunkenPassenger = rejectDrunkenPassenger;
    }

    public Boolean getStopByPoliceRequest() {
        return stopByPoliceRequest;
    }

    public void setStopByPoliceRequest(Boolean stopByPoliceRequest) {
        this.stopByPoliceRequest = stopByPoliceRequest;
    }

    public Boolean getAllowDriveByNight() {
        return allowDriveByNight;
    }

    public void setAllowDriveByNight(Boolean allowDriveByNight) {
        this.allowDriveByNight = allowDriveByNight;
    }

    public BehaviorWithNaggingPassengers getBehaviorWithNaggingPassengers() {
        return behaviorWithNaggingPassengers;
    }

    public void setBehaviorWithNaggingPassengers(BehaviorWithNaggingPassengers behaviorWithNaggingPassengers) {
        this.behaviorWithNaggingPassengers = behaviorWithNaggingPassengers;
    }

    public MusicDuringDrive getMusicDuringDrive() {
        return musicDuringDrive;
    }

    public void setMusicDuringDrive(MusicDuringDrive musicDuringDrive) {
        this.musicDuringDrive = musicDuringDrive;
    }
}
