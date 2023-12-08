package projects.simulation.abstractEntity;

import projects.simulation.Point;
import projects.simulation.enums.Direction;

public abstract class Entity {
    private Point point;

    public Entity(Point point) {
        this.point = point;
    }

    public Point getPoint() {
        return point;
    }


    public void setPoint(Point point) {
        this.point = point;
    }

    public int getX() {
        return point.getX();
    }

    public int getY() {
        return point.getY();
    }

    public abstract boolean isResource();
}
