package projects.simulation;

import projects.simulation.abstractEntity.Entity;

import java.util.HashMap;
//import projects.simulation.entity.Void;

public class Map {
    private HashMap<Point, Entity> map;
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


    public void setEntity(Point point, Entity entity) {
        if (point.getX() < maxX && point.getX() > 0 && point.getY() < maxY && point.getY() > 0) {
            map.put(point, entity);
        }
    }

    public void removeEntity(Point point) {
        map.remove(point);
    }

    public Entity getObject(Point point) {
        return map.getOrDefault(point, null);
    }

    public boolean isPointEmpty(Point point) {
        return map.containsKey(point);

    public void render() {
        for (Entity[] list: map) {
            for (Entity entity: list) {
                if (entity == null) {
                    System.out.print("\uD83D\uDFE9 " );
                }
                else {
                    System.out.print(entity + " ");
                }

            }
            System.out.println();
        }
    }
}