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
        int sizeOfList= newGeneration.getGrid().size();
        for (int list = 0; list < sizeOfList; list++) {
            List<Boolean> booleanList = new ArrayList<>();
            for (int positionInList = 0; positionInList < sizeOfList; positionInList++) {
                Boolean aBoolean = newGeneration.getGrid().get(list).get(positionInList).isAlive();
                booleanList.add(aBoolean);
            }
            returnWorld.add(booleanList);
        }
        return returnWorld;
    }

    private World makeNewWorldByTheRules(World world) {
        List<List<Cell>> grid = world.getGrid();
        int listSize = grid.get(0).size();
        int amountOfCells = listSize * listSize;
        Cell[] nextGenerationOfCells = new Cell[amountOfCells];
        int index = 0;
        for (int list = 0; list < listSize; list++) {
            for (int listPosition = 0; listPosition < listSize; listPosition++) {
                int numberOfAliveNeighbours = world.getNumberOfAliveNeighbours(list, listPosition);
                Cell cell = grid.get(list).get(listPosition);
                Cell nextGenerationCell = new Cell(rulesForNextGeneration(cell, numberOfAliveNeighbours));
                nextGenerationOfCells[index] = nextGenerationCell;
                index++;
            }
        }
        return new World(listSize, nextGenerationOfCells);
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
        Cell[] cells = createCellArrayFromNestedBooleanLists(currentWorld);
        return new World(currentWorld.size(), cells);
    }

    private Cell[] createCellArrayFromNestedBooleanLists(List<List<Boolean>> currentWorld) {
        Cell[] cells = new Cell[currentWorld.size() * currentWorld.size()];
        int index = 0;
        for (List<Boolean> booleanList :
            currentWorld) {
            for (Boolean aboolean :
                booleanList) {
                Cell cell = new Cell(aboolean);
                cells[index] = cell;
                index++;
            }
        }
        return cells;
    }
}
