package projects.simulation.actions;

import projects.simulation.Map;
import projects.simulation.entity.abstracts.Entity;
import projects.simulation.entity.creatures.Herbivore;
import projects.simulation.entity.props.Grass;

import java.util.HashMap;

public class CheckForRespawn extends Action {
    private final HashMap<Class<? extends Entity>, Integer> amountForRespawn = new HashMap<>();

    public CheckForRespawn() {
        amountForRespawn.put(Grass.class, 5);
        amountForRespawn.put(Herbivore.class, 3);
    }

    @Override
    public void makeAction(Map map) {
        amountForRespawn.keySet().stream()
                .filter(entity -> !map.haveEntity(entity))
                .forEach(entity -> {
                    SpawnEntity spawnEntity = new SpawnEntity(new HashMap<>() {{
                        put(entity, amountForRespawn.get(entity));
                    }});
                    spawnEntity.makeAction(map);
                });
    }
}
