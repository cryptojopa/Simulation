package projects.simulation;

import projects.simulation.entity.Empty;
import projects.simulation.entity.abstracts.Creature;
import projects.simulation.entity.abstracts.Entity;
import projects.simulation.entity.abstracts.Prop;
import projects.simulation.entity.props.Grass;
import projects.simulation.enums.Direction;
import projects.simulation.exceptions.AlreadyHaveEntityException;
import projects.simulation.exceptions.OutOfMapException;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
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

    private boolean isCellCorrect(Cell cell) throws OutOfMapException {
        if (!(cell.getX() < maxX && cell.getX() >= 0 && cell.getY() < maxY && cell.getY() >= 0)){
            throw new OutOfMapException();
        }
        return true;
    }

    public void setEntity(Cell cell, Entity entity) throws AlreadyHaveEntityException, OutOfMapException {
        if (isCellCorrect(cell)) {
            if (isCellEmpty(cell)) {
                map.put(cell, entity);
                entity.setCell(cell);
            } else {
                throw new AlreadyHaveEntityException();
            }
        }
    }

    public Cell nextCell (Direction direction, Cell cell) {
        Cell nextCell = switch (direction) {
            case UP -> new Cell(cell.getX(), cell.getY() - 1);
            case DOWN -> new Cell(cell.getX(), cell.getY() + 1);
            case LEFT -> new Cell(cell.getX() - 1, cell.getY());
            case RIGHT -> new Cell(cell.getX() + 1, cell.getY());
        };
        isCellCorrect(nextCell);
        return nextCell;
    }

    public int getCountOfEmptyCells() {
        return maxX * maxY - map.size();
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

    public Cell findNExt(Creature creature, Prop goal) {
        return new BFS().bFS(creature, goal);
    }

    public class BFS {
        private int[][] distance = new int[maxX][maxY];

        private int[][] prevX = new int[maxX][maxY];
        private int[][] prevY = new int[maxX][maxY];

        Entity entity;

        public Cell bFS(Creature creature, Prop goal) {
            Queue<Cell> queue = new LinkedList<>();
            queue.add(creature.getCell());

            while (!queue.isEmpty()) {
                Cell current = queue.poll();

                entity = getEntity(current);
                if (getEntity(current) instanceof Grass) {
                    // Восстановление кратчайшего пути
                    return reconstructPath(creature.getCell(), current);
                }

                Direction[] directions = new Direction[] {Direction.UP, Direction.DOWN, Direction.RIGHT, Direction.LEFT};

                for (int i = 0; i < 4; i++) {
                    Cell nextCell;
                    try {
                        nextCell = nextCell(directions[i], current);
                    } catch (OutOfMapException e) {
                        continue;
                    }

                    if ((isCellEmpty(nextCell) || getEntity(nextCell) instanceof Grass) && distance[nextCell.getX()][nextCell.getY()] == 0) {
                        queue.add(nextCell);
                        distance[nextCell.getX()][nextCell.getY()] = distance[nextCell.getY()][nextCell.getX()] + 1;
                        prevX[nextCell.getX()][nextCell.getY()] = current.getX();
                        prevY[nextCell.getX()][nextCell.getY()] = current.getY();
                    }
                }
            }

            return null;
        }

        private Cell reconstructPath(Cell start, Cell end) {

            Cell current = end;

            Cell finalCell = null;

            while (current.getX() != start.getX() || current.getY() != start.getY()) {
                int tempX = prevX[current.getX()][current.getY()];
                int tempY = prevY[current.getX()][current.getY()];
                if (tempX == start.getX() && tempY == start.getY()) {
                    finalCell = new Cell(current.getX(), current.getY());
                    break;
                }
                current.setX(tempX);
                current.setY(tempY);
            }

            return finalCell;
        }
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
    }
}