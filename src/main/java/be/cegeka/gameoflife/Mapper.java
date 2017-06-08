package be.cegeka.gameoflife;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class Mapper {

    World convertNestedListsOfBooleansToWorld(List<List<Boolean>> booleanLists) {
        ArrayList<Cell> cells = new ArrayList<>();
        for (List<Boolean> booleanList : booleanLists) {
            for (Boolean aboolean : booleanList) {
                int row = booleanLists.indexOf(booleanList);
                int column = booleanList.indexOf(aboolean);
                Cell cell = new Cell(aboolean, row, column);
                cells.add(cell);
            }
        }
        return new World.WorldBuilder().withRows(booleanLists.size()).withColumns(booleanLists.get(0).size()).withCells(cells).buildWorld();
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
