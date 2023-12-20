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
                for (int i = 0; i < creature.getSpeed(); i++) {
                    creature.makeMove(map);
//                    map.render();
////                    System.out.println();
//                    try {
//                        Thread.sleep(1500);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                }
            }
        });
    }
}
