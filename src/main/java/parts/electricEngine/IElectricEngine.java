package parts.electricEngine;

public interface IElectricEngine {
    boolean on();

    boolean off();

    int increaseRPM(int deltaRPM, int seconds);

    int decreaseRPM(int deltaRPM, int seconds);
}
