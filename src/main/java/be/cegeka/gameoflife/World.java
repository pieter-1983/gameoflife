package be.cegeka.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class World {
    private List<List<Cell>> grid = new ArrayList<List<Cell>>();
    private int ammountOfRowsAndColumns;

    public World(int ammountOfRowsAndColumns, Cell... cells) {
        this.ammountOfRowsAndColumns = ammountOfRowsAndColumns;
        populateGrid(ammountOfRowsAndColumns, cells);
    }

    private void populateGrid(int ammountOfRowsAndColumns, Cell[] cells) {
        int index = 0;
        for (int row = 0; row < ammountOfRowsAndColumns; row++) {
            ArrayList<Cell> cellList = new ArrayList<>();
            for (int column = 0; column < ammountOfRowsAndColumns; column++) {
                cellList.add(cells[index]);
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
        if (row > 0 && column > 0 && getGrid().get(row - 1).get(column - 1).isAlive()) {
            numberOfAliveNeighbours += 1;
        }
        if (row > 0 && getGrid().get(row - 1).get(column).isAlive()) {
            numberOfAliveNeighbours += 1;
        }
        if (row > 0 && column != ammountOfRowsAndColumns - 1 && getGrid().get(row - 1).get(column + 1).isAlive()) {
            numberOfAliveNeighbours += 1;
        }
        if (column > 0 && getGrid().get(row).get(column - 1).isAlive()) {
            numberOfAliveNeighbours += 1;
        }
        if (column != ammountOfRowsAndColumns - 1 && getGrid().get(row).get(column + 1).isAlive()) {
            numberOfAliveNeighbours += 1;
        }
        if (column > 0 && row != ammountOfRowsAndColumns - 1 && getGrid().get(row + 1).get(column - 1).isAlive()) {
            numberOfAliveNeighbours += 1;
        }
        if (row != ammountOfRowsAndColumns - 1 && getGrid().get(row + 1).get(column).isAlive()) {
            numberOfAliveNeighbours += 1;
        }
        if (row != ammountOfRowsAndColumns - 1 && column != ammountOfRowsAndColumns - 1 && getGrid().get(row + 1).get(column + 1).isAlive()) {
            numberOfAliveNeighbours += 1;
        }
        return numberOfAliveNeighbours;
    }
}
