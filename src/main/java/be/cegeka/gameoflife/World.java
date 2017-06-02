package be.cegeka.gameoflife;

import java.util.ArrayList;
import java.util.List;

public class World {
    private List<List<Cell>> grid = new ArrayList<List<Cell>>();
    private int amountOfListsAndSizeOfThem;

    public World(int amountOfListsAndSizeOfThem, ArrayList<Cell> cells) {
        this.amountOfListsAndSizeOfThem = amountOfListsAndSizeOfThem;
        populateGrid(amountOfListsAndSizeOfThem, cells);
    }

    private void populateGrid(int amountOfListsAndSizeOfThem, ArrayList<Cell> cells) {
        int index = 0;
        for (int rows = 0; rows < amountOfListsAndSizeOfThem; rows++) {
            ArrayList<Cell> cellList = new ArrayList<>();
            for (int column = 0; column < amountOfListsAndSizeOfThem; column++) {
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

    private boolean bottomRightCellExistsAndIsAlive(int list, int positionInList) {
        return list != amountOfListsAndSizeOfThem - 1 && positionInList != amountOfListsAndSizeOfThem - 1 && getGrid().get(list + 1).get(positionInList + 1).isAlive();
    }

    private boolean bottomCellExistsAndIsAlive(int list, int positionInList) {
        return list != amountOfListsAndSizeOfThem - 1 && getGrid().get(list + 1).get(positionInList).isAlive();
    }

    private boolean bottomLeftCellExistsAndIsAlive(int list, int positionInList) {
        return positionInList > 0 && list != amountOfListsAndSizeOfThem - 1 && getGrid().get(list + 1).get(positionInList - 1).isAlive();
    }

    private boolean rightCellExistsAndIsAlive(int list, int positionInList) {
        return positionInList != amountOfListsAndSizeOfThem - 1 && getGrid().get(list).get(positionInList + 1).isAlive();
    }

    private boolean leftCellExistsAndIsAlive(int list, int positionInList) {
        return positionInList > 0 && getGrid().get(list).get(positionInList - 1).isAlive();
    }

    private boolean upperRightCellExistsAndIsAlive(int list, int positionInList) {
        return list > 0 && positionInList != amountOfListsAndSizeOfThem - 1 && getGrid().get(list - 1).get(positionInList + 1).isAlive();
    }

    private boolean upperCellExistsAndIsAlive(int list, int positionInList) {
        return list > 0 && getGrid().get(list - 1).get(positionInList).isAlive();
    }

    private boolean upperLeftCellExistsAndIsAlive(int list, int positionInList) {
        return list > 0 && positionInList > 0 && getGrid().get(list - 1).get(positionInList - 1).isAlive();
    }
}
