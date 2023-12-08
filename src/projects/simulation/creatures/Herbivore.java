package projects.simulation.creatures;

import projects.simulation.Map;
import projects.simulation.Point;
import projects.simulation.abstractEntity.Creature;
import projects.simulation.enums.Direction;
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
        Point nextPoint = nextPoint(Direction.RIGHT);
        if (map.isPointEmpty(nextPoint)) {
            map.removeEntity(getPoint());
            map.setEntity(nextPoint, this);
            setPoint(nextPoint);

        }
    }
}
