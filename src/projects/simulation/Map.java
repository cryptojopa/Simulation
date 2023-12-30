package projects.simulation;

import projects.simulation.entity.Empty;
import projects.simulation.entity.abstracts.Creature;
import projects.simulation.entity.abstracts.Entity;
import projects.simulation.enums.Direction;
import projects.simulation.exceptions.AlreadyHaveEntityException;
import projects.simulation.exceptions.OutOfMapException;

import java.util.*;

public class Map {
    private final HashMap<Cell, Entity> map = new HashMap<>();
    private final int maxX;
    private final int maxY;

    protected Map(int n, int m) {
        maxX = n;
        maxY = m;
    }

    public class BFS {
        private final HashMap<Cell, Integer> distance = new HashMap<>();
        private final HashMap<Cell, Cell> prevCell = new HashMap<>();

        Direction[] directions = {Direction.UP, Direction.DOWN, Direction.RIGHT, Direction.LEFT};
        Entity entity;

        public Cell findWayTo(Creature creature, ArrayList<Class<? extends Entity>>  goal) {
            Queue<Cell> queue = new LinkedList<>();
            queue.add(creature.getCell());

            while (!queue.isEmpty()) {
                Cell current = queue.poll();
                entity = getEntity(current);
                if (goal.contains(entity.getClass())) {
                    return reconstructPath(creature.getCell(), current);
                }

                for (Direction direction : directions) {
                    Cell nextCell;
                    try {
                        nextCell = getNextCell(direction, current);
                    } catch (OutOfMapException e) {
                        continue;
                    }

                    if ((isCellEmpty(nextCell) || goal.contains(getEntity(nextCell).getClass())) && distance.get(nextCell) == null) {
                        queue.add(nextCell);

                        try {
                            distance.put(nextCell, distance.get(current) + 1);
                        } catch (NullPointerException e) {
                            distance.put(nextCell, 1);
                        }

                        prevCell.put(nextCell, current);
                    }
                }
            }
            return creature.getCell();
        }

        private Cell reconstructPath(Cell start, Cell end) {
            Cell current = end;
            Cell finalCell = null;

            while (!current.equals(start)) {
                Cell temp = prevCell.get(current);
                if (temp.equals(start)) {
                    finalCell = current;
                }
                current = temp;
            }

            return finalCell;
        }
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public int getCountOfEmptyCells() {
        return maxX * maxY - map.size();
    }

    public boolean haveEntity(Class<? extends Entity> entityClass) {
        return map.values().stream().anyMatch(entityClass::isInstance);
    }

    private void isCellCorrect(Cell cell) throws OutOfMapException {
        if (!(cell.getX() < maxX && cell.getX() >= 0 && cell.getY() < maxY && cell.getY() >= 0)) {
            throw new OutOfMapException();
        }
    }

    public void setEntity(Cell cell, Entity entity) throws AlreadyHaveEntityException, OutOfMapException {
        isCellCorrect(cell);
        if (isCellEmpty(cell)) {
            map.put(cell, entity);
            entity.setCell(cell);
        } else {
            throw new AlreadyHaveEntityException();
        }
    }

    private Cell getNextCell(Direction direction, Cell cell) throws OutOfMapException {
        Cell nextCell = switch (direction) {
            case UP -> new Cell(cell.getX(), cell.getY() - 1);
            case DOWN -> new Cell(cell.getX(), cell.getY() + 1);
            case LEFT -> new Cell(cell.getX() - 1, cell.getY());
            case RIGHT -> new Cell(cell.getX() + 1, cell.getY());
        };
        isCellCorrect(nextCell);
        return nextCell;
    }


    public void clearCell(Cell cell) throws OutOfMapException {
        isCellCorrect(cell);
        map.remove(cell);
    }

    public Entity getEntity(Cell cell) throws OutOfMapException {
        isCellCorrect(cell);
        return isCellEmpty(cell) ? new Empty() : map.get(cell);
    }

    public boolean isCellEmpty(Cell cell) {
        return !map.containsKey(cell);
    }

    public Collection<Entity> getEntities() {
        return map.values();
    }

    public Cell getNext(Creature creature, ArrayList<Class<? extends Entity>> goal) {
        return new BFS().findWayTo(creature, goal);
    }


    public void render() {
        for (int y = 0; y < maxY; y++) {
            for (int x = 0; x < maxX; x++) {
                try {
                    System.out.print(getEntity(new Cell(x, y)) + " ");
                } catch (OutOfMapException ignored) {
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}