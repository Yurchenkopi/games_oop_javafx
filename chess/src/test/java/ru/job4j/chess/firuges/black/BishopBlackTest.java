package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void position() {
        Cell newPos = new BishopBlack(Cell.A2).position();
        assertThat(newPos, is(Cell.A2));
    }

    @Test
    public void copy() {
        Figure figure = new BishopBlack(Cell.A3);
        Cell pos = figure.copy(Cell.B4).position();
        assertThat(pos, is(Cell.B4));
    }

    @Test
    public void way() {
        Cell[] expectedCells = {Cell.D3, Cell.E4, Cell.F5, Cell.G6};
        Figure figure = new BishopBlack(Cell.C2);
        Cell[] cellsArr = figure.way(Cell.G6);
        assertThat(cellsArr[0], is(expectedCells[0]));
        assertThat(cellsArr[1], is(expectedCells[1]));
        assertThat(cellsArr[2], is(expectedCells[2]));
        assertThat(cellsArr[3], is(expectedCells[3]));

    }
}