package fr.gwenrspl.mower.position;

import fr.gwenrspl.exceptions.InvalidOrientationCharacter;

/**
 * The orientation enum
 *
 * @author Gwen Rspl
 */
public enum Orientation {
    /**
     * North orientation
     */
    NORTH('N'),
    /**
     * East orientation
     */
    EAST('E'),
    /**
     * West orientation
     */
    WEST('W'),
    /**
     * South orientation
     */
    SOUTH('S');

    private final char orientationChar;

    Orientation(char orientationChar) {
        this.orientationChar = orientationChar;
    }

    /**
     * This method parses a character to an orientation enum
     *
     * @param character the character to parse to orientation
     * @return the orientation corresponding to the character
     * @throws InvalidOrientationCharacter when it encounters a character that it cannot parse to an orientation
     */
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
