package fr.gwenrspl.exceptions;

/**
 * The exception thrown when the {@link fr.gwenrspl.utils.FileParser} encounters an invalid character while trying to parse a character into an {@link fr.gwenrspl.mower.Instruction}
 *
 * @author Gwen Rspl
 */
public class InvalidInstructionCharacter extends Exception {
    private static final long serialVersionUID = 6863003506458384487L;

    public InvalidInstructionCharacter(String message) {
        super(message);
    }
}
