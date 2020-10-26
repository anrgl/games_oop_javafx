package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.KnightBlack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class LogicTest {
    @Test(expected = FigureNotFoundException.class)
    public void whenFigureNotFoundThenException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.move(Cell.C1, Cell.C2);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenFigureMoveToImpossibleCellThenException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.C2);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenFigureMoveToNonFreeCellThenException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A3));
        logic.add(new KnightBlack(Cell.B4));
        logic.move(Cell.A3, Cell.B4);
    }

    @Test()
    public void whenFigureMoveToFreeCellThenCopyFigure()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        BishopBlack in = new BishopBlack(Cell.A3);
        logic.add(in);
        logic.move(Cell.A3, Cell.C5);
        assertThat(in.position(), is(Cell.C5));
    }
}