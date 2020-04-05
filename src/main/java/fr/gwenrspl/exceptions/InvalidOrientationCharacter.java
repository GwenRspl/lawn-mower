package fr.gwenrspl.exceptions;

/**
 * The exception thrown when the {@link fr.gwenrspl.utils.FileParser} encounters an invalid character while trying to parse a character into an {@link fr.gwenrspl.mower.position.Orientation}
 *
 * @author Gwen Rspl
 */
public class InvalidOrientationCharacter extends Exception {
    private static final long serialVersionUID = 686300350645838441L;

    public InvalidOrientationCharacter(String message) {
        super(message);
    }
}
