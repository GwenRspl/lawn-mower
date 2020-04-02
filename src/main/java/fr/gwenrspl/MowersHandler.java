package fr.gwenrspl;

import fr.gwenrspl.exceptions.FileParserException;
import fr.gwenrspl.exceptions.InvalidInstructionCharacter;
import fr.gwenrspl.exceptions.InvalidOrientationCharacter;

import java.util.List;

public class MowersHandler {
    private Lawn lawn;
    private List<Mower> mowers;

    public void initMowersHandler() throws FileParserException, InvalidOrientationCharacter, InvalidInstructionCharacter {
        this.lawn = FileParser.parseLawn();
        this.mowers = FileParser.parseMowers();
    }

    public String executeMowersHandler() {
        StringBuilder result = new StringBuilder();
        try {
            this.initMowersHandler();
        } catch (FileParserException | InvalidOrientationCharacter | InvalidInstructionCharacter e) {
            result.append(e.getMessage());
        }
        for (Mower mower : this.mowers) {
            Position position = mower.processInstructions();
            result.append(position.getX());
            result.append(" ");
            result.append(position.getY());
            result.append(" ");
            result.append(position.getOrientation().getOrientationChar());
        }
        return result.toString();
    }

    public Lawn getLawn() {
        return this.lawn;
    }

    public void setLawn(Lawn lawn) {
        this.lawn = lawn;
    }

    public List<Mower> getMowers() {
        return this.mowers;
    }

    public void setMowers(List<Mower> mowers) {
        this.mowers = mowers;
    }
}
