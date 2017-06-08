package be.cegeka.gameoflife;

public class Cell {
    private boolean state;
    private int row;
    private int column;

    public Cell(boolean state, int row, int column) {
        this.state = state;
        this.row = row;
        this.column = column;
    }
    public int getNumberOfAliveNeighbours(World world) {
        int numberOfAliveNeighbours = 0;
        if (upperLeftCellExistsAndIsAlive(world)) {
            numberOfAliveNeighbours += 1;
        }
        if (upperCellExistsAndIsAlive(world)) {
            numberOfAliveNeighbours += 1;
        }
        if (upperRightCellExistsAndIsAlive(world)) {
            numberOfAliveNeighbours += 1;
        }
        if (leftCellExistsAndIsAlive(world)) {
            numberOfAliveNeighbours += 1;
        }
        if (rightCellExistsAndIsAlive(world)) {
            numberOfAliveNeighbours += 1;
        }
        if (bottomLeftCellExistsAndIsAlive(world)) {
            numberOfAliveNeighbours += 1;
        }
        if (bottomCellExistsAndIsAlive(world)) {
            numberOfAliveNeighbours += 1;
        }
        if (bottomRightCellExistsAndIsAlive(world)) {
            numberOfAliveNeighbours += 1;
        }
        return numberOfAliveNeighbours;
    }

    private boolean upperLeftCellExistsAndIsAlive(World world) {
        return row > 0 && column > 0 && world.getCell(row - 1,column-1).isAlive();
    }

    private boolean upperCellExistsAndIsAlive(World world) {
        return row > 0 && world.getCell(row - 1,column).isAlive();
    }

    private boolean upperRightCellExistsAndIsAlive(World world) {
        return row > 0 && column != world.getNumberOfColumns() - 1 && world.getCell(row-1,column+1).isAlive();
    }

    private boolean leftCellExistsAndIsAlive(World world) {
        return column > 0 && world.getCell(row,column-1).isAlive();
    }

    private boolean rightCellExistsAndIsAlive(World world) {
        return column != world.getNumberOfColumns() - 1 && world.getCell(row,column+1).isAlive();
    }

    private boolean bottomLeftCellExistsAndIsAlive(World world) {
        return column > 0 && row != world.getNumberOfRows() - 1 && world.getCell(row + 1,column-1).isAlive();
    }

    private boolean bottomCellExistsAndIsAlive(World world) {
        return row != world.getNumberOfRows() - 1 && world.getCell(row + 1,column).isAlive();
    }

    private boolean bottomRightCellExistsAndIsAlive(World world) {
        return row != world.getNumberOfRows() - 1 && column != world.getNumberOfColumns() - 1 && world.getCell(row + 1,column+1).isAlive();
    }

    public boolean isAlive() {
        return state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        return state == cell.state;
    }

    @Override
    public int hashCode() {
        return (state ? 1 : 0);
    }
}
