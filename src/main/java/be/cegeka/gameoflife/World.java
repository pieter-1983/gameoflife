package be.cegeka.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class World {
    private final List<List<Cell>> grid = new ArrayList<List<Cell>>();
    private final int numberOfRows;
    private final int numberOfColumns;

    private World(int numberOfRows, int numberOfColumns, ArrayList<Cell> cells) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        populateGrid(cells);
    }

    private void populateGrid(ArrayList<Cell> cells) {
        int index = 0;
        for (int row = 0; row < numberOfRows; row++) {
            ArrayList<Cell> cellList = new ArrayList<>();
            for (int column = 0; column < numberOfColumns; column++) {
                cellList.add(cells.get(index));
                index++;
            }
            grid.add(cellList);
        }
    }

    public List<List<Cell>> getGrid() {
        return grid;
    }


    public Cell getCell(int row, int column) {
        return grid.get(row).get(column);
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        World world = (World) o;

        if (numberOfRows != world.numberOfRows) return false;
        if (numberOfColumns != world.numberOfColumns) return false;
        return grid.equals(world.grid);
    }

    @Override
    public int hashCode() {
        int result = grid.hashCode();
        result = 31 * result + numberOfRows;
        result = 31 * result + numberOfColumns;
        return result;
    }

    public static class WorldBuilder {
        private int numberOfRows;
        private int numberOfColumns;
        private ArrayList<Cell> cells;

        public WorldBuilder withNumberOfRows(int numberOfRows) {
            this.numberOfRows = numberOfRows;
            return this;
        }

        public WorldBuilder withNumberColumns(int numberOfColumns) {
            this.numberOfColumns = numberOfColumns;
            return this;
        }

        public WorldBuilder withCells(ArrayList<Cell> cells) {
            this.cells = cells;
            return this;
        }

        public World buildWorld() {
            return new World(numberOfRows, numberOfColumns, cells);
        }
    }

}
