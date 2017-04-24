package be.cegeka.gameoflife;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

public class Generation {
    private List<List<Cell>> cells;

    public Generation(List<List<Cell>> cells) {
        this.cells = cells;
    }

    @SafeVarargs
    public static Generation of(List<Cell>... cells) {
        return new Generation(Arrays.asList(cells));
    }

    public List<List<Cell>> as2DList() {
        return cells;
    }

    public List<Cell> getLiveNeighbours(int x, int y) {
        return Collections.emptyList();
    }
}
