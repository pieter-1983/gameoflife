package be.cegeka.gameoflife;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MapperTest {


    private ArrayList<List<Boolean>> booleanLists;
    private World world;
    private Mapper mapper;

    @Before
    public void setUp() throws Exception {
        mapper= new Mapper();

    }

    @Test
    public void convertNestedListsOfBooleansToWorld() throws Exception {
        booleanLists = new ArrayList<List<Boolean>>();
        booleanLists.add(new ArrayList(Arrays.asList(true, false, true)));
        booleanLists.add(new ArrayList(Arrays.asList(false, false, true)));
        booleanLists.add(new ArrayList(Arrays.asList(true, true, false)));

        world = new World.WorldBuilder().withRows(3).withColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true), new Cell(false), new Cell(true),
                new Cell(false), new Cell(false), new Cell(true),
                new Cell(true), new Cell(true), new Cell(false)))).buildWorld();


    }

    @Test
    public void convertWorldToNestedListsOfBooleans() throws Exception {

    }

}
