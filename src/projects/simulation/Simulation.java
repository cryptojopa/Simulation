package projects.simulation;

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
//        HashMap<Class<? extends Entity>, Integer> hashMap = new HashMap<>();
//        hashMap.put(Herbivore.class, 5);
//        hashMap.put(Predator.class, 6);
//        hashMap.put(Grass.class, 3);
//        hashMap.put(Tree.class, 5);

//        SpawnEntity spawnEntity = new SpawnEntity(hashMap);
//        spawnEntity.makeAction(map);
//        startSimulation();

        Herbivore herbivore = new Herbivore();
        Rock rock = new Rock();
        try {
            map.setEntity(new Cell(0, 0), herbivore);
            map.setEntity(new Cell(5, 3), new Rock());
            map.setEntity(new Cell(5, 2), new Rock());
            map.setEntity(new Cell(5, 1), new Rock());
            map.setEntity(new Cell(5, 0), new Rock());
            map.setEntity(new Cell(5, 4), new Rock());
            map.setEntity(new Cell(4, 6), new Rock());
            map.setEntity(new Cell(6, 5), new Rock());
            map.setEntity(new Cell(8, 5), new Grass());
            map.setEntity(new Cell(9, 1), new Grass());
            map.setEntity(new Cell(3, 7), new Grass());
        } catch (AlreadyHaveEntityException | OutOfMapException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            herbivore.makeMove(map);
            map.render();
            System.out.println();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void startSimulation() {

//            boolean flag = KeyEvent.getKeyText(KeyEvent.KEY_TYPED).equals("Shift");
//            if (flag) {
//                System.out.println("пиздец");
//            }
    }

    public static void pauseSimulation() {

    }

    public static void nextTurn() {

    }
}
