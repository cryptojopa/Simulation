package projects.simulation.entity.creatures;

import projects.simulation.Map;
import projects.simulation.Cell;
import projects.simulation.entity.abstracts.Creature;

public class Predator extends Creature {
    private int attackPower;

    public Predator(Cell cell) {
        super(cell);
        this.setSpeed(2);
    }

    public Predator() {
    }

    public void attack(Herbivore herbivore) {
        herbivore.setHp(herbivore.getHp() - attackPower);
    }

    @Override
    public void makeMove(Map map) {
    }

    @Override
    public String toString() {
        return "\uD83D\uDC3A";
    }


}
