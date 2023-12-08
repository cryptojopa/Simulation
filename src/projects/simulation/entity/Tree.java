package projects.simulation.entity;

import projects.simulation.abstractEntity.Entity;

public class Tree extends Entity {
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
