package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.RookBlack;

public class LogicTest {

    @Test (expected = FigureNotFoundException.class)
    public void whenNotFoundExcepMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.move(Cell.C1, Cell.H6);
    }

    @Test (expected = OccupiedCellException.class)
    public void whenOccupExcepMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new RookBlack(Cell.C2));
        logic.add(new BishopBlack(Cell.B1));
        logic.move(Cell.B1, Cell.C2);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenImpMoveExcepMove()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.C1));
        logic.move(Cell.C1, Cell.H7);
    }
}