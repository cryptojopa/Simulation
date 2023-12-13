package projects.simulation.entity.abstracts;

import projects.simulation.Map;
import projects.simulation.Cell;
import projects.simulation.enums.Direction;

public abstract class Creature extends Entity {
    private int speed;
    private int hp = 100;

//    public Creature(Cell cell) {
//        super(cell);
//    }

    protected Creature() {
    }

    public abstract void makeMove(Map map);

    public int getHp() {
        return hp;
    }

    public int getSpeed() {
        return speed;
    }

    protected void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
