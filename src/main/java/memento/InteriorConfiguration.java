package memento;

public class InteriorConfiguration {

    private Boolean rejectDrunkenPassenger;
    private Boolean stopByPoliceRequest;
    private Boolean allowDriveByNight;
    private BehaviorWithNaggingPassengers behaviorWithNaggingPassengers;
    private MusicDuringDrive musicDuringDrive;


    public InteriorConfiguration(Boolean rejectDrunkenPassenger, Boolean stopByPoliceRequest,
                                 Boolean allowDriveByNight, BehaviorWithNaggingPassengers behaviorWithNaggingPassengers,
                                 MusicDuringDrive musicDuringDrive) {
        super();
        this.rejectDrunkenPassenger = rejectDrunkenPassenger;
        this.stopByPoliceRequest = stopByPoliceRequest;
        this.allowDriveByNight = allowDriveByNight;
        this.behaviorWithNaggingPassengers = behaviorWithNaggingPassengers;
        this.musicDuringDrive = musicDuringDrive;

    }


    public InteriorMemento save() {
        return new InteriorMemento(rejectDrunkenPassenger, stopByPoliceRequest, allowDriveByNight,
                behaviorWithNaggingPassengers, musicDuringDrive);
    }

    public void restore(InteriorMemento memento) {
        rejectDrunkenPassenger = memento.getRejectDrunkenPassenger();
        stopByPoliceRequest = memento.getStopByPoliceRequest();
        allowDriveByNight = memento.getAllowDriveByNight();
        behaviorWithNaggingPassengers = memento.getBehaviorWithNaggingPassengers();
        musicDuringDrive = memento.getMusicDuringDrive();

    }

    public void print() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Configuration ").append("\n").append("\n");
        stringBuilder.append("RejectDrunkenPassenger: ").append(rejectDrunkenPassenger).append("\n")
                .append("stopByPoliceRequest: ").append(stopByPoliceRequest).append("\n")
                .append("allowDriveByNight: ").append(allowDriveByNight).append("\n")
                .append("behaviorWithNaggingPassengers: ").append(behaviorWithNaggingPassengers).append("\n")
                .append("musicDuringDrive: ").append(musicDuringDrive).append("\n");
        System.out.println(stringBuilder.toString());
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