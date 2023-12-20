package projects.simulation;

import projects.simulation.actions.Action;
import projects.simulation.actions.MoveAll;
import projects.simulation.actions.SpawnEntity;
import projects.simulation.actions.CheckForRespawn;

import java.util.Arrays;
import java.util.List;

public class Simulation {
    private static final Map map = new Map(10, 10);

    private static final List<Action> initActions = List.of(new SpawnEntity());
    private static final List<Action> turnActions = Arrays.asList(new MoveAll(), new CheckForRespawn());


    public static void main(String[] args) {
        initActions.forEach(action -> action.makeAction(map));

        map.render();
        System.out.println();

        startSimulation();
    }

    private static void startSimulation() {
        while (true) {
            turnActions.forEach(action -> action.makeAction(map));
            map.render();
            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void pauseSimulation() {
    }

    private static void nextTurn() {
    }
}
