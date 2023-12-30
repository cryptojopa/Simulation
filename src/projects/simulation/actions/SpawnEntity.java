package projects.simulation.actions;

import projects.simulation.Cell;
import projects.simulation.Map;
import projects.simulation.entity.abstracts.Entity;
import projects.simulation.entity.creatures.Herbivore;
import projects.simulation.entity.creatures.Predator;
import projects.simulation.entity.props.Grass;
import projects.simulation.entity.props.Rock;
import projects.simulation.entity.props.Tree;
import projects.simulation.exceptions.AlreadyHaveEntityException;

import java.util.HashMap;
import java.util.Random;

public class SpawnEntity extends Action {
    private HashMap<Class<? extends Entity>, Integer> entities = new HashMap<>();

    private final int countOfEntities;

    public SpawnEntity() {
        entities.put(Herbivore.class, 5);
        entities.put(Predator.class, 2);
        entities.put(Grass.class, 10);
        entities.put(Tree.class, 10);
        entities.put(Rock.class, 10);
        this.countOfEntities = entities.values().stream().mapToInt(Integer::intValue).sum();
    }

    public SpawnEntity(HashMap<Class<? extends Entity>, Integer> entities) {
        this.entities = entities;
        this.countOfEntities = entities.values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public void makeAction(Map map) {
        if (map.getCountOfEmptyCells() < countOfEntities) {
            System.out.println("Нет места для такого кол-ва сущностей");
            return;
        }

        for (Class<? extends Entity> entity : entities.keySet()) {
            int entityCount = entities.get(entity);
            for (int i = 0; i < entityCount; i++) {
                Cell cell = generateRandomCell(map);
                try {
                    Entity newEntity = entity.getDeclaredConstructor().newInstance();
                    map.setEntity(cell, newEntity);
                } catch (AlreadyHaveEntityException e) {
                    handleAlreadyHaveEntityException(map, entity);
                } catch (Exception e) {
                    System.out.printf("При спавне %s что-то пошло не так", entity.getSimpleName());
                }
            }
        }
    }

    private Cell generateRandomCell(Map map) {
        Random ran = new Random();
        return new Cell(ran.nextInt(map.getMaxX()), ran.nextInt(map.getMaxY()));
    }

    private void handleAlreadyHaveEntityException(Map map, Class<? extends Entity> entity) {
        boolean success = false;
        while (!success) {
            Cell cell = generateRandomCell(map);
            try {
                Entity newEntity = entity.getDeclaredConstructor().newInstance();
                map.setEntity(cell, newEntity);
                success = true;
            } catch (Exception ignored) {
            }
        }
    }
}
