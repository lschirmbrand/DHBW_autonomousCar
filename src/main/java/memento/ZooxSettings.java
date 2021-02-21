package memento;

import java.util.Arrays;
import java.util.Scanner;

public class ZooxSettings {

    public ZooxSettings() {
        start();
    }

    private static void start() {
        BehaviorWithNaggingPassengers behaviorWithNaggingPassengers;
        MementoCaretaker mementoCaretaker = new MementoCaretaker();

        InteriorConfiguration interiorConfiguration = new InteriorConfiguration(true,
                true, true, BehaviorWithNaggingPassengers.DO_NOTHING,
                MusicDuringDrive.ACDC);

        System.out.println("\nYou are now in the Configuration menu. Enter '-config' if you want to see/change seettings. \nIf that's not the case, press Enter to continue.");

        Scanner scanner = new Scanner(System.in);
        String read = scanner.next();
        if (read.equals("-config")) {
            do {
                System.out.println("Menü:\n 1. print \n 2. set parameter \n 3. undo \n 4. exit");
                int choosen = scanner.nextInt();

                switch (choosen) {
                    case 1 -> {

                        System.out.println("--- print\n\n");
                        interiorConfiguration.print();

                    }
                    case 2 -> {

                        System.out.println("--- set parameter");
                        interiorConfiguration.print();
                        mementoCaretaker.setMemento(interiorConfiguration.save());

                        do {

                            System.out.println("choose parameter:\n 1. rejectDrunkenPassenger \n " +
                                    "2. stopByPoliceRequest \n 3. allowDriveByNight \n 4. behaviorWithNaggingPassenger" +
                                    "\n 5. musicDuringDrive \n 6. noMoreChanges");
                            choosen = scanner.nextInt();
                            if (choosen == 1) {

                                System.out.println("Choose new parameter value for rejectDrunkenPassenger:");
                                System.out.println("Current Value: " +
                                        interiorConfiguration.getRejectDrunkenPassenger());
                                System.out.println("Allowed Values: true OR false");

                                do {
                                    String scan = scanner.next();
                                    if (scan.equals("true")) {
                                        interiorConfiguration.setRejectDrunkenPassenger(Boolean.valueOf(scan));
                                        break;
                                    } else if (scan.equals("false")) {
                                        interiorConfiguration.setRejectDrunkenPassenger(Boolean.valueOf(scan));
                                        break;
                                    } else {
                                        System.out.println("WRONG INPUT");
                                    }
                                } while (true);

                            } else if (choosen == 2) {

                                System.out.println("Choose new parameter value for stopByPoliceRequest:");
                                System.out.println("Current Value: " + interiorConfiguration.getStopByPoliceRequest());
                                System.out.println("Allowed Values: true OR false");

                                do {
                                    String scan = scanner.next();
                                    if (scan.equals("true")) {
                                        interiorConfiguration.setStopByPoliceRequest(Boolean.valueOf(scan));
                                        break;
                                    } else if (scan.equals("false")) {
                                        interiorConfiguration.setStopByPoliceRequest(Boolean.valueOf(scan));
                                        break;
                                    } else {
                                        System.out.println("WRONG INPUT");
                                    }
                                } while (true);

                            } else if (choosen == 3) {

                                System.out.println("Choose new parameter value for allowDriveByNight:");
                                System.out.println("Current Value: " + interiorConfiguration.getAllowDriveByNight());
                                System.out.println("Allowed Values: true OR false");

                                do {
                                    String scan = scanner.next();
                                    if (scan.equals("true")) {
                                        interiorConfiguration.setAllowDriveByNight(Boolean.valueOf(scan));
                                        break;
                                    } else if (scan.equals("false")) {
                                        interiorConfiguration.setAllowDriveByNight(Boolean.valueOf(scan));
                                        break;
                                    } else {
                                        System.out.println("WRONG INPUT");
                                    }

                                } while (true);

                            } else if (choosen == 4) {

                                System.out.println("Choose new parameter value for behaviorWithNaggingPassenger:");
                                System.out.println("Current Value: " +
                                        interiorConfiguration.getBehaviorWithNaggingPassengers());
                                System.out.printf("Allowed Values:%s%n",
                                        Arrays.toString(BehaviorWithNaggingPassengers.values()));

                                do {

                                    String scan = scanner.next();
                                    if ("DO_NOTHING".equals(scan)) {
                                        interiorConfiguration.setBehaviorWithNaggingPassengers(
                                                BehaviorWithNaggingPassengers.DO_NOTHING);
                                        break;
                                    } else if ("STOP_AND_WAIT_FOR_EXCUSE".equals(scan)) {
                                        interiorConfiguration.setBehaviorWithNaggingPassengers(
                                                BehaviorWithNaggingPassengers.STOP_AND_WAIT_FOR_EXCUSE);
                                        break;
                                    } else {
                                        System.out.println("WRONG INPUT");
                                    }

                                } while (true);

                            } else if (choosen == 5) {

                                System.out.println("Choose new parameter value for musicDuringDrive:");
                                System.out.println("Current Value: " + interiorConfiguration.getMusicDuringDrive());
                                System.out.printf("Allowed Values:%s%n", Arrays.toString(MusicDuringDrive.values()));

                                do {

                                    String scan = scanner.next();
                                    if ("ACDC".equals(scan)) {
                                        interiorConfiguration.setMusicDuringDrive(MusicDuringDrive.ACDC);
                                        break;
                                    } else if ("HELENE_FISCHER".equals(scan)) {
                                        interiorConfiguration.setMusicDuringDrive(MusicDuringDrive.SABATON);
                                        break;
                                    } else {
                                        System.out.println("WRONG INPUT");
                                    }

                                } while (true);


                            } else if (choosen == 6) {

                                System.out.println("--- exit change parameters");
                                break;

                            }
                        } while (true);
                    }
                    case 3 -> {

                        System.out.println("--- undo");
                        interiorConfiguration.restore(mementoCaretaker.getMemento());

                    }
                    case 4 -> System.out.println("--- exit");
                }
                if (choosen == 4) {
                    break;
                }
            } while (true);
        } else {
            System.out.println();
        }
    }

}
