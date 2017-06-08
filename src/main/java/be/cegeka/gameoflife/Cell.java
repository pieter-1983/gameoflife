package be.cegeka.gameoflife;

public class Cell {
    private boolean state;

    public Cell(boolean state) {
        this.state = state;
    }

    public boolean isAlive() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return state == cell.state;
    }

    @Override
    public int hashCode() {
        return (state ? 1 : 0);
    }
}
