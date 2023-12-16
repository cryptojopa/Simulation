package projects.simulation.entity.creatures;

import projects.simulation.Map;
import projects.simulation.Cell;
import projects.simulation.entity.abstracts.Creature;
import projects.simulation.entity.abstracts.Entity;
import projects.simulation.exceptions.AlreadyHaveEntityException;

public class Predator extends Creature {
    private final int attackPower;

    public Predator() {
        speed = 2;
        goal.add(Herbivore.class);
        attackPower = 50;
    }

    public void attack(Herbivore herbivore) {
        herbivore.setHp(herbivore.getHp() - attackPower);
    }

    @Override
    public void makeMove(Map map) {
        Cell nextCell = map.getNext(this, goal);
        try {
            map.clearCell(getCell());
            map.setEntity(nextCell, this);
        } catch (AlreadyHaveEntityException e) {
            if (goal.contains(map.getEntity(nextCell).getClass())) {
                map.clearCell(nextCell);
                try {
                    map.setEntity(nextCell, this);
                } catch (AlreadyHaveEntityException ignore) {
                }
            }
        }
    }

    @Override
    protected void doStep() {

    }

    @Override
    public String toString() {
        return "\uD83D\uDC3A";
    }


}
