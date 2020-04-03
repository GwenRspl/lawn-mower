package fr.gwenrspl.mower.position;

import fr.gwenrspl.exceptions.InvalidOrientationCharacter;

public enum Orientation {
    NORTH('N'),
    EAST('E'),
    WEST('W'),
    SOUTH('S');

    private final char orientationChar;

    Orientation(char orientationChar) {
        this.orientationChar = orientationChar;
    }

    public static Orientation getByChar(char character) throws InvalidOrientationCharacter {
        for (Orientation orientation : Orientation.values()) {
            if (character == orientation.orientationChar) {
                return orientation;
            }
        }
        throw new InvalidOrientationCharacter(character + " is not a valid orientation character");
    }

    public char getOrientationChar() {
        return this.orientationChar;
    }
}
