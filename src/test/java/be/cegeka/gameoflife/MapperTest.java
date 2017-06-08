package be.cegeka.gameoflife;

import com.sun.org.apache.xerces.internal.util.PropertyState;
import org.assertj.core.api.Assertions;
import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.core.Every.everyItem;
import static org.junit.Assert.*;

public class MapperTest {


    private ArrayList<List<Boolean>> booleanLists;
    private World world;
    private Mapper mapper;

    @Before
    public void setUp() throws Exception {
        mapper = new Mapper();
    }

    @Test
    public void convertNestedListsOfBooleansToWorld_returnsWorldWithTheSameValuesAndSizesAsTheLists() throws Exception {
        booleanLists = new ArrayList<List<Boolean>>();
        booleanLists.add(new ArrayList(Arrays.asList(true, false, true)));
        booleanLists.add(new ArrayList(Arrays.asList(false, false, true)));
        booleanLists.add(new ArrayList(Arrays.asList(true, true, false)));

        world = new World.WorldBuilder().withRows(3).withColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true), new Cell(false), new Cell(true),
                new Cell(false), new Cell(false), new Cell(true),
                new Cell(true), new Cell(true), new Cell(false)))).buildWorld();
        Assertions.assertThat(mapper.convertNestedListsOfBooleansToWorld(booleanLists)).isEqualTo(world);

    }

    @Test
    public void convertWorldToNestedListsOfBooleans_returnsBooleanListsWithTheSameValuesAndSizesAsTheWorldObject() throws Exception {
        booleanLists = new ArrayList<List<Boolean>>();
        booleanLists.add(new ArrayList(Arrays.asList(true, false, true)));
        booleanLists.add(new ArrayList(Arrays.asList(false, false, true)));
        booleanLists.add(new ArrayList(Arrays.asList(true, true, false)));

        world = new World.WorldBuilder().withRows(3).withColumns(3).withCells(new ArrayList<Cell>(Arrays.asList
            (new Cell(true), new Cell(false), new Cell(true),
                new Cell(false), new Cell(false), new Cell(true),
                new Cell(true), new Cell(true), new Cell(false)))).buildWorld();
        Assertions.assertThat(mapper.convertWorldToNestedListsOfBooleans(world)).isEqualTo(booleanLists);

    }

}
