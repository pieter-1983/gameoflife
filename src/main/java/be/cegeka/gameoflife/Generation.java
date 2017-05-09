package be.cegeka.gameoflife;

import java.util.List;

public class Generation {
    public World tick(World world) {
        World newGeneration = makeNewWorldByTheRules(world);
        return newGeneration;
    }

    private World makeNewWorldByTheRules(World world) {
        List<List<Cell>> grid = world.getGrid();
        int rowSize = grid.get(0).size();
        int amountOfCells = rowSize * rowSize;
        Cell[] nextGenerationOfCells = new Cell[amountOfCells];
        int index = 0;
        for (int row = 0; row < rowSize; row++) {
            for (int column = 0; column < rowSize; column++) {
                int numberfAliveNeighbours = world.getNumberOfAliveNeighbours(row, column);
                Cell cell = grid.get(row).get(column);
                Cell nextGenerationCell = new Cell(rulesForNextGeneration(cell, numberfAliveNeighbours));
                nextGenerationOfCells[index] = nextGenerationCell;
                index++;
            }
        }
        return new World(rowSize, nextGenerationOfCells);
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
