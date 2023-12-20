package projects.simulation.entity.creatures;

import projects.simulation.Cell;
import projects.simulation.Map;
import projects.simulation.entity.abstracts.Creature;
import projects.simulation.entity.props.Grass;
import projects.simulation.exceptions.AlreadyHaveEntityException;

public class Herbivore extends Creature {

    public Herbivore() {
        speed = 1;
        goal.add(Grass.class);
    }

    @Override
    public String toString() {
        return "\uD83E\uDDA3";
    }

    @Override
    public void makeMove(Map map) {
        for (int i = 0; i < speed; i++) {
            Cell prevCell;
            Cell nextCell = map.getNext(this, goal);
            try {
                prevCell = getCell();
                map.setEntity(nextCell, this);
                map.clearCell(prevCell);
            } catch (AlreadyHaveEntityException e) {
                if (goal.contains(map.getEntity(nextCell).getClass())){
                    map.clearCell(nextCell);
                    try {
                        prevCell = getCell();
                        map.setEntity(nextCell, this);
                        map.clearCell(prevCell);
                    } catch (AlreadyHaveEntityException ignore) {
                    }
                }
            }
        }
    }
}
