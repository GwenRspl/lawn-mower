package fr.gwenrspl;

import fr.gwenrspl.exceptions.FileParserException;
import fr.gwenrspl.exceptions.InvalidInstructionCharacter;
import fr.gwenrspl.exceptions.InvalidOrientationCharacter;
import fr.gwenrspl.mower.Mower;
import fr.gwenrspl.mower.position.Position;
import fr.gwenrspl.utils.FileParser;

import java.util.List;

/**
 * The class handling the list of {@link Mower} and their {@link Lawn}
 *
 * @author Gwen Rspl
 */
public class MowersHandler {
    /**
     * The lawn where the mowers will mow
     */
    private Lawn lawn;
    /**
     * The list of mowers present on the lawn
     */
    private List<Mower> mowers;

    /**
     * This method create the lawn and mowers by calling the {@link FileParser}
     *
     * @throws FileParserException         when it encounters a problem with the file input.txt
     * @throws InvalidOrientationCharacter when it encounters an invalid orientation character
     * @throws InvalidInstructionCharacter when it encounters an invalid instruction character
     */
    private void initMowersHandler() throws FileParserException, InvalidOrientationCharacter, InvalidInstructionCharacter {
        this.lawn = FileParser.parseLawn();
        this.mowers = FileParser.parseMowers();
    }

    /**
     * This method creates the lawn and mowers and execute the instruction of each mowers
     *
     * @return a string containing each mowers final position
     */
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
