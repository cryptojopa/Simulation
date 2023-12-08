package projects.simulation.actions;

import projects.simulation.Map;
import projects.simulation.abstractEntity.Actions;
import projects.simulation.abstractEntity.Creature;
import projects.simulation.abstractEntity.Entity;
import projects.simulation.creatures.Herbivore;

public class MoveAllAction extends Actions {
    @Override
    public void makeAction(Map map) {
        for (int y = 0; y< map.getMaxY(); y++) {
            for (int x = 0; x < map.getLine(y).length; x++ ) {
                Entity entity = map.getObject(x, y);
                if (entity instanceof Creature) {
                    try {
                        ((Creature) entity).makeMove(map);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        continue;
                    }
                }
            }
        }
    }
}
