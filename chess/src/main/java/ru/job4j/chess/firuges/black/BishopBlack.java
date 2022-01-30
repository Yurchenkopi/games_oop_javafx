package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!isDiagonal(position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest)
            );
        }
        int size = Math.abs(this.position.getX() - dest.getX());
        Cell[] steps = new Cell[size];
        int deltaX = dest.getX() - this.position.getX() < 0 ? -1 : 1;
        int deltaY = dest.getY() - this.position.getY() < 0 ? -1 : 1;
        int posX = this.position.getX() + deltaX;
        int posY = this.position.getY() + deltaY;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(posX, posY);
            posX = posX + deltaX;
            posY = posY + deltaY;
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        int x1 = source.getX();
        int y1 = source.getY();
        int x2 = dest.getX();
        int y2 = dest.getY();
        return Math.abs(x2 - x1) == Math.abs(y2 - y1);
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
