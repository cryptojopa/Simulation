package projects.simulation.entity;

import projects.simulation.abstractEntity.Entity;

public class Grass extends Entity {
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
