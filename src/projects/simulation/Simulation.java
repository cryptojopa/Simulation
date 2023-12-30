package projects.simulation;

import projects.simulation.actions.Action;
import projects.simulation.actions.MoveAll;
import projects.simulation.actions.SpawnEntity;
import projects.simulation.actions.CheckForRespawn;

import java.util.Arrays;
import java.util.List;

public class Simulation {
    private static final Map map = new Map(20, 20);

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
            nextTurn();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void pauseSimulation() {
        //не знаю, как реализовать в консольном приложении. вернусь к этому, если буду реализовывать графический интерфейс
    }

    private static void nextTurn() {
        map.render();
    }
}
