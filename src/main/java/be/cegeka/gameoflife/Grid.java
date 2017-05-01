package be.cegeka.gameoflife;

public class Grid {
    private Cell[][] grid;
    private int ammountOfRowsAndColumns;

    public Grid(int ammountOfRowsAndColumns) {
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
        if (row > 0 && column > 0 && getGrid()[row - 1][column - 1].isAlive()) {
            numberOfAliveNeighbours += 1;
        }
        if (row > 0 && getGrid()[row - 1][column].isAlive()) {
            numberOfAliveNeighbours += 1;
        }
        if (row > 0 && column != ammountOfRowsAndColumns - 1 && getGrid()[row - 1][column + 1].isAlive()) {
            numberOfAliveNeighbours += 1;
        }
        if (column > 0 && getGrid()[row][column - 1].isAlive()) {
            numberOfAliveNeighbours += 1;
        }
        if (column != ammountOfRowsAndColumns - 1 && getGrid()[row][column + 1].isAlive()) {
            numberOfAliveNeighbours += 1;
        }
        if (column > 0 && row != ammountOfRowsAndColumns - 1 && getGrid()[row + 1][column - 1].isAlive()) {
            numberOfAliveNeighbours += 1;
        }
        if (row != ammountOfRowsAndColumns - 1 && getGrid()[row + 1][column].isAlive()) {
            numberOfAliveNeighbours += 1;
        }
        if (row != ammountOfRowsAndColumns - 1 && column != ammountOfRowsAndColumns - 1 && getGrid()[row + 1][column + 1].isAlive()) {
            numberOfAliveNeighbours += 1;
        }
        return numberOfAliveNeighbours;
    }
}
