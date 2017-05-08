package be.cegeka.gameoflife;

public class World {
    private Cell[][] grid;
    private int ammountOfRowsAndColumns;

    public World(int ammountOfRowsAndColumns) {
        this.ammountOfRowsAndColumns = ammountOfRowsAndColumns;
        this.grid = new Cell[ammountOfRowsAndColumns][ammountOfRowsAndColumns];
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public int getAmmountOfRowsAndColumns() {
        return ammountOfRowsAndColumns;
    }

    public void populate(Cell... cellStates) {
        int indexOfCellStates = 0;
        for (int row = 0; row < ammountOfRowsAndColumns; row++) {
            for (int column = 0; column < ammountOfRowsAndColumns; column++) {
                grid[row][column] = cellStates[indexOfCellStates];
                indexOfCellStates++;
            }
        }
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
        if (bottomLeftCellExistsAndIsALive(row, column)) {
            numberOfAliveNeighbours += 1;
        }
        if (bottomCellExistsAndIsAlive(row, column)) {
            numberOfAliveNeighbours += 1;
        }
        if (botoomRightCellExistsAndIsAlive(row, column)) {
            numberOfAliveNeighbours += 1;
        }
        return numberOfAliveNeighbours;
    }

    private boolean botoomRightCellExistsAndIsAlive(int row, int column) {
        return row != ammountOfRowsAndColumns - 1 && column != ammountOfRowsAndColumns - 1 && getGrid()[row + 1][column + 1].isAlive();
    }

    private boolean bottomCellExistsAndIsAlive(int row, int column) {
        return row != ammountOfRowsAndColumns - 1 && getGrid()[row + 1][column].isAlive();
    }

    private boolean bottomLeftCellExistsAndIsALive(int row, int column) {
        return column > 0 && row != ammountOfRowsAndColumns - 1 && getGrid()[row + 1][column - 1].isAlive();
    }

    private boolean rightCellExistsAndIsAlive(int row, int column) {
        return column != ammountOfRowsAndColumns - 1 && getGrid()[row][column + 1].isAlive();
    }

    private boolean leftCellExistsAndIsAlive(int row, int column) {
        return column > 0 && getGrid()[row][column - 1].isAlive();
    }

    private boolean upperCellExistsAndIsAlive(int row, int column) {
        return row > 0 && getGrid()[row - 1][column].isAlive();
    }

    private boolean upperRightCellExistsAndIsAlive(int row, int column) {
        return row > 0 && column != ammountOfRowsAndColumns - 1 && getGrid()[row - 1][column + 1].isAlive();
    }

    private boolean upperLeftCellExistsAndIsAlive(int row, int column) {
        return row > 0 && column > 0 && getGrid()[row - 1][column - 1].isAlive();
    }
}
