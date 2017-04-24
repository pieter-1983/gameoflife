package be.cegeka.gameoflife;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        return findLiveNeighbours(x, y);
    }

    private List<Cell> findLiveNeighbours(int x, int y) {
        return Stream.of(
                findCellAt(x - 1, y - 1),
                findCellAt(x - 1, y),
                findCellAt(x - 1, y + 1),
                findCellAt(x, y - 1),
                findCellAt(x, y + 1),
                findCellAt(x + 1, y - 1),
                findCellAt(x + 1, y),
                findCellAt(x + 1, y + 1)
        )
        .filter(Objects::nonNull)
        .filter(Cell::isAlive)
        .collect(Collectors.toList());
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
