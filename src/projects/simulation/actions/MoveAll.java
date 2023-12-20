package projects.simulation.actions;

import projects.simulation.Map;
import projects.simulation.entity.abstracts.Creature;
import projects.simulation.entity.abstracts.Entity;

import java.util.ArrayList;
import java.util.List;


public class MoveAll extends Action {
    @Override
    public void makeAction(Map map) {
        List<Entity> entities = new ArrayList<>(map.getEntities());
        entities.forEach(entity -> {
            if (entity instanceof Creature creature) {
                if (creature.getHp() <= 0) {
                    return;
                }
                creature.makeMove(map);
            }
        });
    }
}
