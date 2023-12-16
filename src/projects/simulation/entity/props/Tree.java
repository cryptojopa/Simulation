package projects.simulation.entity.props;

import projects.simulation.Cell;
import projects.simulation.entity.abstracts.Entity;
import projects.simulation.entity.abstracts.Prop;

public class Tree extends Prop {

    public Tree() {
    }

    @Override
    public String toString() {
        return "\uD83C\uDF33";
    }

    @Override
    public boolean isResource() {
        return false;
    }
}
