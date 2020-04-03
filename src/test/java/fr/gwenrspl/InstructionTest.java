package fr.gwenrspl;

import fr.gwenrspl.exceptions.InvalidInstructionCharacter;
import fr.gwenrspl.mower.Instruction;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class InstructionTest {

    @Test
    public void should_return_instruction_given_correct_char() throws InvalidInstructionCharacter {
        SoftAssertions should = new SoftAssertions();
        should.assertThat(Instruction.getByChar('G')).isEqualTo(Instruction.LEFT);
        should.assertThat(Instruction.getByChar('D')).isEqualTo(Instruction.RIGHT);
        should.assertThat(Instruction.getByChar('A')).isEqualTo(Instruction.FORWARD);
        should.assertAll();
    }

    @Test
    public void should_throw_exception_given_invalid_char() {
        assertThatThrownBy(() -> Instruction.getByChar('Z')).isInstanceOf(InvalidInstructionCharacter.class);
    }
}
