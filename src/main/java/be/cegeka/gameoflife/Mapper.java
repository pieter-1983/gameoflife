package be.cegeka.gameoflife;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class Mapper {

    World convertNestedListsOfBooleansToWorld(List<List<Boolean>> nestedBooleanLists) {
        ArrayList<Cell> cells = new ArrayList<>();
        for (List<Boolean> booleanList : nestedBooleanLists) {
            for (Boolean aboolean : booleanList) {
                Cell cell = new Cell(aboolean);
                cells.add(cell);
            }
        }
        return new World.WorldBuilder().withRows(nestedBooleanLists.size()).withColumns(nestedBooleanLists.get(0).size()).withCells(cells).buildWorld();
    }

    List<List<Boolean>> convertWorldToNestedListsOfBooleans(World newGeneration) {
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
}
