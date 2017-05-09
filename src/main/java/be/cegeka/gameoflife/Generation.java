package be.cegeka.gameoflife;

import java.util.List;

public class Generation {
    public World tick(World world) {
        World newGeneration = makeNewWorldByTheRules(world);
        return newGeneration;
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
}
