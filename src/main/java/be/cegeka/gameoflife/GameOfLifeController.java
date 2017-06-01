package be.cegeka.gameoflife;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/gameoflife")
public class GameOfLifeController {
    @Inject
    private Generation generation;
    private static Logger logger = Logger.getLogger(GameOfLifeController.class);

    @RequestMapping(value = "/world", method = POST)
    @ResponseBody
    public List<List<Boolean>> getWorld(@RequestBody List<List<Boolean>> currentWorld) {
        if (currentWorld.isEmpty()){
            return currentWorld;
        }
        World convertedWorld = createWorldFromNestedBooleanLists(currentWorld);
        List<List<Boolean>> nextWorld = generation.tick(convertedWorld);
        return nextWorld;
    }

    private World createWorldFromNestedBooleanLists(List<List<Boolean>> currentWorld) {
        Cell[] cells = createCellArrayFromNestedBooleanLists(currentWorld);
        return new World(currentWorld.size(), cells);
    }

    private Cell[] createCellArrayFromNestedBooleanLists(List<List<Boolean>> currentWorld) {
        Cell[] cells = new Cell[currentWorld.size() * currentWorld.size()];
        int index = 0;
        for (List<Boolean> booleanList :
            currentWorld) {
            for (Boolean aboolean :
                booleanList) {
                Cell cell = new Cell(aboolean);
                cells[index] = cell;
                index++;
            }
        }
        return cells;
    }

}
