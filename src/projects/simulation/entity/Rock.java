package projects.simulation.entity;

import projects.simulation.Point;
import projects.simulation.abstractEntity.Entity;

public class Rock extends Entity {
    public Rock(Point point) {
        super(point);
    }

    @Override
    public String toString() {
        return "\uD83D\uDDFF";
//        return "\uD83D\uDFE6";
    }

    @Override
    public boolean isResource() {
        return false;
    }
}
