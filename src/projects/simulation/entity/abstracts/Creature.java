package projects.simulation.entity.abstracts;

import projects.simulation.Map;
import java.util.ArrayList;

public abstract class Creature extends Entity {
    protected int speed;
    protected int hp = 100;
    protected ArrayList<Class<? extends Entity>> goal = new ArrayList<>();

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
