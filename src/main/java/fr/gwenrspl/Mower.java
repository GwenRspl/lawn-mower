package fr.gwenrspl;

public interface Mower {

    void moveForward();

    void turnRight();

    void turnLeft();

    Position processInstructions();
}
