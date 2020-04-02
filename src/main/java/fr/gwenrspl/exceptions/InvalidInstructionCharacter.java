package fr.gwenrspl.exceptions;

public class InvalidInstructionCharacter extends Exception {
    private static final long serialVersionUID = 6863003506458384487L;

    public InvalidInstructionCharacter(String message) {
        super(message);
    }
}
