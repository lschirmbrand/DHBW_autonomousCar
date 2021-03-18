package core;

public interface IAutonomousDrive {
    void startup();

    void move(int deltaRPM, int seconds);

    void leftTurn(int deltaRPM, int seconds);

    void rightTurn(int deltaRPM, int seconds);

    void stop();

    void emergencyStop();

    void shutdown();
}
