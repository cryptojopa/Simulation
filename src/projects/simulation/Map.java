package projects.simulation;

import projects.simulation.entity.Empty;
import projects.simulation.entity.abstracts.Creature;
import projects.simulation.entity.abstracts.Entity;
import projects.simulation.enums.Direction;
import projects.simulation.exceptions.AlreadyHaveEntityException;

import java.util.HashMap;
//import projects.simulation.entity.Void;

public class Map {
    private HashMap<Cell, Entity> map = new HashMap<>();
    private int maxX;
    private int maxY;

    protected Map(int n, int m) {
        maxX = n;
        maxY = m;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    private boolean isCellCorrect(Cell cell) {
        return cell.getX() < maxX && cell.getX() >= 0 && cell.getY() < maxY && cell.getY() >= 0;
    }

    public void setEntity(Cell cell, Entity entity) throws AlreadyHaveEntityException {
        if (isCellCorrect(cell)) {
            if (isCellEmpty(cell)) {
                map.put(cell, entity);
            } else {
                throw new AlreadyHaveEntityException();
            }
        }
    }

    public Cell nextPoint(Direction direction, Creature creature) {
        return switch (direction) {
            case UP -> new Cell(creature.getX(), creature.getY() - 1);
            case DOWN -> new Cell(creature.getX(), creature.getY() + 1);
            case LEFT -> new Cell(creature.getX() - 1, creature.getY());
            case RIGHT -> new Cell(creature.getX() + 1, creature.getY());
        };
    }

    public int getCountOfEmptyCells() {
        return maxX * maxY - map.size();
    }

    public void clearCell(Cell cell) {
        if (isCellCorrect(cell)) {
            map.remove(cell);
        }
    }

    public Entity getEntity(Cell cell) {
        isCellCorrect(cell);
        if (isCellEmpty(cell)) {
            return new Empty();
        } else {
            return map.get(cell);
        }
    }

    public boolean isCellEmpty(Cell cell) {
        return !map.containsKey(cell);
    }

    public void render() {
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                System.out.print(getEntity(new Cell(x, y)) + " ");
            }
            System.out.println();
        }
    }
}