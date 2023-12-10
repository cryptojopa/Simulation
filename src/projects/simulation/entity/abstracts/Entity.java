package projects.simulation.entity.abstracts;

import projects.simulation.Cell;

public abstract class Entity {
    private Cell cell;

    public Entity(Cell cell) {
        this.cell = cell;
    }

    protected Entity() {
    }

    public Cell getCell() {
        return cell;
    }


    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public int getX() {
        return cell.getX();
    }

    public int getY() {
        return cell.getY();
    }

}
