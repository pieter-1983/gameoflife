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

    public int getNumberOfAliveNeighbours(int row, int column) {
        int numberOfAliveNeighbours = 0;
        if (upperLeftCellExistsAndIsAlive(row, column)) {
            numberOfAliveNeighbours += 1;
        }
        if (upperCellExistsAndIsAlive(row, column)) {
            numberOfAliveNeighbours += 1;
        }
        if (upperRightCellExistsAndIsAlive(row, column)) {
            numberOfAliveNeighbours += 1;
        }
        if (leftCellExistsAndIsAlive(row, column)) {
            numberOfAliveNeighbours += 1;
        }
        if (rightCellExistsAndIsAlive(row, column)) {
            numberOfAliveNeighbours += 1;
        }
        if (bottomLeftCellExistsAndIsAlive(row, column)) {
            numberOfAliveNeighbours += 1;
        }
        if (bottomCellExistsAndIsAlive(row, column)) {
            numberOfAliveNeighbours += 1;
        }
        if (bottomRightCellExistsAndIsAlive(row, column)) {
            numberOfAliveNeighbours += 1;
        }
        return numberOfAliveNeighbours;
    }

    private boolean upperLeftCellExistsAndIsAlive(int row, int column) {
        return row > 0 && column > 0 && getGrid().get(row - 1).get(column - 1).isAlive();
    }

    private boolean upperCellExistsAndIsAlive(int row, int column) {
        return row > 0 && getGrid().get(row - 1).get(column).isAlive();
    }

    private boolean upperRightCellExistsAndIsAlive(int row, int column) {
        return row > 0 && column != numberOfColumns - 1 && getGrid().get(row - 1).get(column + 1).isAlive();
    }

    private boolean leftCellExistsAndIsAlive(int row, int column) {
        return column > 0 && getGrid().get(row).get(column - 1).isAlive();
    }

    private boolean rightCellExistsAndIsAlive(int row, int column) {
        return column != numberOfColumns - 1 && getGrid().get(row).get(column + 1).isAlive();
    }

    private boolean bottomLeftCellExistsAndIsAlive(int row, int column) {
        return column > 0 && row != numberOfRows - 1 && getGrid().get(row + 1).get(column - 1).isAlive();
    }

    private boolean bottomCellExistsAndIsAlive(int row, int column) {
        return row != numberOfRows - 1 && getGrid().get(row + 1).get(column).isAlive();
    }

    private boolean bottomRightCellExistsAndIsAlive(int row, int column) {
        return row != numberOfRows - 1 && column != numberOfColumns - 1 && getGrid().get(row + 1).get(column + 1).isAlive();
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

    public static class WorldBuilder {
        private int rows;
        private int columns;
        private ArrayList<Cell> cells;

        public WorldBuilder withRows(int rows) {
            this.rows = rows;
            return this;
        }

        public WorldBuilder withColumns(int columns) {
            this.columns = columns;
            return this;
        }

        public WorldBuilder withCells(ArrayList<Cell> cells) {
            this.cells = cells;
            return this;
        }

        public World buildWorld() {
            return new World(rows, columns, cells);
        }
    }

}
