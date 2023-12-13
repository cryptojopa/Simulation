package projects.simulation.entity.abstracts;

import projects.simulation.Cell;

public abstract class Prop extends Entity {
//    public Prop(Cell cell) {
//        super(cell);
//    }

    protected Prop() {

    }

    public abstract boolean isResource();
}
