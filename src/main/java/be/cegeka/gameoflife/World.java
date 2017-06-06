package be.cegeka.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class World {
    private List<List<Cell>> grid = new ArrayList<List<Cell>>();
    private int rows;
    private int columns;

    public World(int rows, int columns, ArrayList<Cell> cells) {
        this.rows = rows;
        this.columns=columns;
        populateGrid(rows, cells);
    }

    private void populateGrid(int amountOfListsAndSizeOfThem, ArrayList<Cell> cells) {
        int index = 0;
        for (int row = 0; row < rows; row++) {
            ArrayList<Cell> cellList = new ArrayList<>();
            for (int column = 0; column < columns; column++) {
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

    private boolean bottomRightCellExistsAndIsAlive(int row, int column) {
        return row != rows - 1 && column != columns - 1 && getGrid().get(row + 1).get(column + 1).isAlive();
    }

    private boolean bottomCellExistsAndIsAlive(int row, int column) {
        return row != rows - 1 && getGrid().get(row + 1).get(column).isAlive();
    }

    private boolean bottomLeftCellExistsAndIsAlive(int row, int column) {
        return column > 0 && row != rows - 1 && getGrid().get(row + 1).get(column - 1).isAlive();
    }

    private boolean rightCellExistsAndIsAlive(int row, int column) {
        return column != columns - 1 && getGrid().get(row).get(column + 1).isAlive();
    }

    private boolean leftCellExistsAndIsAlive(int row, int column) {
        return column > 0 && getGrid().get(row).get(column - 1).isAlive();
    }

    private boolean upperRightCellExistsAndIsAlive(int row, int column) {
        return row > 0 && column != columns - 1 && getGrid().get(row - 1).get(column + 1).isAlive();
    }

    private boolean upperCellExistsAndIsAlive(int row, int column) {
        return row > 0 && getGrid().get(row - 1).get(column).isAlive();
    }

    private boolean upperLeftCellExistsAndIsAlive(int row, int column) {
        return row > 0 && column > 0 && getGrid().get(row - 1).get(column - 1).isAlive();
    }
}
