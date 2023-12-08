//package projects.simulation.actions;
//
//import projects.simulation.Map;
//import projects.simulation.abstractEntity.Actions;
//import projects.simulation.abstractEntity.Creature;
//import projects.simulation.abstractEntity.Entity;
//import projects.simulation.creatures.Herbivore;
//import projects.simulation.creatures.Predator;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//
//public class CreateEntitiesAction extends Actions {
//
//    @Override
//    public void makeAction(Map map) {
//        List<Class<? extends Entity>> entities = Arrays.asList(Void.class, Grass.class, Void.class,
//                Rock.class, Void.class, Tree.class,Predator.class, Void.class, Void.class,  Herbivore.class, Void.class);
//        List<Class<? extends Entity>> entities = Arrays.asList(null, null, null, null, null, null, Herbivore.class);
//        Random random = new Random();
//
//        for ()
//        for (int i = 0; i < map.getMaxX(); i++) {
//            for (int j = 0; j < map.getMaxY(); j++) {
//                int randomIndex = random.nextInt(entities.size());
//                Class<? extends Entity> selectedEntities = entities.get(randomIndex);
//
//                try {
//                    Entity = selectedEntities.getDeclaredConstructor().newInstance();
//                    if (entity instanceof Herbivore || entity instanceof Predator) {
//                        ((Creature) entity).setX(j);
//                        ((Creature) entity).setY(i);
//                    }
//                    map.setEntity(j, i, entity);
//                } catch (NullPointerException e) {
//                    continue;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//    }
//}
//}
