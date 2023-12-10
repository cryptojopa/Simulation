//package projects.simulation.actions;
//
//import projects.simulation.Map;
//import projects.simulation.actions.Actions;
//import projects.simulation.entity.abstractEntity.Creature;
//import projects.simulation.entity.abstractEntity.Entity;
//
//public class MoveAllAction extends Actions {
//    @Override
//    public void makeAction(Map map) {
//        for (int y = 0; y < map.getMaxY(); y++) {
//            for (int x = 0; x < map.getLine(y).length; x++) {
//                Entity entity = map.getEntity(x, y);
//                if (entity instanceof Creature) {
//                    try {
//                        ((Creature) entity).makeMove(map);
//                    } catch (ArrayIndexOutOfBoundsException e) {
//                        continue;
//                    }
//                }
//            }
//        }
//    }
//}
