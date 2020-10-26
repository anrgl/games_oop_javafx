package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class BishopBlackTest {
    @Test
    public void whenStartGameThenPositionX8Y3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H5);
        Cell expect = Cell.findBy(7, 3);
        assertThat(bishopBlack.position(), is(expect));
    }

    @Test
    public void whenBlackBishopOnX4Y3() {
        BishopBlack bishopBlack = new BishopBlack(Cell.E5);
        Cell expect = Cell.findBy(4, 3);
        assertThat(bishopBlack.position(), is(expect));
    }

    @Test
    public void whenCopyH5ThenE5() {
        BishopBlack bishopBlack = new BishopBlack(Cell.H5);
        Cell expect = Cell.E5;
        Cell out = bishopBlack.copy(Cell.E5).position();
        assertThat(out, is(expect));
    }

    @Test
    public void whenWayStartC1EndG5ThenWayD2E3F4G5() {
        BishopBlack in = new BishopBlack(Cell.C1);
        Cell[] expect = {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Cell[] out = in.way(Cell.G5);
        assertThat(out, is(expect));
    }

    @Test(expected = IllegalStateException.class)
    public void whenWayStartC1EndG5ThenIllegalStateException() {
        BishopBlack in = new BishopBlack(Cell.C1);
        Cell[] out = in.way(Cell.G4);
    }
}