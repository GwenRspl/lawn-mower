package fr.gwenrspl.exceptions;

/**
 * The exception thrown when the {@link fr.gwenrspl.utils.FileParser} encounters a problem with file input.txt containing the instructions
 *
 * @author Gwen Rspl
 */
public class FileParserException extends Exception {
    private static final long serialVersionUID = 6863003506458384417L;

    public FileParserException(String message) {
        super(message);
    }
}
