package projects.simulation.enums;

import java.util.Random;

public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    private static final Random PRNG = new Random();

    public static Direction randomDirection() {
        Direction[] directions = values();
        return directions[PRNG.nextInt(directions.length)];
    }
}