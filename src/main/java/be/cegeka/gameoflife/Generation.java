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

    private World convertNestedListsOfBooleansToWorld(List<List<Boolean>> nestedBooleanLists) {
        ArrayList<Cell> cells = new ArrayList<>();
        for (List<Boolean> booleanList : nestedBooleanLists) {
            for (Boolean aboolean : booleanList) {
                Cell cell = new Cell(aboolean);
                cells.add(cell);
            }
        }
        return new World.WorldBuilder().withRows(nestedBooleanLists.size()).withColumns(nestedBooleanLists.get(0).size()).withCells(cells).buildWorld();
    }

    private List<List<Boolean>> convertWorldToNestedListsOfBooleans(World newGeneration) {
        List<List<Boolean>> returnWorld = new ArrayList<List<Boolean>>();
        int rows = newGeneration.getNumberOfRows();
        int columns = newGeneration.getNumberOfColumns();
        for (int row = 0; row < rows; row++) {
            List<Boolean> booleanList = new ArrayList<>();
            for (int colum = 0; colum < columns; colum++) {
                Boolean aBoolean = newGeneration.getCell(row, colum).isAlive();
                booleanList.add(aBoolean);
            }
            returnWorld.add(booleanList);
        }
        return returnWorld;
    }

    private World makeNewWorldByTheRules(World world) {
        int rows = world.getNumberOfRows();
        int columns = world.getNumberOfColumns();
        ArrayList<Cell> nextGenerationOfCells = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                int numberOfAliveNeighbours = world.getNumberOfAliveNeighbours(row, column);
                Cell cell = world.getCell(row, column);
                Cell nextGenerationCell = new Cell(rulesForNextGeneration(cell, numberOfAliveNeighbours));
                nextGenerationOfCells.add(nextGenerationCell);
            }
        }
        return new World.WorldBuilder().withRows(rows).withColumns(columns).withCells(nextGenerationOfCells).buildWorld();
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

}
