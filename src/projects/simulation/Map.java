package projects.simulation;

import projects.simulation.abstractEntity.Entity;

import javax.sound.midi.Soundbank;
import java.util.HashMap;
//import projects.simulation.entity.Void;

public class Map {
    private HashMap<Point, Entity> map = new HashMap<>();
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
        if (isPointEmpty(point) && point.getX() <= maxX && point.getX() >= 0 && point.getY() <= maxY && point.getY() >= 0) {
            map.put(point, entity);
        }
    }

    public void removeEntity(Point point) {
        map.remove(point);
    }

    public Entity getEntity(Point point) {
        Entity entity = map.get(point);
        if (map.get(point) != null) {
            return map.get(point);
        } else {
            return null;
        }
    }

    public boolean isPointEmpty(Point point) {
        return !map.containsKey(point);
    }

    public void render() {
        for (int i = 0; i < maxY; i++){
            for (int j = 0; j < maxX; j++) {
                if (getEntity(new Point(j, i)) == null) {
                    System.out.print("\uD83D\uDFE9 ");
                } else {
                    System.out.print(map.get(new Point(j, i)) + " ");
                }
            }
            System.out.println();
        }
    }
}