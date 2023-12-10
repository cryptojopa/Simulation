package projects.simulation;

import projects.simulation.actions.SpawnEntity;
import projects.simulation.entity.abstracts.Entity;
import projects.simulation.entity.creatures.Herbivore;
import projects.simulation.entity.creatures.Predator;
import projects.simulation.entity.props.Grass;
import projects.simulation.exceptions.AlreadyHaveEntityException;

import java.util.HashMap;

public class Simulation {
    private static Map map = new Map(10, 10);
//    static List<Actions> initActions = Arrays.asList(new Actions[]{new CreateEntitiesAction()});
//    static List<Actions> turnActions;


    public static void main(String[] args) {
        HashMap<Class<? extends Entity>, Integer> hashMap = new HashMap<>();
        hashMap.put(Herbivore.class, 5);
        hashMap.put(Predator.class, 6);
        hashMap.put(Grass.class, 10);
        startSimulation();

        SpawnEntity spawnEntity = new SpawnEntity(hashMap);
        spawnEntity.makeAction(map);
        startSimulation();

    }

    public static void startSimulation() {
        map.render();
        System.out.println();
    }
}
