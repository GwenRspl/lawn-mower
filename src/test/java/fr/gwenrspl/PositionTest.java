package fr.gwenrspl;

import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PositionTest {
    Lawn lawn;

    @Before
    public void setUp() {
        this.lawn = new Lawn(5, 5);
    }

    @Test
    public void should_increase_y_when_moving_while_facing_north() {
        Position actualPosition = new Position(3, 3, Orientation.NORTH);
        Position expectedPosition = new Position(3, 4, Orientation.NORTH);
        assertThat(actualPosition.moveForward(this.lawn)).isEqualTo(expectedPosition);
    }

    @Test
    public void should_decrease_y_when_moving_while_facing_south() {
        Position actualPosition = new Position(3, 3, Orientation.SOUTH);
        Position expectedPosition = new Position(3, 2, Orientation.SOUTH);
        assertThat(actualPosition.moveForward(this.lawn)).isEqualTo(expectedPosition);
    }

    @Test
    public void should_increase_x_when_moving_while_facing_east() {
        Position actualPosition = new Position(3, 3, Orientation.EAST);
        Position expectedPosition = new Position(4, 3, Orientation.EAST);
        assertThat(actualPosition.moveForward(this.lawn)).isEqualTo(expectedPosition);
    }

    @Test
    public void should_decrease_x_when_moving_while_facing_west() {
        Position actualPosition = new Position(3, 3, Orientation.WEST);
        Position expectedPosition = new Position(2, 3, Orientation.WEST);
        assertThat(actualPosition.moveForward(this.lawn)).isEqualTo(expectedPosition);
    }

    @Test
    public void should_not_move_when_position_at_max_lawn_height_facing_north() {
        Position actualPosition = new Position(3, 5, Orientation.NORTH);
        Position expectedPosition = new Position(3, 5, Orientation.NORTH);
        assertThat(actualPosition.moveForward(this.lawn)).isEqualTo(expectedPosition);
    }

    @Test
    public void should_not_move_when_position_at_min_lawn_height_facing_south() {
        Position actualPosition = new Position(3, 0, Orientation.SOUTH);
        Position expectedPosition = new Position(3, 0, Orientation.SOUTH);
        assertThat(actualPosition.moveForward(this.lawn)).isEqualTo(expectedPosition);
    }

    @Test
    public void should_not_move_when_position_at_max_lawn_width_facing_east() {
        Position actualPosition = new Position(5, 3, Orientation.EAST);
        Position expectedPosition = new Position(5, 3, Orientation.EAST);
        assertThat(actualPosition.moveForward(this.lawn)).isEqualTo(expectedPosition);
    }

    @Test
    public void should_not_move_when_position_at_min_lawn_width_facing_west() {
        Position actualPosition = new Position(0, 3, Orientation.WEST);
        Position expectedPosition = new Position(0, 3, Orientation.WEST);
        assertThat(actualPosition.moveForward(this.lawn)).isEqualTo(expectedPosition);
    }

    @Test
    public void should_face_correct_orientation_after_turning_left() {
        Position actualPosition = new Position(0, 3, Orientation.NORTH);
        Position expectedWestPosition = new Position(0, 3, Orientation.WEST);
        Position expectedSouthPosition = new Position(0, 3, Orientation.SOUTH);
        Position expectedEastPosition = new Position(0, 3, Orientation.EAST);
        Position expectedNorthPosition = new Position(0, 3, Orientation.NORTH);
        SoftAssertions should = new SoftAssertions();
        should.assertThat(actualPosition.turnLeft()).isEqualTo(expectedWestPosition);
        should.assertThat(actualPosition.turnLeft()).isEqualTo(expectedSouthPosition);
        should.assertThat(actualPosition.turnLeft()).isEqualTo(expectedEastPosition);
        should.assertThat(actualPosition.turnLeft()).isEqualTo(expectedNorthPosition);
        should.assertAll();
    }

    @Test
    public void should_face_correct_orientation_after_turning_right() {
        Position actualPosition = new Position(0, 3, Orientation.NORTH);
        Position expectedWestPosition = new Position(0, 3, Orientation.WEST);
        Position expectedSouthPosition = new Position(0, 3, Orientation.SOUTH);
        Position expectedEastPosition = new Position(0, 3, Orientation.EAST);
        Position expectedNorthPosition = new Position(0, 3, Orientation.NORTH);
        SoftAssertions should = new SoftAssertions();
        should.assertThat(actualPosition.turnRight()).isEqualTo(expectedEastPosition);
        should.assertThat(actualPosition.turnRight()).isEqualTo(expectedSouthPosition);
        should.assertThat(actualPosition.turnRight()).isEqualTo(expectedWestPosition);
        should.assertThat(actualPosition.turnRight()).isEqualTo(expectedNorthPosition);
        should.assertAll();
    }
}
