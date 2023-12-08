package projects.simulation;

import projects.simulation.abstractEntity.Actions;
//import projects.simulation.actions.CreateEntitiesAction;
//import projects.simulation.actions.MoveAllAction;
import projects.simulation.creatures.Herbivore;
import projects.simulation.creatures.Predator;
import projects.simulation.entity.Rock;

import java.util.Arrays;
import java.util.List;

public class Simulation {
    private static Map map = new Map(10, 10);
//    static List<Actions> initActions = Arrays.asList(new Actions[]{new CreateEntitiesAction()});
//    static List<Actions> turnActions;


    public static void main(String[] args) {
        Herbivore herbivore = new Herbivore(new Point(1, 0));
//        map.setObject(1, 1, new Herbivore());
        startSimulation();
        map.setEntity(new Point( 1, 0), herbivore);
        startSimulation();

        herbivore.makeMove(map);
        startSimulation();

        herbivore.makeMove(map);
        startSimulation();


//        CreateEntitiesAction createEntities = new CreateEntitiesAction();
//        createEntities.makeAction(map);
//        MoveAllAction moveAll = new MoveAllAction();
//        startSimulation();
//
//        moveAll.makeAction(map);
//        startSimulation();
//
//        moveAll.makeAction(map);
//        startSimulation();
//
//        moveAll.makeAction(map);
//        startSimulation();
    }

    public static void startSimulation() {
        map.render();
        System.out.println();
    }
}
