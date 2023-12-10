package projects.simulation.entity.props;

import projects.simulation.Cell;
import projects.simulation.entity.abstracts.Entity;
import projects.simulation.entity.abstracts.Prop;

public class Grass extends Prop {
    public Grass(Cell cell) {
        super(cell);
    }

    public Grass() {
    }

    @Override
    public boolean isResource() {
        return false;
    }

    @Override
    public String toString() {
        return "\uD83C\uDF3F";
//        return "\uD83D\uDFE5";
    }
}
