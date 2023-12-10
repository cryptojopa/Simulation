package projects.simulation.entity.props;

import projects.simulation.Cell;
import projects.simulation.entity.abstracts.Entity;
import projects.simulation.entity.abstracts.Prop;

public class Tree extends Prop {
    public Tree(Cell cell) {
        super(cell);
    }

    public Tree() {
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
