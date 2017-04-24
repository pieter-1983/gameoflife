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
        Cell cell = findCellAt(x, y);
        if (cell == null) return Collections.emptyList();
        // here we've identified that there is indeed a Cell at the given position
        // so let's start finding neighbours in all directions
        findCellAt(x,y-1); //left neighbour
        findCellAt(x,y+1); //right neighbour
        findCellAt(x-1,y); //top neighbour
        findCellAt(x-1,y-1); //top-left neighbour
        findCellAt(x-1,y+1); //top-right neighbour
        findCellAt(x+1,y); //bottom neighbour
        findCellAt(x+1,y-1); //bottom-left neighbour
        findCellAt(x+1,y+1); //bottom-right neighbour

        return Collections.emptyList();
    }

    Cell findCellAt(int x, int y) {
        Cell cell;
        try {
            cell = this.cells.get(x).get(y);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        return cell;
    }
}
