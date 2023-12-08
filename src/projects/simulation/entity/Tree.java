package projects.simulation.entity;

import projects.simulation.Point;
import projects.simulation.abstractEntity.Entity;

public class Tree extends Entity {
    public Tree(Point point) {
        super(point);
    }

    @Override
    public String toString() {
        return "\uD83C\uDF33";
//        return "\uD83D\uDFE7";
    }

    @Override
    public boolean isResource() {
        return false;
    }
}
