package projects.simulation.entity.props;

import projects.simulation.Cell;
import projects.simulation.entity.abstracts.Entity;
import projects.simulation.entity.abstracts.Prop;

public class Rock extends Prop {
    public Rock() {
    }

    @Override
    public String toString() {
        return "\uD83D\uDDFF";
    }

    @Override
    public boolean isResource() {
        return false;
    }
}
