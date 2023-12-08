package projects.simulation.creatures;

import projects.simulation.Map;
import projects.simulation.Point;
import projects.simulation.abstractEntity.Creature;
//import projects.simulation.entity.Void;

public class Herbivore extends Creature {

    public Herbivore(Point point) {
        super(point);
        this.setSpeed(1);
    }

    @Override
    public String toString() {
        return "\uD83E\uDDA3";
    }

    @Override
    public void makeMove(Map map) {
        if (map.isPointEmpty(this.getPoint())) {

        }
    }
}
