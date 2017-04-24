package be.cegeka.gameoflife;

import org.junit.Test;

import java.util.Arrays;

import static be.cegeka.gameoflife.Cell.dead;
import static org.assertj.core.api.Assertions.assertThat;

public class GenerationTest {

    @Test
    public void getLiveNeighbours_NoCellAtPosition_ReturnsEmptyList() throws Exception {
        Generation generationWithOneCell = Generation.of(Arrays.asList(dead()));
        assertThat(generationWithOneCell.getLiveNeighbours(0,1)).isEmpty();
    }

    @Test
    public void getLiveNeighbours_CellAtPositionHasLiveNeighbours_ReturnsAllLiveNeighbours() throws Exception {

    }

    @Test
    public void getLiveNeighbours_CellAtPositionHasOnlyDeadNeighbours_ReturnsEmptyList() throws Exception {

    }
}