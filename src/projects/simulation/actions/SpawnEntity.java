package projects.simulation.actions;

import projects.simulation.Cell;
import projects.simulation.Map;
import projects.simulation.entity.abstracts.Entity;
import projects.simulation.exceptions.AlreadyHaveEntityException;

import java.util.HashMap;
import java.util.Random;

public class SpawnEntity extends Actions {
    private final HashMap<Class<? extends Entity>, Integer> entities;
    private final int countOfEntities;

    public SpawnEntity(HashMap<Class<? extends Entity>, Integer> entities) {
        this.entities = entities;
        this.countOfEntities = entities.values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public void makeAction(Map map) {
        Random ran = new Random();

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
                    handleAlreadyHaveEntityException(map, entity, ran);
                } catch (Exception e) {
                    System.out.println("Что-то пошло не так");
                }
            }
        }
    }

    private Cell generateRandomCell(Map map) {
        Random ran = new Random();
        return new Cell(ran.nextInt(map.getMaxX()), ran.nextInt(map.getMaxY()));
    }

    private void handleAlreadyHaveEntityException(Map map, Class<? extends Entity> entity, Random ran) {
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
