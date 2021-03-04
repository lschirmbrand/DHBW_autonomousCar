package configuration;

import parts.electricEngine.EngineTypeE;

public enum Configuration {
    instance;

    public String userDirectory = System.getProperty("user.dir");
    public String fileSeparator = System.getProperty("file.separator");
    public String commonPathToJavaArchive = userDirectory + fileSeparator + "components" + fileSeparator;
    public String lineSeparator = System.getProperty("line.separator");


    //Camera
    public String pathToCameraJavaArchive = commonPathToJavaArchive + "camera" + fileSeparator + "build" + fileSeparator + "libs" + fileSeparator + "camera.jar";
    public int numberOfCameras = 4;
    public String cameraType = "V1";

    //Lidar
    public String pathToLidarJavaArchive = commonPathToJavaArchive + "camera" + fileSeparator + "build" + fileSeparator + "libs" + fileSeparator + "lidar.jar";
    public int numberOfLidars = 4;
    public String lidarType = "LIDAR_NG";

    //Chassis
    public int numberOfChassis = 1;

    //Electric Engine
    public int numberOfElectricEngines = 1;
    public EngineTypeE engineType = EngineTypeE.ENGINE_NG;

    //LedHeadlights
    public int numberOfLedHeadlights = 4;

    //Brakelights
    public int numberOfBrakeLights = 4;

    //Indicator
    public int numberOfIndicators = 4;

    //Doors
    public int numberOfDoors = 4;

    //Bench
    public int numberOfBenchs = 2;

    //Wheels
    public int numberOfWheels = 4;

    //Brake
    public int numberOfBrakes = 4;

    //GPS
    public int numberOfGPS = 2;

}
