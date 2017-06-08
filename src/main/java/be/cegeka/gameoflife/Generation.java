package be.cegeka.gameoflife;

import javax.inject.Named;
import java.util.ArrayList;

@Named
public class Generation {

    public World tick(World world) {
        World nextWorld = makeNewWorldByTheRules(world);
        return nextWorld;
    }

    private World makeNewWorldByTheRules(World world) {
        int rows = world.getNumberOfRows();
        int columns = world.getNumberOfColumns();
        ArrayList<Cell> nextGenerationOfCells = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                Cell cell = world.getCell(row, column);
                int numberOfAliveNeighbours = cell.getNumberOfAliveNeighbours(world);
                Cell nextGenerationCell = new Cell(rulesForNextGeneration(cell, numberOfAliveNeighbours), row, column);
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
