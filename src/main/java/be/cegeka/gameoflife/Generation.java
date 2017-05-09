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
                int numberfAliveNeighbours = world.getNumberOfAliveNeighbours(list, listPosition);
                Cell cell = grid.get(list).get(listPosition);
                Cell nextGenerationCell = new Cell(rulesForNextGeneration(cell, numberfAliveNeighbours));
                nextGenerationOfCells[index] = nextGenerationCell;
                index++;
            }
        }
        return new World(listSize, nextGenerationOfCells);
    }

    private boolean rulesForNextGeneration(Cell cell, int numberfAliveNeighbours) {
        if (cell.isAlive() && numberfAliveNeighbours < 2) {
            return false;
        }
        if (cell.isAlive() && (numberfAliveNeighbours > 1 && numberfAliveNeighbours < 4)) {
            return true;
        }
        if (cell.isAlive() && numberfAliveNeighbours > 3) {
            return false;
        }
        if (!cell.isAlive() && numberfAliveNeighbours == 3) {
            return true;
        }
        return false;
    }
}
