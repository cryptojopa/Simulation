package projects.simulation;

import projects.simulation.abstractEntity.Actions;
import projects.simulation.actions.CreateEntitiesAction;
import projects.simulation.actions.MoveAllAction;
import projects.simulation.creatures.Herbivore;
import projects.simulation.creatures.Predator;
import projects.simulation.entity.Rock;

import java.util.Arrays;
import java.util.List;

public class Simulation {
    private static Map map = new Map(10, 10);
//    static List<Actions> initActions = Arrays.asList(new Actions[]{new CreateEntitiesAction()});
    static List<Actions> turnActions;


    public static void main(String[] args) {
        Predator predator = new Predator();
        String[] clas = predator.getClass().toString().split("\\.");
        System.out.println(clas[clas.length -1]);
//        map.setObject(1, 1, new Herbivore());



        CreateEntitiesAction createEntities = new CreateEntitiesAction();
        createEntities.makeAction(map);
        MoveAllAction moveAll = new MoveAllAction();
        startSimulation();

        moveAll.makeAction(map);
        startSimulation();

        moveAll.makeAction(map);
        startSimulation();

        moveAll.makeAction(map);
        startSimulation();
    }

    public static void startSimulation() {
        map.render();
        System.out.println();
    }
}
