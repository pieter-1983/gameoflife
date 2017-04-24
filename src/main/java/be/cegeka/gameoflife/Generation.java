package be.cegeka.gameoflife;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        List<Cell> row;
        Cell cell;
        try {
            row = this.cells.get(x);
            cell = row.get(y);
        } catch (IndexOutOfBoundsException e) {
            return Collections.emptyList();
        }
        // here we've identified that there is indeed a Cell at the given position
        // so let's start finding neighbours in all directions
        findNeighbour(x,y-1); //left neighbour
        findNeighbour(x,y+1); //right neighbour
        findNeighbour(x-1,y); //top neighbour
        findNeighbour(x-1,y-1); //top-left neighbour
        findNeighbour(x-1,y+1); //top-right neighbour
        findNeighbour(x+1,y); //bottom neighbour
        findNeighbour(x+1,y-1); //bottom-left neighbour
        findNeighbour(x+1,y+1); //bottom-right neighbour

        return Collections.emptyList();
    }

    Cell findNeighbour(int x, int y) {
        return null;
    }
}
