package be.cegeka.gameoflife;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static be.cegeka.gameoflife.Position.pos;

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
        Cell cell = findCellAt(pos(x, y));
        if (cell == null) return Collections.emptyList();
        return findLiveNeighbours(pos(x,y));
    }

    private List<Cell> findLiveNeighbours(Position pos) {
        return findExistingNeighbours(pos)
                .filter(Cell::isAlive)
                .collect(Collectors.toList());
    }

    private Stream<Cell> findExistingNeighbours(Position pos) {
        int x = pos.x();
        int y = pos.y();
        return Stream.of(
                findCellAt(pos(x - 1, y - 1)),
                findCellAt(pos(x - 1, y)),
                findCellAt(pos(x - 1, y + 1)),
                findCellAt(pos(x, y - 1)),
                findCellAt(pos(x, y + 1)),
                findCellAt(pos(x + 1, y - 1)),
                findCellAt(pos(x + 1, y)),
                findCellAt(pos(x + 1, y + 1))
        )
        .filter(Objects::nonNull);
    }

    Cell findCellAt(Position pos) {
        Cell cell;
        try {
            cell = this.cells.get(pos.x()).get(pos.y());
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
        return cell;
    }
}
