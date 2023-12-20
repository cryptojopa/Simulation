package projects.simulation;

import projects.simulation.actions.Action;
import projects.simulation.actions.MoveAll;
import projects.simulation.actions.SpawnEntity;
import projects.simulation.entity.abstracts.Entity;
import projects.simulation.entity.creatures.Herbivore;
import projects.simulation.entity.creatures.Predator;
import projects.simulation.entity.props.Grass;
import projects.simulation.entity.props.Rock;
import projects.simulation.entity.props.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Simulation {
    private static Map  map = new Map(10, 10);
    private static final HashMap<Class<? extends Entity>, Integer> entitiesForSpawn = new HashMap<>();

    static {
        entitiesForSpawn.put(Herbivore.class, 1);
//        entitiesForSpawn.put(Predator.class, 1);
        entitiesForSpawn.put(Grass.class, 1);
        entitiesForSpawn.put(Tree.class, 20);
        entitiesForSpawn.put(Rock.class, 10);
    }

    private static final List<Action> initActions = Arrays.asList(new Action[]{new SpawnEntity(entitiesForSpawn)});
    private static List<Action> turnActions = Arrays.asList(new Action[]{new MoveAll()});


    public static void main(String[] args) {
        initActions.forEach(action -> action.makeAction(map));

//        map.render();
        System.out.println();

        Herbivore herbivore = new Herbivore();
        Predator predator = new Predator();
        startSimulation();

    }

    public static void startSimulation() {
        while (true) {
            turnActions.forEach(action -> action.makeAction(map));

            if (map.getEntities().stream().noneMatch(Grass.class::isInstance)) {
                SpawnEntity spawnEntity = new SpawnEntity(new HashMap<>() {{
                    put(Grass.class, 5);
                }});
                spawnEntity.makeAction(map);
            }

            map.render();
            System.out.println();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void pauseSimulation() {
    }

    public static void nextTurn() {

    }
}
