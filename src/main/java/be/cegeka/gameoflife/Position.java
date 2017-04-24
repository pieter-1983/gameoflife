package be.cegeka.gameoflife;

import java.util.Objects;

public class Position {

    private final int x;
    private final int y;

    public static Position pos(int x, int y){
        return new Position(x, y);
    }

    private Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public Position left() {
        return pos(x, y - 1);
    }

    public Position right() {
        return pos(x, y + 1);
    }

    public Position top() {
        return pos(x - 1, y);
    }

    public Position bottom() {
        return pos(x + 1, y);
    }
}