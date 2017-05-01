package be.cegeka.gameoflife;

public class Cell {
    private boolean state;


    public Cell(boolean state) {
        this.state = state;
    }

    public boolean isAlive() {
        return state;
    }
}
