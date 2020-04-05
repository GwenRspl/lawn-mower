package fr.gwenrspl;

import fr.gwenrspl.exceptions.FileParserException;
import fr.gwenrspl.exceptions.InvalidInstructionCharacter;
import fr.gwenrspl.exceptions.InvalidOrientationCharacter;
import fr.gwenrspl.mower.Mower;
import fr.gwenrspl.mower.position.Position;
import fr.gwenrspl.utils.FileParser;

import java.util.List;

public class MowersHandler {
    private Lawn lawn;
    private List<Mower> mowers;


    private void initMowersHandler() throws FileParserException, InvalidOrientationCharacter, InvalidInstructionCharacter {
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
            Position position = mower.processInstructions(this.lawn);
            result.append(position.getX());
            result.append(" ");
            result.append(position.getY());
            result.append(" ");
            result.append(position.getOrientation().getOrientationChar());
            result.append("\n");
        }
        return result.toString().trim();
    }
}
