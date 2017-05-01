package be.cegeka.gameoflife;

public class Grid {
    private boolean[][] grid;
    private int rowAndColumAmmount;

    public Grid(int rowAndColumAmmount) {
        this.rowAndColumAmmount = rowAndColumAmmount;
        this.grid = new boolean[rowAndColumAmmount][rowAndColumAmmount];
    }

    public boolean[][] getGrid() {
        return grid;
    }

    public void populate(boolean... cellStates) {
        int indexOfCellStates = 0;
        for (int row = 0; row < rowAndColumAmmount; row++) {
            for (int column = 0; column < rowAndColumAmmount; column++) {
                grid[row][column] = cellStates[indexOfCellStates];
                indexOfCellStates++;
            }
        }


    }

}
