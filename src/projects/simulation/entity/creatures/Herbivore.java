package projects.simulation.entity.creatures;

import projects.simulation.Map;
import projects.simulation.Cell;
import projects.simulation.entity.abstracts.Creature;
import projects.simulation.entity.props.Grass;
import projects.simulation.enums.Direction;
import projects.simulation.exceptions.AlreadyHaveEntityException;
//import projects.simulation.entity.Void;

public class Herbivore extends Creature {

//    public Herbivore(Cell cell) {
//        super(cell);
//        this.setSpeed(1);
//    }

    public Herbivore() {
    }

    @Override
    public String toString() {
        return "\uD83E\uDDA3";
    }

    @Override
    public void makeMove(Map map) {
        Cell nextCell = map.findNExt(this, new Grass());
//        Cell nextCell = map.nextCell(Direction.RIGHT, getCell());
        try {
            map.clearCell(getCell());
            map.setEntity(nextCell, this);
        } catch (AlreadyHaveEntityException e) {
            if (map.getEntity(nextCell) instanceof Grass) {
                map.clearCell(nextCell);
                try {
                    map.setEntity(nextCell, this);
                } catch (AlreadyHaveEntityException ignore) {
                }
            }
        }
    }
}
