package projects.simulation.entity;

import projects.simulation.Point;
import projects.simulation.abstractEntity.Entity;

public class Grass extends Entity {
    public Grass(Point point) {
        super(point);
    }

    @Override
    public String toString() {
        return "\uD83C\uDF3F";
//        return "\uD83D\uDFE5";
    }

    @Override
    public boolean isResource() {
        return true;
    }
}
