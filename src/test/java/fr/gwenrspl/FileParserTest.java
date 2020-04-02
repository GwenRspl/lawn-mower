package fr.gwenrspl;

import fr.gwenrspl.exceptions.FileParserException;
import fr.gwenrspl.exceptions.InvalidInstructionCharacter;
import fr.gwenrspl.exceptions.InvalidOrientationCharacter;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FileParserTest {

    private FileParser fileParser;

    @Before
    public void setUp() {
        this.fileParser = new FileParser();
    }

    @Test
    public void should_create_valid_lawn() throws FileParserException {
        Lawn expectedLawn = new Lawn(5, 5);
        assertThat(this.fileParser.parseLawn()).isEqualTo(expectedLawn);
    }

    @Test
    public void should_create_valid_mowers() throws FileParserException, InvalidOrientationCharacter, InvalidInstructionCharacter {
        Position p1 = new Position(1, 2, Orientation.NORTH);
        List<Instruction> i1 = new ArrayList<>();
        i1.add(Instruction.LEFT);
        i1.add(Instruction.FORWARD);
        i1.add(Instruction.LEFT);
        i1.add(Instruction.FORWARD);
        i1.add(Instruction.LEFT);
        i1.add(Instruction.FORWARD);
        i1.add(Instruction.LEFT);
        i1.add(Instruction.FORWARD);
        i1.add(Instruction.FORWARD);
        Mower expectedMower1 = new MowerImpl(p1, i1);

        Position p2 = new Position(3, 3, Orientation.EAST);
        List<Instruction> i2 = new ArrayList<>();
        i2.add(Instruction.FORWARD);
        i2.add(Instruction.FORWARD);
        i2.add(Instruction.RIGHT);
        i2.add(Instruction.FORWARD);
        i2.add(Instruction.FORWARD);
        i2.add(Instruction.RIGHT);
        i2.add(Instruction.FORWARD);
        i2.add(Instruction.RIGHT);
        i2.add(Instruction.RIGHT);
        i2.add(Instruction.FORWARD);
        Mower expectedMower2 = new MowerImpl(p2, i2);

        List<Mower> mowers = Arrays.asList(expectedMower1, expectedMower2);
        assertThat(this.fileParser.parseMowers()).isEqualTo(mowers);
    }

    @Test
    public void should_return_list_of_chars() {
        String stringToSplit = "ABCDEF";
        List<Character> characterList = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F');
        assertThat(this.fileParser.splitToListOfChar(stringToSplit)).isEqualTo(characterList);

    }

}
