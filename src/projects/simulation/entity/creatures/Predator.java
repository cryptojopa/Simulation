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

    public void attack(Creature creature) {
        creature.setHp(creature.getHp() - attackPower);
    }

    @Override
    public void makeMove(Map map) {
//        for (int i = 0; i < speed; i++) {
            Cell prevCell;
            Cell nextCell = map.getNext(this, goal);
            try {
                prevCell = getCell();
                map.setEntity(nextCell, this);
                map.clearCell(prevCell);
            } catch (AlreadyHaveEntityException e) {
                Creature nextCreature = (Creature) map.getEntity(nextCell);
                if (goal.contains(nextCreature.getClass())) {
                    prevCell = getCell();
                    attack(nextCreature);
                    if (nextCreature.getHp() <= 0) {
                        try {
                            map.clearCell(nextCell);
                            map.setEntity(nextCell, this);
                            map.clearCell(prevCell);
                        } catch (AlreadyHaveEntityException ignore) {
                        }
                    }

                }
            }
//        }
    }

    @Override
    protected void doStep() {

    }

    @Override
    public String toString() {
        return "\uD83D\uDC3A";
    }


}
