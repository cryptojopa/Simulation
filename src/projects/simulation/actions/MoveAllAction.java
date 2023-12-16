package projects.simulation.actions;

import projects.simulation.Map;
import projects.simulation.actions.Action;
import projects.simulation.entity.abstracts.Creature;
import projects.simulation.entity.abstracts.Entity;

import java.util.ArrayList;
import java.util.List;


public class MoveAllAction extends Action {
    @Override
    public void makeAction(Map map) {
        ArrayList<Entity> entities = new ArrayList<>(map.getEntities());
        for (Entity entity: entities) {
            if (entity instanceof Creature) {
                for (int i = 0; i < ((Creature) entity).getSpeed(); i++)
                {
                    ((Creature) entity).makeMove(map);
                }

            }
        }
    }
}
