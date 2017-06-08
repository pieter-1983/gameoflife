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
    @Inject
    private Mapper mapper;
    private static Logger logger = Logger.getLogger(GameOfLifeController.class);

    @RequestMapping(value = "/world", method = POST)
    @ResponseBody
    public List<List<Boolean>> getWorld(@RequestBody List<List<Boolean>> givenLists) {
        if (givenLists.isEmpty()) {
            return givenLists;
        }
        World givenWorld = mapper.convertNestedListsOfBooleansToWorld(givenLists);
        World nextGenerationWorld = generation.tick(givenWorld);
        return mapper.convertWorldToNestedListsOfBooleans(nextGenerationWorld);
    }
}
