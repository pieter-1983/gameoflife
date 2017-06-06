package be.cegeka.gameoflife;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class Generation {
    public List<List<Boolean>> tick(List<List<Boolean>> nestedListsOfBooleans) {
        World convertedWorld = convertNestedListsOfBooleansToWorld(nestedListsOfBooleans);
        World nextWorld = makeNewWorldByTheRules(convertedWorld);
        List<List<Boolean>> returnWorld = convertWorldToNestedListsOfBooleans(nextWorld);
        return returnWorld;
    }

    private List<List<Boolean>> convertWorldToNestedListsOfBooleans(World newGeneration) {
        List<List<Boolean>> returnWorld = new ArrayList<List<Boolean>>();
        int rows = newGeneration.getGrid().size();
        int columns = newGeneration.getGrid().get(0).size();
        for (int row = 0; row < rows; row++) {
            List<Boolean> booleanList = new ArrayList<>();
            for (int colum = 0; colum < columns; colum++) {
                Boolean aBoolean = newGeneration.getGrid().get(row).get(colum).isAlive();
                booleanList.add(aBoolean);
            }
            returnWorld.add(booleanList);
        }
        return returnWorld;
    }

    private World makeNewWorldByTheRules(World world) {
        List<List<Cell>> grid = world.getGrid();
        int rows= grid.size();
        int columns = grid.get(0).size();
        int amountOfCells = columns * columns;
        ArrayList<Cell> nextGenerationOfCells = new ArrayList<>();
        int index = 0;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int numberOfAliveNeighbours = world.getNumberOfAliveNeighbours(row, column);
                Cell cell = grid.get(row).get(column);
                Cell nextGenerationCell = new Cell(rulesForNextGeneration(cell, numberOfAliveNeighbours));
                nextGenerationOfCells.add(nextGenerationCell);
                index++;
            }
        }
        return new World(rows, columns, nextGenerationOfCells);
    }

    private boolean rulesForNextGeneration(Cell cell, int numberOfAliveNeighbours) {
        if (aLiveCellHasLessThanTwoNeighbours(cell, numberOfAliveNeighbours)) {
            return false;
        }
        if (aLiveCellHasTwoOrThreeNeighbours(cell, numberOfAliveNeighbours)) {
            return true;
        }
        if (aLiveCellHasMoreThanThreeNeighbours(cell, numberOfAliveNeighbours)) {
            return false;
        }
        if (aDeadCellHasThreeNeighbours(cell, numberOfAliveNeighbours)) {
            return true;
        }
        return false;
    }

    private boolean aDeadCellHasThreeNeighbours(Cell cell, int numberOfAliveNeighbours) {
        return !cell.isAlive() && numberOfAliveNeighbours == 3;
    }

    private boolean aLiveCellHasMoreThanThreeNeighbours(Cell cell, int numberOfAliveNeighbours) {
        return cell.isAlive() && numberOfAliveNeighbours > 3;
    }

    private boolean aLiveCellHasTwoOrThreeNeighbours(Cell cell, int numberOfAliveNeighbours) {
        return cell.isAlive() && (numberOfAliveNeighbours > 1 && numberOfAliveNeighbours < 4);
    }

    private boolean aLiveCellHasLessThanTwoNeighbours(Cell cell, int numberOfAliveNeighbours) {
        return cell.isAlive() && numberOfAliveNeighbours < 2;
    }

    World convertNestedListsOfBooleansToWorld(List<List<Boolean>> currentWorld) {
        ArrayList<Cell> cells = createCellListFromNestedBooleanLists(currentWorld);
        return new World(currentWorld.size(), currentWorld.get(0).size(), cells);
    }

    private ArrayList<Cell> createCellListFromNestedBooleanLists(List<List<Boolean>> currentWorld) {
        ArrayList<Cell> cells = new ArrayList<>();
        for (List<Boolean> booleanList :
            currentWorld) {
            for (Boolean aboolean :
                booleanList) {
                Cell cell = new Cell(aboolean);
                cells.add(cell);
            }
        }
        return cells;
    }
}
