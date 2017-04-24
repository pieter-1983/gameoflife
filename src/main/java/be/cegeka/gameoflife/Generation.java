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
        Cell leftNeighbour = findCellAt(x, y - 1);
        Cell rightNeighbour = findCellAt(x,y+1);
        Cell topNeighbour = findCellAt(x-1,y);
        Cell topLeftNeighbour = findCellAt(x-1,y-1);
        Cell topRightNeighbour = findCellAt(x-1,y+1);
        Cell bottomNeighbour = findCellAt(x+1,y);
        Cell bottomLeftNeighbour = findCellAt(x+1,y-1);
        Cell bottomRightNeighbour = findCellAt(x+1,y+1);

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
