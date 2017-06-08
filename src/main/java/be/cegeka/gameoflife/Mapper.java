package be.cegeka.gameoflife;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class Mapper {

    World convertNestedListsOfBooleansToWorld(List<List<Boolean>> booleanLists) {
        ArrayList<Cell> cells = new ArrayList<>();
        for (int row = 0; row < booleanLists.size(); row++) {
            for (int column = 0; column < booleanLists.get(0).size(); column++) {
                Boolean aBoolean = booleanLists.get(row).get(column);
                Cell cell = new Cell(aBoolean, row, column);
                cells.add(cell);
            }
        }
        return new World.WorldBuilder().withNumberOfRows(booleanLists.size()).withNumberColumns(booleanLists.get(0).size()).withCells(cells).buildWorld();
    }

    List<List<Boolean>> convertWorldToNestedListsOfBooleans(World world) {
        List<List<Boolean>> returnWorld = new ArrayList<List<Boolean>>();
        int rows = world.getNumberOfRows();
        int columns = world.getNumberOfColumns();
        for (int row = 0; row < rows; row++) {
            List<Boolean> booleanList = new ArrayList<>();
            for (int colum = 0; colum < columns; colum++) {
                Boolean aBoolean = world.getCell(row, colum).isAlive();
                booleanList.add(aBoolean);
            }
            returnWorld.add(booleanList);
        }
        return returnWorld;
    }
}
