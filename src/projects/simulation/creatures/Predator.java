package projects.simulation.creatures;

import projects.simulation.Map;
import projects.simulation.Point;
import projects.simulation.abstractEntity.Creature;

public class Predator extends Creature {
    private int attackPower;

    public Predator(Point point) {
        super(point);
        this.setSpeed(2);
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
