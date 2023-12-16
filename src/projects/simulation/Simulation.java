package projects.simulation;

import projects.simulation.actions.MoveAllAction;
import projects.simulation.actions.SpawnEntity;
import projects.simulation.entity.abstracts.Entity;
import projects.simulation.entity.creatures.Herbivore;
import projects.simulation.entity.creatures.Predator;
import projects.simulation.entity.props.Grass;
import projects.simulation.entity.props.Rock;
import projects.simulation.entity.props.Tree;
import projects.simulation.exceptions.AlreadyHaveEntityException;
import projects.simulation.exceptions.OutOfMapException;

import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Simulation {
    private static Map map = new Map(10, 10);

//    static List<Actions> initActions = Arrays.asList(new Actions[]{new CreateEntitiesAction()});
//    static List<Actions> turnActions;


    public static void main(String[] args){
        HashMap<Class<? extends Entity>, Integer> hashMap = new HashMap<>();
        hashMap.put(Herbivore.class, 1);
//        hashMap.put(Predator.class, 2);
        hashMap.put(Grass.class, 5);
        hashMap.put(Tree.class, 20);
//        hashMap.put(Rock.class, 10);

        SpawnEntity spawnEntity = new SpawnEntity(hashMap);
        MoveAllAction moveAllAction = new MoveAllAction();
        spawnEntity.makeAction(map);


//        Herbivore herbivore = new Herbivore();
//        Rock rock = new Rock();
//        try {
//            map.setEntity(new Cell(1, 0), herbivore);
//
//            map.setEntity(new Cell(0, 0), new Rock());
////            map.setEntity(new Cell(1, 0), new Rock());
//            map.setEntity(new Cell(0, 1), new Rock());
//            map.setEntity(new Cell(0, 2), new Rock());
//            map.setEntity(new Cell(0, 3), new Rock());
//            map.setEntity(new Cell(0, 4), new Rock());
//            map.setEntity(new Cell(1, 4), new Rock());
//
//            map.setEntity(new Cell(2, 1), new Rock());
//            map.setEntity(new Cell(2, 2), new Rock());
//
//            map.setEntity(new Cell(4, 0), new Rock());
//            map.setEntity(new Cell(4, 1), new Rock());
//            map.setEntity(new Cell(4, 2), new Rock());
//            map.setEntity(new Cell(4, 3), new Rock());
//            map.setEntity(new Cell(4, 4), new Rock());
//            map.setEntity(new Cell(3, 4), new Rock());
//
//            map.setEntity(new Cell(2, 5), new Grass());
//
//        } catch (AlreadyHaveEntityException | OutOfMapException e) {
//            throw new RuntimeException(e);
//        }

        while (true) {
            moveAllAction.makeAction(map);
            map.render();
            System.out.println();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void startSimulation() {

//            boolean flag = KeyEvent.getKeyText(KeyEvent.KEY_TYPED).equals("Shift");
//            if (flag) {
//                System.out.println("");
//            }
    }

    public static void pauseSimulation() {

    }

    public static void nextTurn() {

    }
}
